// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: bedservice.proto

package com.smartbed.grpc;

public interface AddPatientRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:grpc.AddPatientRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string first = 1;</code>
   */
  java.lang.String getFirst();
  /**
   * <code>string first = 1;</code>
   */
  com.google.protobuf.ByteString
      getFirstBytes();

  /**
   * <code>string last = 2;</code>
   */
  java.lang.String getLast();
  /**
   * <code>string last = 2;</code>
   */
  com.google.protobuf.ByteString
      getLastBytes();

  /**
   * <code>string pps = 3;</code>
   */
  java.lang.String getPps();
  /**
   * <code>string pps = 3;</code>
   */
  com.google.protobuf.ByteString
      getPpsBytes();

  /**
   * <code>.grpc.AddPatientRequest.Gender gender = 4;</code>
   */
  int getGenderValue();
  /**
   * <code>.grpc.AddPatientRequest.Gender gender = 4;</code>
   */
  com.smartbed.grpc.AddPatientRequest.Gender getGender();
}