package com.smartbed.main;

import com.smartbed.grpc.SendMessageRequest;
import com.smartbed.grpc.SendMessageResponse;
import com.smartbed.grpc.UpdateChatRequest;
import com.smartbed.grpc.UpdateChatResponse;
import com.smartbed.grpc.CommsServiceGrpc.CommsServiceImplBase;

import io.grpc.stub.StreamObserver;

/**
 * SmartbedCommsService - a class that defines the SmartBed CommsService methods
 *
 * @author Tim Winwood - x20213638
 * @version 1.0
 */
public class SmartbedCommsService extends CommsServiceImplBase  {
	
	// stores the chat history
	String messages = "";
	
	
	/**
	 * send a chat message
	 * 
	 * @param responseObserver the StreamObserver<SendMessageResponse>
	 */
	public StreamObserver<SendMessageRequest> sendMessage(StreamObserver<SendMessageResponse> responseObserver) {
		
		// return a new StreamObserver<SendMessageResponse>
		return new StreamObserver<SendMessageRequest> () {

			@Override
			public void onNext(SendMessageRequest value) {
				
				// get the user and message from the request
				String user = value.getUser();
				String message = value.getMessage();
				String chat = user + ": " + message + "\n";
				System.out.println("Server side User: " + value.getUser() + " Message: " + message);

				// add the chat to the chat history
				messages += chat;
				
				// build and send the response
				SendMessageResponse response = SendMessageResponse.newBuilder().setUser(value.getUser()).setMessage(messages).build();
				responseObserver.onNext(response);
				
			}

			@Override
			public void onError(Throwable t) {
				
				t.printStackTrace();
				
			}

			@Override
			public void onCompleted() {
				
				System.out.println("sendMessage Stream complete");
				responseObserver.onCompleted();
				
			}
			
		};
	}
	
	/**
	 * update the chat
	 * 
	 * @param request the UpdateChatRequest
	 * @param responseObserver the StreamObserver<UpdateChatResponse>
	 */
	public void updateChat(UpdateChatRequest request,
			StreamObserver<UpdateChatResponse> responseObserver) {

		// get the requesting user
		String user = request.getUser();

		// infinite while loop
		while(true) {

			// build and send the response containing the current chat log
			UpdateChatResponse reply = UpdateChatResponse.newBuilder().setMessage(messages).build();
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
