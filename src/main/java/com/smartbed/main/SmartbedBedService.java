package com.smartbed.main;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import com.google.protobuf.ByteString;
import com.smartbed.grpc.AddPatientRequest;
import com.smartbed.grpc.AddPatientResponse;
import com.smartbed.grpc.CurrentBedUsageRequest;
import com.smartbed.grpc.CurrentBedUsageResponse;
import com.smartbed.grpc.ImageInfo;
import com.smartbed.grpc.UploadPatientImageRequest;
import com.smartbed.grpc.UploadPatientImageResponse;
import com.smartbed.grpc.AddPatientRequest.Gender;
import com.smartbed.grpc.BedServiceGrpc.BedServiceImplBase;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;

/**
 * SmartbedBedService - a class that defines the SmartBed BedService methods
 *
 * @author Tim Winwood - x20213638
 * @version 1.0
 */
public class SmartbedBedService extends BedServiceImplBase {
	
	
	/**
	 * add a patient to the smartbed system, checks if patient details are valid
	 * response
	 * |- if (result == 0), patient details are valid
	 * |- if (result == -1), patient details are invalid
	 * 
	 * @param request the AddPatientRequest
	 * @param responseObserver the StreamObserver<AddPatientResponse>
	 */
	public void addPatient(AddPatientRequest request, 
			StreamObserver<AddPatientResponse> responseObserver) {
		
		// get the patient details
		String first = request.getFirst();
		String last = request.getLast();
		String pps = request.getPps();
		Gender gender = request.getGender();
		
		boolean validFirst = false;
		boolean validLast = false;
		boolean validPps = false;
		boolean validGender = false;
		
		int result = -1;
		
		String message = "";
		
		// Validate the Patient Details
		
		// first
		if(first.matches("[a-zA-Z]+")) {
			validFirst = true;
		}else {
			message += "First Name must be Letters with no Spaces.";
		}
		
		// last
		if(last.matches("[a-zA-Z]+")) {
			validLast = true;
		}else {
			message += "Last Name must be Letters with no Spaces.";
		}
		
		// pps
		if(pps.matches("\\d{7}[a-zA-Z]{1,2}")) {
			validPps = true;
		}else {
			message += "PPS Number must match syntax \"1234567VA\".";
		}
		
		// gender
		if(gender != Gender.UNRECOGNIZED) {
			validGender = true;
		}else {
			message += "Gender Must be one of {\"Male\",\"Female\",\"Unspecified\"}.";
		}
		
		// check all details valid
		if(validFirst && validLast && validPps && validGender) {
			result = 0;
			message = "Patient added to Server - First: " + first + " Last: " + last + " PPS: " + pps + " Gender: " + gender.name();
		}

		// build and send the response
		AddPatientResponse reply = AddPatientResponse.newBuilder().setMessage(message).setResult(result).build();
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
	}
	
	
	/**
	 * upload a patient image
	 * this method receives the image in chunks and writes them to file
	 * 
	 * @param responseObserver the StreamObserver<UploadPatientImageResponse>
	 * 
	 * @return  StreamObserver<UploadPatientImageRequest> a new StreamObserver with methods overriden
	 */
	@Override
	public StreamObserver<UploadPatientImageRequest> uploadPatientImage(StreamObserver<UploadPatientImageResponse> responseObserver) {
	
		return new StreamObserver<UploadPatientImageRequest>() {
			
			// declare local variables
			private String pps;
			private String imageType;
			private ByteArrayOutputStream imageData;

			@Override
			public void onNext(UploadPatientImageRequest value) {
				
				// If the request is ImageInfo, process the ImageInfo
				// Note: The first request must be ImageInfo
				if(value.getDataCase() == UploadPatientImageRequest.DataCase.INFO) {
					ImageInfo info = value.getInfo();
					
					pps = info.getPps();
					imageType = info.getImageType();
					imageData = new ByteArrayOutputStream();
					
					return;
					
				// Else, the request is the image in chunks, process the chunks	
				}else {
					
					try {
						
					ByteString chunkData = value.getChunkData();

					// Client has not sent image data yet, return an error
					if(imageData == null) {
						responseObserver.onError(
						Status.INVALID_ARGUMENT.withDescription("Client must sent ImageInfo before data chunks").asRuntimeException()
						);
						return;
					}
						// else, write the chunk to the image data
						chunkData.writeTo(imageData);
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return;
					}
					
				}
				
				
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("Error uploading patient image");
				
			}

			@Override
			public void onCompleted() {
				
				// write the image to file
				String imagePath = "images/server/" + pps + "." + imageType;
				
				// get the image size to send back in the response
				int size = imageData.size();

				try {
					
					// write the image to file
					FileOutputStream fileOutputStream = new FileOutputStream(imagePath);
					imageData.writeTo(fileOutputStream);
					fileOutputStream.close();
					
					// build and send the response
					UploadPatientImageResponse response = UploadPatientImageResponse.newBuilder().setPps(pps).setSize(size).build();
					responseObserver.onNext(response);
					responseObserver.onCompleted();

				}catch(Exception e) {
					e.printStackTrace();
				}
	
			}

		};
	}
	
	/**
	 * get the current bed usage in the smartbed system
	 * this method generates a random number between min and max to make the graph data more interesting
	 * in production, this would return the actual bed count.
	 * 
	 * @param request the CurrentBedUsageRequest
	 * @param responseObserver the StreamObserver<CurrentBedUsageResponse>
	 */
	public void currentBedUsage(CurrentBedUsageRequest request,
			StreamObserver<CurrentBedUsageResponse> responseObserver) {

		// get the min and max from the request
		int min = request.getMin();
		int max = request.getMax();
		
		Random r = new Random();

		// infinite while loop
		while(true) {

			// generate random number between min and max
			int intRand = r.nextInt(max-min) + min;
	
			// build and send the response
			CurrentBedUsageResponse reply = CurrentBedUsageResponse.newBuilder().setBedCount(intRand).build();
			responseObserver.onNext(reply);

			try {
				// sleep for 1 second
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// Note: In this instance we are using an infinite while loop, therefore the onCompleted() method is never called
		//responseObserver.onCompleted();


	}

}
