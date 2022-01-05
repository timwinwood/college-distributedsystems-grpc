package com.smartbed.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.google.protobuf.ByteString;
import com.smartbed.grpc.AddPatientRequest;
import com.smartbed.grpc.AddPatientRequest.Gender;
import com.smartbed.grpc.AddPatientResponse;
import com.smartbed.grpc.BedServiceGrpc.BedServiceBlockingStub;
import com.smartbed.grpc.BedServiceGrpc.BedServiceStub;
import com.smartbed.grpc.CommsServiceGrpc.CommsServiceBlockingStub;
import com.smartbed.grpc.CommsServiceGrpc.CommsServiceStub;
import com.smartbed.grpc.ImageInfo;
import com.smartbed.grpc.SendMessageRequest;
import com.smartbed.grpc.SendMessageResponse;
import com.smartbed.grpc.UpdateChatRequest;
import com.smartbed.grpc.UpdateChatResponse;
import com.smartbed.grpc.UploadPatientImageRequest;
import com.smartbed.grpc.UploadPatientImageResponse;
import com.smartbed.ui.SmartbedBookingClientUI;
import io.grpc.stub.StreamObserver;

/**
 * SmartbedBookingClient - a class to create and run a gRPC client (SmartbedBookingClient)
 *
 * @author Tim Winwood - x20213638
 * @version 1.0
 */
public class SmartbedBookingClient implements ActionListener {

	// declare variables

	// service stubs

	private static BedServiceBlockingStub bedBlockingStub;
	private static BedServiceStub bedAsyncStub;

	private static CommsServiceBlockingStub commsBlockingStub;
	private static CommsServiceStub commsAsyncStub;

	// buttons
	private JButton btnBook;
	private JButton btnSend;
	private JButton btnPhoto;

	// path to photo
	private String strPhotoPath;

	// the SmartbedBookingClientUI
	SmartbedBookingClientUI smartbedBookingClientUI;

	/**
	 * entry point to the application
	 * 
	 * @param args unused
	 */
	public static void main(String[] args) {

		new SmartbedBookingClient();

	}

