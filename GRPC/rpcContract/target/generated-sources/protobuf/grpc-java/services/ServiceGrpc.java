package services;

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
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.18.0)",
    comments = "Source: rpcService.proto")
public final class ServiceGrpc {

  private ServiceGrpc() {}

  public static final String SERVICE_NAME = "primesservice.Service";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<services.ProtoUser,
      services.SessionId> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "login",
      requestType = services.ProtoUser.class,
      responseType = services.SessionId.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<services.ProtoUser,
      services.SessionId> getLoginMethod() {
    io.grpc.MethodDescriptor<services.ProtoUser, services.SessionId> getLoginMethod;
    if ((getLoginMethod = ServiceGrpc.getLoginMethod) == null) {
      synchronized (ServiceGrpc.class) {
        if ((getLoginMethod = ServiceGrpc.getLoginMethod) == null) {
          ServiceGrpc.getLoginMethod = getLoginMethod = 
              io.grpc.MethodDescriptor.<services.ProtoUser, services.SessionId>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "primesservice.Service", "login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  services.ProtoUser.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  services.SessionId.getDefaultInstance()))
                  .setSchemaDescriptor(new ServiceMethodDescriptorSupplier("login"))
                  .build();
          }
        }
     }
     return getLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<services.SessionId,
      com.google.protobuf.Empty> getCloseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "close",
      requestType = services.SessionId.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<services.SessionId,
      com.google.protobuf.Empty> getCloseMethod() {
    io.grpc.MethodDescriptor<services.SessionId, com.google.protobuf.Empty> getCloseMethod;
    if ((getCloseMethod = ServiceGrpc.getCloseMethod) == null) {
      synchronized (ServiceGrpc.class) {
        if ((getCloseMethod = ServiceGrpc.getCloseMethod) == null) {
          ServiceGrpc.getCloseMethod = getCloseMethod = 
              io.grpc.MethodDescriptor.<services.SessionId, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "primesservice.Service", "close"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  services.SessionId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new ServiceMethodDescriptorSupplier("close"))
                  .build();
          }
        }
     }
     return getCloseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<services.Image,
      services.ImageId> getSendImageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendImage",
      requestType = services.Image.class,
      responseType = services.ImageId.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<services.Image,
      services.ImageId> getSendImageMethod() {
    io.grpc.MethodDescriptor<services.Image, services.ImageId> getSendImageMethod;
    if ((getSendImageMethod = ServiceGrpc.getSendImageMethod) == null) {
      synchronized (ServiceGrpc.class) {
        if ((getSendImageMethod = ServiceGrpc.getSendImageMethod) == null) {
          ServiceGrpc.getSendImageMethod = getSendImageMethod = 
              io.grpc.MethodDescriptor.<services.Image, services.ImageId>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "primesservice.Service", "sendImage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  services.Image.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  services.ImageId.getDefaultInstance()))
                  .setSchemaDescriptor(new ServiceMethodDescriptorSupplier("sendImage"))
                  .build();
          }
        }
     }
     return getSendImageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<services.SessionId,
      services.UserImages> getListUserImagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "listUserImages",
      requestType = services.SessionId.class,
      responseType = services.UserImages.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<services.SessionId,
      services.UserImages> getListUserImagesMethod() {
    io.grpc.MethodDescriptor<services.SessionId, services.UserImages> getListUserImagesMethod;
    if ((getListUserImagesMethod = ServiceGrpc.getListUserImagesMethod) == null) {
      synchronized (ServiceGrpc.class) {
        if ((getListUserImagesMethod = ServiceGrpc.getListUserImagesMethod) == null) {
          ServiceGrpc.getListUserImagesMethod = getListUserImagesMethod = 
              io.grpc.MethodDescriptor.<services.SessionId, services.UserImages>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "primesservice.Service", "listUserImages"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  services.SessionId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  services.UserImages.getDefaultInstance()))
                  .setSchemaDescriptor(new ServiceMethodDescriptorSupplier("listUserImages"))
                  .build();
          }
        }
     }
     return getListUserImagesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<services.OCRequest,
      services.OCReply> getRequestOCRMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "requestOCR",
      requestType = services.OCRequest.class,
      responseType = services.OCReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<services.OCRequest,
      services.OCReply> getRequestOCRMethod() {
    io.grpc.MethodDescriptor<services.OCRequest, services.OCReply> getRequestOCRMethod;
    if ((getRequestOCRMethod = ServiceGrpc.getRequestOCRMethod) == null) {
      synchronized (ServiceGrpc.class) {
        if ((getRequestOCRMethod = ServiceGrpc.getRequestOCRMethod) == null) {
          ServiceGrpc.getRequestOCRMethod = getRequestOCRMethod = 
              io.grpc.MethodDescriptor.<services.OCRequest, services.OCReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "primesservice.Service", "requestOCR"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  services.OCRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  services.OCReply.getDefaultInstance()))
                  .setSchemaDescriptor(new ServiceMethodDescriptorSupplier("requestOCR"))
                  .build();
          }
        }
     }
     return getRequestOCRMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ServiceStub newStub(io.grpc.Channel channel) {
    return new ServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void login(services.ProtoUser request,
        io.grpc.stub.StreamObserver<services.SessionId> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     */
    public void close(services.SessionId request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getCloseMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<services.Image> sendImage(
        io.grpc.stub.StreamObserver<services.ImageId> responseObserver) {
      return asyncUnimplementedStreamingCall(getSendImageMethod(), responseObserver);
    }

    /**
     */
    public void listUserImages(services.SessionId request,
        io.grpc.stub.StreamObserver<services.UserImages> responseObserver) {
      asyncUnimplementedUnaryCall(getListUserImagesMethod(), responseObserver);
    }

    /**
     */
    public void requestOCR(services.OCRequest request,
        io.grpc.stub.StreamObserver<services.OCReply> responseObserver) {
      asyncUnimplementedUnaryCall(getRequestOCRMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                services.ProtoUser,
                services.SessionId>(
                  this, METHODID_LOGIN)))
          .addMethod(
            getCloseMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                services.SessionId,
                com.google.protobuf.Empty>(
                  this, METHODID_CLOSE)))
          .addMethod(
            getSendImageMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                services.Image,
                services.ImageId>(
                  this, METHODID_SEND_IMAGE)))
          .addMethod(
            getListUserImagesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                services.SessionId,
                services.UserImages>(
                  this, METHODID_LIST_USER_IMAGES)))
          .addMethod(
            getRequestOCRMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                services.OCRequest,
                services.OCReply>(
                  this, METHODID_REQUEST_OCR)))
          .build();
    }
  }

  /**
   */
  public static final class ServiceStub extends io.grpc.stub.AbstractStub<ServiceStub> {
    private ServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ServiceStub(channel, callOptions);
    }

    /**
     */
    public void login(services.ProtoUser request,
        io.grpc.stub.StreamObserver<services.SessionId> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void close(services.SessionId request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCloseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<services.Image> sendImage(
        io.grpc.stub.StreamObserver<services.ImageId> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getSendImageMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void listUserImages(services.SessionId request,
        io.grpc.stub.StreamObserver<services.UserImages> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListUserImagesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void requestOCR(services.OCRequest request,
        io.grpc.stub.StreamObserver<services.OCReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRequestOCRMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ServiceBlockingStub extends io.grpc.stub.AbstractStub<ServiceBlockingStub> {
    private ServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public services.SessionId login(services.ProtoUser request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty close(services.SessionId request) {
      return blockingUnaryCall(
          getChannel(), getCloseMethod(), getCallOptions(), request);
    }

    /**
     */
    public services.UserImages listUserImages(services.SessionId request) {
      return blockingUnaryCall(
          getChannel(), getListUserImagesMethod(), getCallOptions(), request);
    }

    /**
     */
    public services.OCReply requestOCR(services.OCRequest request) {
      return blockingUnaryCall(
          getChannel(), getRequestOCRMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ServiceFutureStub extends io.grpc.stub.AbstractStub<ServiceFutureStub> {
    private ServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<services.SessionId> login(
        services.ProtoUser request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> close(
        services.SessionId request) {
      return futureUnaryCall(
          getChannel().newCall(getCloseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<services.UserImages> listUserImages(
        services.SessionId request) {
      return futureUnaryCall(
          getChannel().newCall(getListUserImagesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<services.OCReply> requestOCR(
        services.OCRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRequestOCRMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN = 0;
  private static final int METHODID_CLOSE = 1;
  private static final int METHODID_LIST_USER_IMAGES = 2;
  private static final int METHODID_REQUEST_OCR = 3;
  private static final int METHODID_SEND_IMAGE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN:
          serviceImpl.login((services.ProtoUser) request,
              (io.grpc.stub.StreamObserver<services.SessionId>) responseObserver);
          break;
        case METHODID_CLOSE:
          serviceImpl.close((services.SessionId) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_USER_IMAGES:
          serviceImpl.listUserImages((services.SessionId) request,
              (io.grpc.stub.StreamObserver<services.UserImages>) responseObserver);
          break;
        case METHODID_REQUEST_OCR:
          serviceImpl.requestOCR((services.OCRequest) request,
              (io.grpc.stub.StreamObserver<services.OCReply>) responseObserver);
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
        case METHODID_SEND_IMAGE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sendImage(
              (io.grpc.stub.StreamObserver<services.ImageId>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return services.RpcService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Service");
    }
  }

  private static final class ServiceFileDescriptorSupplier
      extends ServiceBaseDescriptorSupplier {
    ServiceFileDescriptorSupplier() {}
  }

  private static final class ServiceMethodDescriptorSupplier
      extends ServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ServiceFileDescriptorSupplier())
              .addMethod(getLoginMethod())
              .addMethod(getCloseMethod())
              .addMethod(getSendImageMethod())
              .addMethod(getListUserImagesMethod())
              .addMethod(getRequestOCRMethod())
              .build();
        }
      }
    }
    return result;
  }
}
