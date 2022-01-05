// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: bedservice.proto

package com.smartbed.grpc;

/**
 * Protobuf type {@code grpc.ImageInfo}
 */
public  final class ImageInfo extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:grpc.ImageInfo)
    ImageInfoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ImageInfo.newBuilder() to construct.
  private ImageInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ImageInfo() {
    pps_ = "";
    imageType_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ImageInfo(
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
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            imageType_ = s;
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
    return com.smartbed.grpc.BedServiceImpl.internal_static_grpc_ImageInfo_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.smartbed.grpc.BedServiceImpl.internal_static_grpc_ImageInfo_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.smartbed.grpc.ImageInfo.class, com.smartbed.grpc.ImageInfo.Builder.class);
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

  public static final int IMAGETYPE_FIELD_NUMBER = 2;
  private volatile java.lang.Object imageType_;
  /**
   * <code>string imageType = 2;</code>
   */
  public java.lang.String getImageType() {
    java.lang.Object ref = imageType_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      imageType_ = s;
      return s;
    }
  }
  /**
   * <code>string imageType = 2;</code>
   */
  public com.google.protobuf.ByteString
      getImageTypeBytes() {
    java.lang.Object ref = imageType_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      imageType_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (!getImageTypeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, imageType_);
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
    if (!getImageTypeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, imageType_);
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
    if (!(obj instanceof com.smartbed.grpc.ImageInfo)) {
      return super.equals(obj);
    }
    com.smartbed.grpc.ImageInfo other = (com.smartbed.grpc.ImageInfo) obj;

    boolean result = true;
    result = result && getPps()
        .equals(other.getPps());
    result = result && getImageType()
        .equals(other.getImageType());
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
    hash = (37 * hash) + IMAGETYPE_FIELD_NUMBER;
    hash = (53 * hash) + getImageType().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.smartbed.grpc.ImageInfo parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.smartbed.grpc.ImageInfo parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.smartbed.grpc.ImageInfo parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.smartbed.grpc.ImageInfo parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.smartbed.grpc.ImageInfo parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.smartbed.grpc.ImageInfo parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.smartbed.grpc.ImageInfo parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.smartbed.grpc.ImageInfo parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.smartbed.grpc.ImageInfo parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.smartbed.grpc.ImageInfo parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.smartbed.grpc.ImageInfo parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.smartbed.grpc.ImageInfo parseFrom(
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
  public static Builder newBuilder(com.smartbed.grpc.ImageInfo prototype) {
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
   * Protobuf type {@code grpc.ImageInfo}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:grpc.ImageInfo)
      com.smartbed.grpc.ImageInfoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.smartbed.grpc.BedServiceImpl.internal_static_grpc_ImageInfo_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.smartbed.grpc.BedServiceImpl.internal_static_grpc_ImageInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.smartbed.grpc.ImageInfo.class, com.smartbed.grpc.ImageInfo.Builder.class);
    }

    // Construct using com.smartbed.grpc.ImageInfo.newBuilder()
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

      imageType_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.smartbed.grpc.BedServiceImpl.internal_static_grpc_ImageInfo_descriptor;
    }

    @java.lang.Override
    public com.smartbed.grpc.ImageInfo getDefaultInstanceForType() {
      return com.smartbed.grpc.ImageInfo.getDefaultInstance();
    }

    @java.lang.Override
    public com.smartbed.grpc.ImageInfo build() {
      com.smartbed.grpc.ImageInfo result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.smartbed.grpc.ImageInfo buildPartial() {
      com.smartbed.grpc.ImageInfo result = new com.smartbed.grpc.ImageInfo(this);
      result.pps_ = pps_;
      result.imageType_ = imageType_;
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
      if (other instanceof com.smartbed.grpc.ImageInfo) {
        return mergeFrom((com.smartbed.grpc.ImageInfo)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.smartbed.grpc.ImageInfo other) {
      if (other == com.smartbed.grpc.ImageInfo.getDefaultInstance()) return this;
      if (!other.getPps().isEmpty()) {
        pps_ = other.pps_;
        onChanged();
      }
      if (!other.getImageType().isEmpty()) {
        imageType_ = other.imageType_;
        onChanged();
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
      com.smartbed.grpc.ImageInfo parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.smartbed.grpc.ImageInfo) e.getUnfinishedMessage();
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

    private java.lang.Object imageType_ = "";
    /**
     * <code>string imageType = 2;</code>
     */
    public java.lang.String getImageType() {
      java.lang.Object ref = imageType_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        imageType_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string imageType = 2;</code>
     */
    public com.google.protobuf.ByteString
        getImageTypeBytes() {
      java.lang.Object ref = imageType_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        imageType_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string imageType = 2;</code>
     */
    public Builder setImageType(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      imageType_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string imageType = 2;</code>
     */
    public Builder clearImageType() {
      
      imageType_ = getDefaultInstance().getImageType();
      onChanged();
      return this;
    }
    /**
     * <code>string imageType = 2;</code>
     */
    public Builder setImageTypeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      imageType_ = value;
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


    // @@protoc_insertion_point(builder_scope:grpc.ImageInfo)
  }

  // @@protoc_insertion_point(class_scope:grpc.ImageInfo)
  private static final com.smartbed.grpc.ImageInfo DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.smartbed.grpc.ImageInfo();
  }

  public static com.smartbed.grpc.ImageInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ImageInfo>
      PARSER = new com.google.protobuf.AbstractParser<ImageInfo>() {
    @java.lang.Override
    public ImageInfo parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ImageInfo(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ImageInfo> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ImageInfo> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.smartbed.grpc.ImageInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