	/**
	 * constructor - used to initialise a SmartbedBookingClient object
	 * 
	 */
	public SmartbedBookingClient() {

		// initialise and show the SmartbedBookingClientUI
		smartbedBookingClientUI = new SmartbedBookingClientUI();
		smartbedBookingClientUI.createAndShowGUI();

		// add a FocusLister to the Chat Message field
		// so that the 'message' placeholder text will appear/disappear when the user clicks in the field
		JTextField fieldChatMessage = smartbedBookingClientUI.getFieldChatMessage();
		fieldChatMessage.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (fieldChatMessage.getText().equals("message")) {
					fieldChatMessage.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (fieldChatMessage.getText().isEmpty()) {
					fieldChatMessage.setText("message");
				}
			}
		});

		// get the buttons and add action listeners
		btnBook = smartbedBookingClientUI.getBtnBook();
		btnBook.addActionListener(this);
		btnSend = smartbedBookingClientUI.getBtnSend();
		btnSend.addActionListener(this);
		btnPhoto = smartbedBookingClientUI.getBtnPhoto();
		btnPhoto.addActionListener(this);

		// initialise the SmartbedJMDNSManager and get the blocking and async stubs for each service
		SmartbedJMDNSManager smartbedJMDNSManager = new SmartbedJMDNSManager();
		smartbedJMDNSManager.initStubs();

		bedBlockingStub = smartbedJMDNSManager.getBedBlockingStub();
		bedAsyncStub = smartbedJMDNSManager.getBedAsyncStub();

		commsBlockingStub = smartbedJMDNSManager.getCommsBlockingStub();
		commsAsyncStub = smartbedJMDNSManager.getCommsAsyncStub();

		// get the updated chat and update the text area
		updateChatAsync();

	}

	/**
	 * Called when a component Fires an ActionEvent
	 *
	 */
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnBook) {

			// add the patient
			addPatientSync();

		} else if (e.getSource() == btnSend) {

			// send the message
			sendMessageAsync();

		} else if (e.getSource() == btnPhoto) {

			// prompt the user to select a file
			// Open JFileChooser in current directory
			File dir = new File(System.getProperty("user.dir"));
			JFileChooser c = new JFileChooser();
			c.setCurrentDirectory(dir);
			int rVal = c.showOpenDialog(null);
			if (rVal == JFileChooser.APPROVE_OPTION) {

				// store the file path
				strPhotoPath = c.getSelectedFile().getAbsolutePath();

			}

		}

	}

	/**
	 * uploads a patient image asynchronous - tasks can run at the same time
	 * 
	 */
	public void uploadPatientImageAsync(String message) {

		// Get the PPS and File path details
		String pps = smartbedBookingClientUI.getFieldPps().getText();
		String imageType = strPhotoPath.substring(strPhotoPath.lastIndexOf('.') + 1);
		String imagePath = strPhotoPath;
		final String successMessage = message + " Image: " + pps + "." + imageType;

		// create the StreamObserver<UploadPatientImageRequest>
		StreamObserver<UploadPatientImageRequest> requestObserver = bedAsyncStub.withDeadlineAfter(5, TimeUnit.SECONDS).uploadPatientImage(new StreamObserver<UploadPatientImageResponse>() {

			@Override
			public void onNext(UploadPatientImageResponse value) {

				// get the pps number and image size
				String pps = value.getPps();
				int size = value.getSize();
				System.out.println("Upload Patient Image for PPS Number: " + pps + " Image Size: " + size + " bytes.");
			}

			@Override
			public void onError(Throwable t) {

				System.out.println("Upload Patient Image has encountered an error");

			}

			@Override
			public void onCompleted() {

				// when the image has succesfully uploaded, show a message dialog
				System.out.println("Upload Patient Image Stream has completed");
				JOptionPane.showMessageDialog(null, successMessage, "Success", JOptionPane.INFORMATION_MESSAGE);
				smartbedBookingClientUI.getFieldFirst().setText("");
				smartbedBookingClientUI.getFieldLast().setText("");
				smartbedBookingClientUI.getFieldPps().setText("");
			}

		});

		try {

			// build and send the request with ImageInfo
			ImageInfo info = ImageInfo.newBuilder().setPps(pps).setImageType(imageType).build();
			UploadPatientImageRequest request = UploadPatientImageRequest.newBuilder().setInfo(info).build();
			requestObserver.onNext(request);

			// read the file in chunks
			FileInputStream fileInputStream = new FileInputStream(imagePath);
			byte[] buffer = new byte[1024];
			while (true) {
				int n = fileInputStream.read(buffer);
				if (n <= 0) {
					break;
				}
				// build and send the request with the image chunks
				request = UploadPatientImageRequest.newBuilder().setChunkData(ByteString.copyFrom(buffer, 0, n)).build();
				requestObserver.onNext(request);
			}

			// close the fileInputStream, and complete the stream
			fileInputStream.close();
			requestObserver.onCompleted();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * gets the current bed usage synchronous - tasks run one after another
	 * 
	 */
	public void addPatientSync() {

		// get the patient details from the form

		// Example:
		// String first = "Timothy";
		// String last = "Winwood";
		// String pps = "1234567VA";
		// Gender gender = Gender.forNumber(0)

		String first = smartbedBookingClientUI.getFieldFirst().getText();
		String last = smartbedBookingClientUI.getFieldLast().getText();
		String pps = smartbedBookingClientUI.getFieldPps().getText();
		Gender gender = Gender.forNumber(smartbedBookingClientUI.getComboGender().getSelectedIndex());

		// build and send the request
		AddPatientRequest req = AddPatientRequest.newBuilder().setFirst(first).setLast(last).setPps(pps).setGender(gender).build();
		AddPatientResponse response = bedBlockingStub.addPatient(req);
		int result = response.getResult();
		String message = response.getMessage();

		// if (result == 0), patient details are valid
		if (result == 0) {

			// clear the fields.
			System.out.println("Result: " + result + " Message: " + message);
			uploadPatientImageAsync(message);

			// else, patient details are invalid
		} else {

			// patient details invalid. warn the user.
			System.out.println("Result: " + result + " Message: " + message);
			JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.WARNING_MESSAGE);

		}

	}

	/**
	 * update the chat asynchronous - tasks can run at the same time
	 * 
	 */
	public void updateChatAsync() {

		String user = "Reception";

		// build and send the request
		UpdateChatRequest request = UpdateChatRequest.newBuilder().setUser(user).build();
		StreamObserver<UpdateChatResponse> responseObserver = new StreamObserver<UpdateChatResponse>() {

			@Override
			public void onNext(UpdateChatResponse value) {

				// if the message is not empty, update the text area
				if (!value.getMessage().equals("")) {
					smartbedBookingClientUI.getAreaChat().setText(value.getMessage());
				}

			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();

			}

			@Override
			public void onCompleted() {
				System.out.println("updateChat Stream Complete.");
			}

		};

		// Call the UpdateChat method
		commsAsyncStub.updateChat(request, responseObserver);

		try {
			// sleep for 1 second
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * send a message asynchronous - tasks can run at the same time
	 * 
	 */
	public void sendMessageAsync() {

		// create the StreamObserver<SendMessageResponse>
		StreamObserver<SendMessageResponse> responseObserver = new StreamObserver<SendMessageResponse>() {

			@Override
			public void onNext(SendMessageResponse value) {

				System.out.println("sendMessage - User: " + value.getUser() + " Message: " + value.getMessage());
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();

			}

			@Override
			public void onCompleted() {

				System.out.println("sendMessage - Stream is Completed");

				// set the message field back to the "message" placeholder
				smartbedBookingClientUI.getFieldChatMessage().setText("message");

			}

		};

		// call sendMessage method and get a handle on the request using requestObserver
		StreamObserver<SendMessageRequest> requestObserver = commsAsyncStub.sendMessage(responseObserver);

		try {

			// get the message details
			String user = "Reception";
			String message = smartbedBookingClientUI.getFieldChatMessage().getText();

			// build and send the request
			requestObserver.onNext(SendMessageRequest.newBuilder().setUser(user).setMessage(message).build());

			// end of requests
			requestObserver.onCompleted();

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		try {
			// sleep for 1 second
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
