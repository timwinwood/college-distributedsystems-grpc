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
    comments = "Source: bedservice.proto")
public final class BedServiceGrpc {

  private BedServiceGrpc() {}

  public static final String SERVICE_NAME = "grpc.BedService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.smartbed.grpc.AddPatientRequest,
      com.smartbed.grpc.AddPatientResponse> getAddPatientMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddPatient",
      requestType = com.smartbed.grpc.AddPatientRequest.class,
      responseType = com.smartbed.grpc.AddPatientResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.smartbed.grpc.AddPatientRequest,
      com.smartbed.grpc.AddPatientResponse> getAddPatientMethod() {
    io.grpc.MethodDescriptor<com.smartbed.grpc.AddPatientRequest, com.smartbed.grpc.AddPatientResponse> getAddPatientMethod;
    if ((getAddPatientMethod = BedServiceGrpc.getAddPatientMethod) == null) {
      synchronized (BedServiceGrpc.class) {
        if ((getAddPatientMethod = BedServiceGrpc.getAddPatientMethod) == null) {
          BedServiceGrpc.getAddPatientMethod = getAddPatientMethod = 
              io.grpc.MethodDescriptor.<com.smartbed.grpc.AddPatientRequest, com.smartbed.grpc.AddPatientResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "grpc.BedService", "AddPatient"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartbed.grpc.AddPatientRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartbed.grpc.AddPatientResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BedServiceMethodDescriptorSupplier("AddPatient"))
                  .build();
          }
        }
     }
     return getAddPatientMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.smartbed.grpc.UploadPatientImageRequest,
      com.smartbed.grpc.UploadPatientImageResponse> getUploadPatientImageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UploadPatientImage",
      requestType = com.smartbed.grpc.UploadPatientImageRequest.class,
      responseType = com.smartbed.grpc.UploadPatientImageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.smartbed.grpc.UploadPatientImageRequest,
      com.smartbed.grpc.UploadPatientImageResponse> getUploadPatientImageMethod() {
    io.grpc.MethodDescriptor<com.smartbed.grpc.UploadPatientImageRequest, com.smartbed.grpc.UploadPatientImageResponse> getUploadPatientImageMethod;
    if ((getUploadPatientImageMethod = BedServiceGrpc.getUploadPatientImageMethod) == null) {
      synchronized (BedServiceGrpc.class) {
        if ((getUploadPatientImageMethod = BedServiceGrpc.getUploadPatientImageMethod) == null) {
          BedServiceGrpc.getUploadPatientImageMethod = getUploadPatientImageMethod = 
              io.grpc.MethodDescriptor.<com.smartbed.grpc.UploadPatientImageRequest, com.smartbed.grpc.UploadPatientImageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "grpc.BedService", "UploadPatientImage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartbed.grpc.UploadPatientImageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartbed.grpc.UploadPatientImageResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BedServiceMethodDescriptorSupplier("UploadPatientImage"))
                  .build();
          }
        }
     }
     return getUploadPatientImageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.smartbed.grpc.CurrentBedUsageRequest,
      com.smartbed.grpc.CurrentBedUsageResponse> getCurrentBedUsageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CurrentBedUsage",
      requestType = com.smartbed.grpc.CurrentBedUsageRequest.class,
      responseType = com.smartbed.grpc.CurrentBedUsageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.smartbed.grpc.CurrentBedUsageRequest,
      com.smartbed.grpc.CurrentBedUsageResponse> getCurrentBedUsageMethod() {
    io.grpc.MethodDescriptor<com.smartbed.grpc.CurrentBedUsageRequest, com.smartbed.grpc.CurrentBedUsageResponse> getCurrentBedUsageMethod;
    if ((getCurrentBedUsageMethod = BedServiceGrpc.getCurrentBedUsageMethod) == null) {
      synchronized (BedServiceGrpc.class) {
        if ((getCurrentBedUsageMethod = BedServiceGrpc.getCurrentBedUsageMethod) == null) {
          BedServiceGrpc.getCurrentBedUsageMethod = getCurrentBedUsageMethod = 
              io.grpc.MethodDescriptor.<com.smartbed.grpc.CurrentBedUsageRequest, com.smartbed.grpc.CurrentBedUsageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "grpc.BedService", "CurrentBedUsage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartbed.grpc.CurrentBedUsageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartbed.grpc.CurrentBedUsageResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BedServiceMethodDescriptorSupplier("CurrentBedUsage"))
                  .build();
          }
        }
     }
     return getCurrentBedUsageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BedServiceStub newStub(io.grpc.Channel channel) {
    return new BedServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BedServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BedServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BedServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BedServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static abstract class BedServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void addPatient(com.smartbed.grpc.AddPatientRequest request,
        io.grpc.stub.StreamObserver<com.smartbed.grpc.AddPatientResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAddPatientMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.smartbed.grpc.UploadPatientImageRequest> uploadPatientImage(
        io.grpc.stub.StreamObserver<com.smartbed.grpc.UploadPatientImageResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getUploadPatientImageMethod(), responseObserver);
    }

    /**
     */
    public void currentBedUsage(com.smartbed.grpc.CurrentBedUsageRequest request,
        io.grpc.stub.StreamObserver<com.smartbed.grpc.CurrentBedUsageResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCurrentBedUsageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddPatientMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.smartbed.grpc.AddPatientRequest,
                com.smartbed.grpc.AddPatientResponse>(
                  this, METHODID_ADD_PATIENT)))
          .addMethod(
            getUploadPatientImageMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.smartbed.grpc.UploadPatientImageRequest,
                com.smartbed.grpc.UploadPatientImageResponse>(
                  this, METHODID_UPLOAD_PATIENT_IMAGE)))
          .addMethod(
            getCurrentBedUsageMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.smartbed.grpc.CurrentBedUsageRequest,
                com.smartbed.grpc.CurrentBedUsageResponse>(
                  this, METHODID_CURRENT_BED_USAGE)))
          .build();
    }
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static final class BedServiceStub extends io.grpc.stub.AbstractStub<BedServiceStub> {
    private BedServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BedServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BedServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BedServiceStub(channel, callOptions);
    }

    /**
     */
    public void addPatient(com.smartbed.grpc.AddPatientRequest request,
        io.grpc.stub.StreamObserver<com.smartbed.grpc.AddPatientResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddPatientMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.smartbed.grpc.UploadPatientImageRequest> uploadPatientImage(
        io.grpc.stub.StreamObserver<com.smartbed.grpc.UploadPatientImageResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getUploadPatientImageMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void currentBedUsage(com.smartbed.grpc.CurrentBedUsageRequest request,
        io.grpc.stub.StreamObserver<com.smartbed.grpc.CurrentBedUsageResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getCurrentBedUsageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static final class BedServiceBlockingStub extends io.grpc.stub.AbstractStub<BedServiceBlockingStub> {
    private BedServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BedServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BedServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BedServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.smartbed.grpc.AddPatientResponse addPatient(com.smartbed.grpc.AddPatientRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddPatientMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.smartbed.grpc.CurrentBedUsageResponse> currentBedUsage(
        com.smartbed.grpc.CurrentBedUsageRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getCurrentBedUsageMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static final class BedServiceFutureStub extends io.grpc.stub.AbstractStub<BedServiceFutureStub> {
    private BedServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BedServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BedServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BedServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.smartbed.grpc.AddPatientResponse> addPatient(
        com.smartbed.grpc.AddPatientRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddPatientMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_PATIENT = 0;
  private static final int METHODID_CURRENT_BED_USAGE = 1;
  private static final int METHODID_UPLOAD_PATIENT_IMAGE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BedServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BedServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_PATIENT:
          serviceImpl.addPatient((com.smartbed.grpc.AddPatientRequest) request,
              (io.grpc.stub.StreamObserver<com.smartbed.grpc.AddPatientResponse>) responseObserver);
          break;
        case METHODID_CURRENT_BED_USAGE:
          serviceImpl.currentBedUsage((com.smartbed.grpc.CurrentBedUsageRequest) request,
              (io.grpc.stub.StreamObserver<com.smartbed.grpc.CurrentBedUsageResponse>) responseObserver);
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
        case METHODID_UPLOAD_PATIENT_IMAGE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.uploadPatientImage(
              (io.grpc.stub.StreamObserver<com.smartbed.grpc.UploadPatientImageResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class BedServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BedServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.smartbed.grpc.BedServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BedService");
    }
  }

  private static final class BedServiceFileDescriptorSupplier
      extends BedServiceBaseDescriptorSupplier {
    BedServiceFileDescriptorSupplier() {}
  }

  private static final class BedServiceMethodDescriptorSupplier
      extends BedServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BedServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (BedServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BedServiceFileDescriptorSupplier())
              .addMethod(getAddPatientMethod())
              .addMethod(getUploadPatientImageMethod())
              .addMethod(getCurrentBedUsageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
