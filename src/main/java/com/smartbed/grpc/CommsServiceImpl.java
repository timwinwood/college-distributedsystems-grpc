// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: commsservice.proto

package com.smartbed.grpc;

public final class CommsServiceImpl {
  private CommsServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpc_SendMessageRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpc_SendMessageRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpc_SendMessageResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpc_SendMessageResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpc_UpdateChatRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpc_UpdateChatRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpc_UpdateChatResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpc_UpdateChatResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022commsservice.proto\022\004grpc\"3\n\022SendMessag" +
      "eRequest\022\014\n\004user\030\001 \001(\t\022\017\n\007message\030\002 \001(\t\"" +
      "4\n\023SendMessageResponse\022\014\n\004user\030\001 \001(\t\022\017\n\007" +
      "message\030\002 \001(\t\"!\n\021UpdateChatRequest\022\014\n\004us" +
      "er\030\001 \001(\t\"%\n\022UpdateChatResponse\022\017\n\007messag" +
      "e\030\001 \001(\t2\235\001\n\014CommsService\022H\n\013SendMessage\022" +
      "\030.grpc.SendMessageRequest\032\031.grpc.SendMes" +
      "sageResponse\"\000(\0010\001\022C\n\nUpdateChat\022\027.grpc." +
      "UpdateChatRequest\032\030.grpc.UpdateChatRespo" +
      "nse\"\0000\001B\'\n\021com.smartbed.grpcB\020CommsServi" +
      "ceImplP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_grpc_SendMessageRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_grpc_SendMessageRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpc_SendMessageRequest_descriptor,
        new java.lang.String[] { "User", "Message", });
    internal_static_grpc_SendMessageResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_grpc_SendMessageResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpc_SendMessageResponse_descriptor,
        new java.lang.String[] { "User", "Message", });
    internal_static_grpc_UpdateChatRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_grpc_UpdateChatRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpc_UpdateChatRequest_descriptor,
        new java.lang.String[] { "User", });
    internal_static_grpc_UpdateChatResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_grpc_UpdateChatResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpc_UpdateChatResponse_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
