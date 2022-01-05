// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: bedservice.proto

package com.smartbed.grpc;

/**
 * Protobuf type {@code grpc.UploadPatientImageResponse}
 */
public  final class UploadPatientImageResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:grpc.UploadPatientImageResponse)
    UploadPatientImageResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use UploadPatientImageResponse.newBuilder() to construct.
  private UploadPatientImageResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UploadPatientImageResponse() {
    pps_ = "";
    size_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private UploadPatientImageResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            pps_ = s;
            break;
          }
          case 16: {

            size_ = input.readInt32();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.smartbed.grpc.BedServiceImpl.internal_static_grpc_UploadPatientImageResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.smartbed.grpc.BedServiceImpl.internal_static_grpc_UploadPatientImageResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.smartbed.grpc.UploadPatientImageResponse.class, com.smartbed.grpc.UploadPatientImageResponse.Builder.class);
  }

  public static final int PPS_FIELD_NUMBER = 1;
  private volatile java.lang.Object pps_;
  /**
   * <code>string pps = 1;</code>
   */
  public java.lang.String getPps() {
    java.lang.Object ref = pps_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      pps_ = s;
      return s;
    }
  }
  /**
   * <code>string pps = 1;</code>
   */
  public com.google.protobuf.ByteString
      getPpsBytes() {
    java.lang.Object ref = pps_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      pps_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SIZE_FIELD_NUMBER = 2;
  private int size_;
  /**
   * <code>int32 size = 2;</code>
   */
  public int getSize() {
    return size_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getPpsBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, pps_);
    }
    if (size_ != 0) {
      output.writeInt32(2, size_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getPpsBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, pps_);
    }
    if (size_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, size_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.smartbed.grpc.UploadPatientImageResponse)) {
      return super.equals(obj);
    }
    com.smartbed.grpc.UploadPatientImageResponse other = (com.smartbed.grpc.UploadPatientImageResponse) obj;

    boolean result = true;
    result = result && getPps()
        .equals(other.getPps());
    result = result && (getSize()
        == other.getSize());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + PPS_FIELD_NUMBER;
    hash = (53 * hash) + getPps().hashCode();
    hash = (37 * hash) + SIZE_FIELD_NUMBER;
    hash = (53 * hash) + getSize();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.smartbed.grpc.UploadPatientImageResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.smartbed.grpc.UploadPatientImageResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.smartbed.grpc.UploadPatientImageResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.smartbed.grpc.UploadPatientImageResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.smartbed.grpc.UploadPatientImageResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.smartbed.grpc.UploadPatientImageResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.smartbed.grpc.UploadPatientImageResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.smartbed.grpc.UploadPatientImageResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.smartbed.grpc.UploadPatientImageResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.smartbed.grpc.UploadPatientImageResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.smartbed.grpc.UploadPatientImageResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.smartbed.grpc.UploadPatientImageResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.smartbed.grpc.UploadPatientImageResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code grpc.UploadPatientImageResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:grpc.UploadPatientImageResponse)
      com.smartbed.grpc.UploadPatientImageResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.smartbed.grpc.BedServiceImpl.internal_static_grpc_UploadPatientImageResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.smartbed.grpc.BedServiceImpl.internal_static_grpc_UploadPatientImageResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.smartbed.grpc.UploadPatientImageResponse.class, com.smartbed.grpc.UploadPatientImageResponse.Builder.class);
    }

    // Construct using com.smartbed.grpc.UploadPatientImageResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      pps_ = "";

      size_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.smartbed.grpc.BedServiceImpl.internal_static_grpc_UploadPatientImageResponse_descriptor;
    }

    @java.lang.Override
    public com.smartbed.grpc.UploadPatientImageResponse getDefaultInstanceForType() {
      return com.smartbed.grpc.UploadPatientImageResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.smartbed.grpc.UploadPatientImageResponse build() {
      com.smartbed.grpc.UploadPatientImageResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.smartbed.grpc.UploadPatientImageResponse buildPartial() {
      com.smartbed.grpc.UploadPatientImageResponse result = new com.smartbed.grpc.UploadPatientImageResponse(this);
      result.pps_ = pps_;
      result.size_ = size_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.smartbed.grpc.UploadPatientImageResponse) {
        return mergeFrom((com.smartbed.grpc.UploadPatientImageResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.smartbed.grpc.UploadPatientImageResponse other) {
      if (other == com.smartbed.grpc.UploadPatientImageResponse.getDefaultInstance()) return this;
      if (!other.getPps().isEmpty()) {
        pps_ = other.pps_;
        onChanged();
      }
      if (other.getSize() != 0) {
        setSize(other.getSize());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.smartbed.grpc.UploadPatientImageResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.smartbed.grpc.UploadPatientImageResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object pps_ = "";
    /**
     * <code>string pps = 1;</code>
     */
    public java.lang.String getPps() {
      java.lang.Object ref = pps_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        pps_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string pps = 1;</code>
     */
    public com.google.protobuf.ByteString
        getPpsBytes() {
      java.lang.Object ref = pps_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        pps_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string pps = 1;</code>
     */
    public Builder setPps(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      pps_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string pps = 1;</code>
     */
    public Builder clearPps() {
      
      pps_ = getDefaultInstance().getPps();
      onChanged();
      return this;
    }
    /**
     * <code>string pps = 1;</code>
     */
    public Builder setPpsBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      pps_ = value;
      onChanged();
      return this;
    }

    private int size_ ;
    /**
     * <code>int32 size = 2;</code>
     */
    public int getSize() {
      return size_;
    }
    /**
     * <code>int32 size = 2;</code>
     */
    public Builder setSize(int value) {
      
      size_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 size = 2;</code>
     */
    public Builder clearSize() {
      
      size_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:grpc.UploadPatientImageResponse)
  }

  // @@protoc_insertion_point(class_scope:grpc.UploadPatientImageResponse)
  private static final com.smartbed.grpc.UploadPatientImageResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.smartbed.grpc.UploadPatientImageResponse();
  }

  public static com.smartbed.grpc.UploadPatientImageResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UploadPatientImageResponse>
      PARSER = new com.google.protobuf.AbstractParser<UploadPatientImageResponse>() {
    @java.lang.Override
    public UploadPatientImageResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new UploadPatientImageResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UploadPatientImageResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UploadPatientImageResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.smartbed.grpc.UploadPatientImageResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
