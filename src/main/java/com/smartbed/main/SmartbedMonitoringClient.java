package com.smartbed.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.jmdns.ServiceInfo;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.smartbed.grpc.CurrentBedUsageRequest;
import com.smartbed.grpc.CurrentBedUsageResponse;
import com.smartbed.grpc.SendMessageRequest;
import com.smartbed.grpc.SendMessageResponse;
import com.smartbed.grpc.UpdateChatRequest;
import com.smartbed.grpc.UpdateChatResponse;
import com.smartbed.grpc.BedServiceGrpc.BedServiceBlockingStub;
import com.smartbed.grpc.BedServiceGrpc.BedServiceStub;
import com.smartbed.grpc.CommsServiceGrpc.CommsServiceBlockingStub;
import com.smartbed.grpc.CommsServiceGrpc.CommsServiceStub;
import com.smartbed.ui.SmartbedMonitoringClientUI;
import io.grpc.stub.StreamObserver;
import javafx.application.Platform;

/**
 * SmartbedMonitoringClient - a class to create and run a gRPC client (SmartbedMonitoringClient)
 *
 * @author Tim Winwood - x20213638
 * @version 1.0
 */
public class SmartbedMonitoringClient implements ActionListener {

	// declare variables
	
	// service stubs
	private static BedServiceBlockingStub bedBlockingStub;
	private static BedServiceStub bedAsyncStub;
	
	private static CommsServiceBlockingStub commsBlockingStub;
	private static CommsServiceStub commsAsyncStub;

	
	// buttons
	private JButton btnSend;
	
	// the SmartbedMonitoringClientUI 
	SmartbedMonitoringClientUI smartbedMonitoringClientUI;

	/**
	 * entry point to the application
	 * 
	 * @param args unused
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		new SmartbedMonitoringClient();
		
	}
	
	/**
	 * constructor - used to initialise a SmartbedMonitoringClient object
	 * 
	 */
	public SmartbedMonitoringClient() {
	
		// initialise and show the SmartbedMonitoringClientUI
		smartbedMonitoringClientUI = new SmartbedMonitoringClientUI();
		smartbedMonitoringClientUI.createAndShowGUI();
		
		// add a FocusLister to the Chat Message field
		// so that the 'message' placeholder text will appear/disappear when the user clicks in the field
		JTextField fieldChatMessage = smartbedMonitoringClientUI.getFieldChatMessage();
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
		
		// get the button and add an action listener
		btnSend = smartbedMonitoringClientUI.getBtnSend();
		btnSend.addActionListener(this);
		
		// initialise the SmartbedJMDNSManager and get the blocking and async stubs for each service
		SmartbedJMDNSManager smartbedJMDNSManager = new SmartbedJMDNSManager();
		smartbedJMDNSManager.initStubs();
		
		bedBlockingStub = smartbedJMDNSManager.getBedBlockingStub();
		bedAsyncStub =  smartbedJMDNSManager.getBedAsyncStub();
		
		commsBlockingStub = smartbedJMDNSManager.getCommsBlockingStub();
		commsAsyncStub =  smartbedJMDNSManager.getCommsAsyncStub();
		
		// get the current bed usage and update the chart
		currentBedUsageAsync();
		
		// get the updated chat and update the text area
		updateChatAsync();
	}

		/**
		 * gets the current bed usage asynchronous - tasks can run at the same time
		 * 
		 */
		public void currentBedUsageAsync() {

			// min and max values
			int min = 0;
			int max = 80;

			// build and send the request
			CurrentBedUsageRequest request = CurrentBedUsageRequest.newBuilder().setMin(min).setMax(max).build();
			StreamObserver<CurrentBedUsageResponse> responseObserver = new StreamObserver<CurrentBedUsageResponse>() {

				@Override
				public void onNext(CurrentBedUsageResponse value) {

					System.out.println("Current Bed Usage: " + value.getBedCount());
					
					// get the current bed count
					int y = value.getBedCount();
					
					// set the y value of the graph to the current bed count
		            Platform.runLater(new Runnable() {

		                @Override public void run() {
		                	smartbedMonitoringClientUI.updateLineChart(y);
		                }
		            });
					
					
				}

				@Override
				public void onError(Throwable t) {
					t.printStackTrace();

				}

				@Override
				public void onCompleted() {
					System.out.println("currentBedUsage Stream Complete.");
				}

			};

			// call the currentBedUsage method
			bedAsyncStub.currentBedUsage(request, responseObserver);

			try {
				
				// sleep for 1 second
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		
		
		/**
		 * update the chat
		 * asynchronous - tasks can run at the same time
		 * 
		 */
		public void updateChatAsync() {

			String user = "Manager";

			// build and send the request
			UpdateChatRequest request = UpdateChatRequest.newBuilder().setUser(user).build();
			StreamObserver<UpdateChatResponse> responseObserver = new StreamObserver<UpdateChatResponse>() {

				@Override
				public void onNext(UpdateChatResponse value) {
					
					// if the message is not empty, update the text area
					if(!value.getMessage().equals("")) {
						smartbedMonitoringClientUI.getAreaChat().setText(value.getMessage());
					}

				}

				@Override
				public void onError(Throwable t) {
					t.printStackTrace();

				}

				@Override
				public void onCompleted() {
					System.out.println("Stream Complete.");
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
		 * send a message
		 * asynchronous - tasks can run at the same time
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
					
					System.out.println("sendMessage Stream is Completed");
					
					// set the message field back to the "message" placeholder
					smartbedMonitoringClientUI.getFieldChatMessage().setText("message");
				}

			};

			// call sendMessage method and get a handle on the request using requestObserver
			StreamObserver<SendMessageRequest> requestObserver = commsAsyncStub.sendMessage(responseObserver);

			try {
				
				// get the message details
				String user = "Manager";
				String message = smartbedMonitoringClientUI.getFieldChatMessage().getText();
				
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
				e.printStackTrace();
			}
		

		}
	

	/**
	 * Called when a component Fires an ActionEvent
	 *
	 */
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnSend){
			
			// send message
			sendMessageAsync();
			
		}

	}


}
