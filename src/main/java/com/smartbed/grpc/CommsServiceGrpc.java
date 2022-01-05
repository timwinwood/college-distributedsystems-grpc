package com.smartbed.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Service Definition
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: commsservice.proto")
public final class CommsServiceGrpc {

  private CommsServiceGrpc() {}

  public static final String SERVICE_NAME = "grpc.CommsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.smartbed.grpc.SendMessageRequest,
      com.smartbed.grpc.SendMessageResponse> getSendMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendMessage",
      requestType = com.smartbed.grpc.SendMessageRequest.class,
      responseType = com.smartbed.grpc.SendMessageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.smartbed.grpc.SendMessageRequest,
      com.smartbed.grpc.SendMessageResponse> getSendMessageMethod() {
    io.grpc.MethodDescriptor<com.smartbed.grpc.SendMessageRequest, com.smartbed.grpc.SendMessageResponse> getSendMessageMethod;
    if ((getSendMessageMethod = CommsServiceGrpc.getSendMessageMethod) == null) {
      synchronized (CommsServiceGrpc.class) {
        if ((getSendMessageMethod = CommsServiceGrpc.getSendMessageMethod) == null) {
          CommsServiceGrpc.getSendMessageMethod = getSendMessageMethod = 
              io.grpc.MethodDescriptor.<com.smartbed.grpc.SendMessageRequest, com.smartbed.grpc.SendMessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "grpc.CommsService", "SendMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartbed.grpc.SendMessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartbed.grpc.SendMessageResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CommsServiceMethodDescriptorSupplier("SendMessage"))
                  .build();
          }
        }
     }
     return getSendMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.smartbed.grpc.UpdateChatRequest,
      com.smartbed.grpc.UpdateChatResponse> getUpdateChatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateChat",
      requestType = com.smartbed.grpc.UpdateChatRequest.class,
      responseType = com.smartbed.grpc.UpdateChatResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.smartbed.grpc.UpdateChatRequest,
      com.smartbed.grpc.UpdateChatResponse> getUpdateChatMethod() {
    io.grpc.MethodDescriptor<com.smartbed.grpc.UpdateChatRequest, com.smartbed.grpc.UpdateChatResponse> getUpdateChatMethod;
    if ((getUpdateChatMethod = CommsServiceGrpc.getUpdateChatMethod) == null) {
      synchronized (CommsServiceGrpc.class) {
        if ((getUpdateChatMethod = CommsServiceGrpc.getUpdateChatMethod) == null) {
          CommsServiceGrpc.getUpdateChatMethod = getUpdateChatMethod = 
              io.grpc.MethodDescriptor.<com.smartbed.grpc.UpdateChatRequest, com.smartbed.grpc.UpdateChatResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "grpc.CommsService", "UpdateChat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartbed.grpc.UpdateChatRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartbed.grpc.UpdateChatResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CommsServiceMethodDescriptorSupplier("UpdateChat"))
                  .build();
          }
        }
     }
     return getUpdateChatMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CommsServiceStub newStub(io.grpc.Channel channel) {
    return new CommsServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CommsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CommsServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CommsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CommsServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static abstract class CommsServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.smartbed.grpc.SendMessageRequest> sendMessage(
        io.grpc.stub.StreamObserver<com.smartbed.grpc.SendMessageResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getSendMessageMethod(), responseObserver);
    }

    /**
     */
    public void updateChat(com.smartbed.grpc.UpdateChatRequest request,
        io.grpc.stub.StreamObserver<com.smartbed.grpc.UpdateChatResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateChatMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendMessageMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.smartbed.grpc.SendMessageRequest,
                com.smartbed.grpc.SendMessageResponse>(
                  this, METHODID_SEND_MESSAGE)))
          .addMethod(
            getUpdateChatMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.smartbed.grpc.UpdateChatRequest,
                com.smartbed.grpc.UpdateChatResponse>(
                  this, METHODID_UPDATE_CHAT)))
          .build();
    }
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static final class CommsServiceStub extends io.grpc.stub.AbstractStub<CommsServiceStub> {
    private CommsServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CommsServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommsServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CommsServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.smartbed.grpc.SendMessageRequest> sendMessage(
        io.grpc.stub.StreamObserver<com.smartbed.grpc.SendMessageResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void updateChat(com.smartbed.grpc.UpdateChatRequest request,
        io.grpc.stub.StreamObserver<com.smartbed.grpc.UpdateChatResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getUpdateChatMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static final class CommsServiceBlockingStub extends io.grpc.stub.AbstractStub<CommsServiceBlockingStub> {
    private CommsServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CommsServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommsServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CommsServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.smartbed.grpc.UpdateChatResponse> updateChat(
        com.smartbed.grpc.UpdateChatRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getUpdateChatMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static final class CommsServiceFutureStub extends io.grpc.stub.AbstractStub<CommsServiceFutureStub> {
    private CommsServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CommsServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommsServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CommsServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_UPDATE_CHAT = 0;
  private static final int METHODID_SEND_MESSAGE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CommsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CommsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UPDATE_CHAT:
          serviceImpl.updateChat((com.smartbed.grpc.UpdateChatRequest) request,
              (io.grpc.stub.StreamObserver<com.smartbed.grpc.UpdateChatResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_MESSAGE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sendMessage(
              (io.grpc.stub.StreamObserver<com.smartbed.grpc.SendMessageResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CommsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CommsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.smartbed.grpc.CommsServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CommsService");
    }
  }

  private static final class CommsServiceFileDescriptorSupplier
      extends CommsServiceBaseDescriptorSupplier {
    CommsServiceFileDescriptorSupplier() {}
  }

  private static final class CommsServiceMethodDescriptorSupplier
      extends CommsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CommsServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CommsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CommsServiceFileDescriptorSupplier())
              .addMethod(getSendMessageMethod())
              .addMethod(getUpdateChatMethod())
              .build();
        }
      }
    }
    return result;
  }
}
