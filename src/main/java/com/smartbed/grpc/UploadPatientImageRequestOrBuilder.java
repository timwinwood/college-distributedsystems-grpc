// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: bedservice.proto

package com.smartbed.grpc;

public interface UploadPatientImageRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:grpc.UploadPatientImageRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.grpc.ImageInfo info = 1;</code>
   */
  boolean hasInfo();
  /**
   * <code>.grpc.ImageInfo info = 1;</code>
   */
  com.smartbed.grpc.ImageInfo getInfo();
  /**
   * <code>.grpc.ImageInfo info = 1;</code>
   */
  com.smartbed.grpc.ImageInfoOrBuilder getInfoOrBuilder();

  /**
   * <code>bytes chunkData = 2;</code>
   */
  com.google.protobuf.ByteString getChunkData();

  public com.smartbed.grpc.UploadPatientImageRequest.DataCase getDataCase();
}