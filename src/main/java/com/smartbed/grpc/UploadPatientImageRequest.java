// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: bedservice.proto

package com.smartbed.grpc;

/**
 * Protobuf type {@code grpc.UploadPatientImageRequest}
 */
public  final class UploadPatientImageRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:grpc.UploadPatientImageRequest)
    UploadPatientImageRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use UploadPatientImageRequest.newBuilder() to construct.
  private UploadPatientImageRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UploadPatientImageRequest() {
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private UploadPatientImageRequest(
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
            com.smartbed.grpc.ImageInfo.Builder subBuilder = null;
            if (dataCase_ == 1) {
              subBuilder = ((com.smartbed.grpc.ImageInfo) data_).toBuilder();
            }
            data_ =
                input.readMessage(com.smartbed.grpc.ImageInfo.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom((com.smartbed.grpc.ImageInfo) data_);
              data_ = subBuilder.buildPartial();
            }
            dataCase_ = 1;
            break;
          }
          case 18: {
            dataCase_ = 2;
            data_ = input.readBytes();
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
    return com.smartbed.grpc.BedServiceImpl.internal_static_grpc_UploadPatientImageRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.smartbed.grpc.BedServiceImpl.internal_static_grpc_UploadPatientImageRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.smartbed.grpc.UploadPatientImageRequest.class, com.smartbed.grpc.UploadPatientImageRequest.Builder.class);
  }

  private int dataCase_ = 0;
  private java.lang.Object data_;
  public enum DataCase
      implements com.google.protobuf.Internal.EnumLite {
    INFO(1),
    CHUNKDATA(2),
    DATA_NOT_SET(0);
    private final int value;
    private DataCase(int value) {
      this.value = value;
    }
    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static DataCase valueOf(int value) {
      return forNumber(value);
    }

    public static DataCase forNumber(int value) {
      switch (value) {
        case 1: return INFO;
        case 2: return CHUNKDATA;
        case 0: return DATA_NOT_SET;
        default: return null;
      }
    }
    public int getNumber() {
      return this.value;
    }
  };

  public DataCase
  getDataCase() {
    return DataCase.forNumber(
        dataCase_);
  }

  public static final int INFO_FIELD_NUMBER = 1;
  /**
   * <code>.grpc.ImageInfo info = 1;</code>
   */
  public boolean hasInfo() {
    return dataCase_ == 1;
  }
  /**
   * <code>.grpc.ImageInfo info = 1;</code>
   */
  public com.smartbed.grpc.ImageInfo getInfo() {
    if (dataCase_ == 1) {
       return (com.smartbed.grpc.ImageInfo) data_;
    }
    return com.smartbed.grpc.ImageInfo.getDefaultInstance();
  }
  /**
   * <code>.grpc.ImageInfo info = 1;</code>
   */
  public com.smartbed.grpc.ImageInfoOrBuilder getInfoOrBuilder() {
    if (dataCase_ == 1) {
       return (com.smartbed.grpc.ImageInfo) data_;
    }
    return com.smartbed.grpc.ImageInfo.getDefaultInstance();
  }

  public static final int CHUNKDATA_FIELD_NUMBER = 2;
  /**
   * <code>bytes chunkData = 2;</code>
   */
  public com.google.protobuf.ByteString getChunkData() {
    if (dataCase_ == 2) {
      return (com.google.protobuf.ByteString) data_;
    }
    return com.google.protobuf.ByteString.EMPTY;
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
    if (dataCase_ == 1) {
      output.writeMessage(1, (com.smartbed.grpc.ImageInfo) data_);
    }
    if (dataCase_ == 2) {
      output.writeBytes(
          2, (com.google.protobuf.ByteString) data_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (dataCase_ == 1) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, (com.smartbed.grpc.ImageInfo) data_);
    }
    if (dataCase_ == 2) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(
            2, (com.google.protobuf.ByteString) data_);
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
    if (!(obj instanceof com.smartbed.grpc.UploadPatientImageRequest)) {
      return super.equals(obj);
    }
    com.smartbed.grpc.UploadPatientImageRequest other = (com.smartbed.grpc.UploadPatientImageRequest) obj;

    boolean result = true;
    result = result && getDataCase().equals(
        other.getDataCase());
    if (!result) return false;
    switch (dataCase_) {
      case 1:
        result = result && getInfo()
            .equals(other.getInfo());
        break;
      case 2:
        result = result && getChunkData()
            .equals(other.getChunkData());
        break;
      case 0:
      default:
    }
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
    switch (dataCase_) {
      case 1:
        hash = (37 * hash) + INFO_FIELD_NUMBER;
        hash = (53 * hash) + getInfo().hashCode();
        break;
      case 2:
        hash = (37 * hash) + CHUNKDATA_FIELD_NUMBER;
        hash = (53 * hash) + getChunkData().hashCode();
        break;
      case 0:
      default:
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.smartbed.grpc.UploadPatientImageRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.smartbed.grpc.UploadPatientImageRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.smartbed.grpc.UploadPatientImageRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.smartbed.grpc.UploadPatientImageRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.smartbed.grpc.UploadPatientImageRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.smartbed.grpc.UploadPatientImageRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.smartbed.grpc.UploadPatientImageRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.smartbed.grpc.UploadPatientImageRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.smartbed.grpc.UploadPatientImageRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.smartbed.grpc.UploadPatientImageRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.smartbed.grpc.UploadPatientImageRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.smartbed.grpc.UploadPatientImageRequest parseFrom(
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
  public static Builder newBuilder(com.smartbed.grpc.UploadPatientImageRequest prototype) {
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
   * Protobuf type {@code grpc.UploadPatientImageRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:grpc.UploadPatientImageRequest)
      com.smartbed.grpc.UploadPatientImageRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.smartbed.grpc.BedServiceImpl.internal_static_grpc_UploadPatientImageRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.smartbed.grpc.BedServiceImpl.internal_static_grpc_UploadPatientImageRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.smartbed.grpc.UploadPatientImageRequest.class, com.smartbed.grpc.UploadPatientImageRequest.Builder.class);
    }

    // Construct using com.smartbed.grpc.UploadPatientImageRequest.newBuilder()
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
      dataCase_ = 0;
      data_ = null;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.smartbed.grpc.BedServiceImpl.internal_static_grpc_UploadPatientImageRequest_descriptor;
    }

    @java.lang.Override
    public com.smartbed.grpc.UploadPatientImageRequest getDefaultInstanceForType() {
      return com.smartbed.grpc.UploadPatientImageRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.smartbed.grpc.UploadPatientImageRequest build() {
      com.smartbed.grpc.UploadPatientImageRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.smartbed.grpc.UploadPatientImageRequest buildPartial() {
      com.smartbed.grpc.UploadPatientImageRequest result = new com.smartbed.grpc.UploadPatientImageRequest(this);
      if (dataCase_ == 1) {
        if (infoBuilder_ == null) {
          result.data_ = data_;
        } else {
          result.data_ = infoBuilder_.build();
        }
      }
      if (dataCase_ == 2) {
        result.data_ = data_;
      }
      result.dataCase_ = dataCase_;
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
      if (other instanceof com.smartbed.grpc.UploadPatientImageRequest) {
        return mergeFrom((com.smartbed.grpc.UploadPatientImageRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.smartbed.grpc.UploadPatientImageRequest other) {
      if (other == com.smartbed.grpc.UploadPatientImageRequest.getDefaultInstance()) return this;
      switch (other.getDataCase()) {
        case INFO: {
          mergeInfo(other.getInfo());
          break;
        }
        case CHUNKDATA: {
          setChunkData(other.getChunkData());
          break;
        }
        case DATA_NOT_SET: {
          break;
        }
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
      com.smartbed.grpc.UploadPatientImageRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.smartbed.grpc.UploadPatientImageRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int dataCase_ = 0;
    private java.lang.Object data_;
    public DataCase
        getDataCase() {
      return DataCase.forNumber(
          dataCase_);
    }

    public Builder clearData() {
      dataCase_ = 0;
      data_ = null;
      onChanged();
      return this;
    }


    private com.google.protobuf.SingleFieldBuilderV3<
        com.smartbed.grpc.ImageInfo, com.smartbed.grpc.ImageInfo.Builder, com.smartbed.grpc.ImageInfoOrBuilder> infoBuilder_;
    /**
     * <code>.grpc.ImageInfo info = 1;</code>
     */
    public boolean hasInfo() {
      return dataCase_ == 1;
    }
    /**
     * <code>.grpc.ImageInfo info = 1;</code>
     */
    public com.smartbed.grpc.ImageInfo getInfo() {
      if (infoBuilder_ == null) {
        if (dataCase_ == 1) {
          return (com.smartbed.grpc.ImageInfo) data_;
        }
        return com.smartbed.grpc.ImageInfo.getDefaultInstance();
      } else {
        if (dataCase_ == 1) {
          return infoBuilder_.getMessage();
        }
        return com.smartbed.grpc.ImageInfo.getDefaultInstance();
      }
    }
    /**
     * <code>.grpc.ImageInfo info = 1;</code>
     */
    public Builder setInfo(com.smartbed.grpc.ImageInfo value) {
      if (infoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        data_ = value;
        onChanged();
      } else {
        infoBuilder_.setMessage(value);
      }
      dataCase_ = 1;
      return this;
    }
    /**
     * <code>.grpc.ImageInfo info = 1;</code>
     */
    public Builder setInfo(
        com.smartbed.grpc.ImageInfo.Builder builderForValue) {
      if (infoBuilder_ == null) {
        data_ = builderForValue.build();
        onChanged();
      } else {
        infoBuilder_.setMessage(builderForValue.build());
      }
      dataCase_ = 1;
      return this;
    }
    /**
     * <code>.grpc.ImageInfo info = 1;</code>
     */
    public Builder mergeInfo(com.smartbed.grpc.ImageInfo value) {
      if (infoBuilder_ == null) {
        if (dataCase_ == 1 &&
            data_ != com.smartbed.grpc.ImageInfo.getDefaultInstance()) {
          data_ = com.smartbed.grpc.ImageInfo.newBuilder((com.smartbed.grpc.ImageInfo) data_)
              .mergeFrom(value).buildPartial();
        } else {
          data_ = value;
        }
        onChanged();
      } else {
        if (dataCase_ == 1) {
          infoBuilder_.mergeFrom(value);
        }
        infoBuilder_.setMessage(value);
      }
      dataCase_ = 1;
      return this;
    }
    /**
     * <code>.grpc.ImageInfo info = 1;</code>
     */
    public Builder clearInfo() {
      if (infoBuilder_ == null) {
        if (dataCase_ == 1) {
          dataCase_ = 0;
          data_ = null;
          onChanged();
        }
      } else {
        if (dataCase_ == 1) {
          dataCase_ = 0;
          data_ = null;
        }
        infoBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>.grpc.ImageInfo info = 1;</code>
     */
    public com.smartbed.grpc.ImageInfo.Builder getInfoBuilder() {
      return getInfoFieldBuilder().getBuilder();
    }
    /**
     * <code>.grpc.ImageInfo info = 1;</code>
     */
    public com.smartbed.grpc.ImageInfoOrBuilder getInfoOrBuilder() {
      if ((dataCase_ == 1) && (infoBuilder_ != null)) {
        return infoBuilder_.getMessageOrBuilder();
      } else {
        if (dataCase_ == 1) {
          return (com.smartbed.grpc.ImageInfo) data_;
        }
        return com.smartbed.grpc.ImageInfo.getDefaultInstance();
      }
    }
    /**
     * <code>.grpc.ImageInfo info = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.smartbed.grpc.ImageInfo, com.smartbed.grpc.ImageInfo.Builder, com.smartbed.grpc.ImageInfoOrBuilder> 
        getInfoFieldBuilder() {
      if (infoBuilder_ == null) {
        if (!(dataCase_ == 1)) {
          data_ = com.smartbed.grpc.ImageInfo.getDefaultInstance();
        }
        infoBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.smartbed.grpc.ImageInfo, com.smartbed.grpc.ImageInfo.Builder, com.smartbed.grpc.ImageInfoOrBuilder>(
                (com.smartbed.grpc.ImageInfo) data_,
                getParentForChildren(),
                isClean());
        data_ = null;
      }
      dataCase_ = 1;
      onChanged();;
      return infoBuilder_;
    }

    /**
     * <code>bytes chunkData = 2;</code>
     */
    public com.google.protobuf.ByteString getChunkData() {
      if (dataCase_ == 2) {
        return (com.google.protobuf.ByteString) data_;
      }
      return com.google.protobuf.ByteString.EMPTY;
    }
    /**
     * <code>bytes chunkData = 2;</code>
     */
    public Builder setChunkData(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  dataCase_ = 2;
      data_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bytes chunkData = 2;</code>
     */
    public Builder clearChunkData() {
      if (dataCase_ == 2) {
        dataCase_ = 0;
        data_ = null;
        onChanged();
      }
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


    // @@protoc_insertion_point(builder_scope:grpc.UploadPatientImageRequest)
  }

  // @@protoc_insertion_point(class_scope:grpc.UploadPatientImageRequest)
  private static final com.smartbed.grpc.UploadPatientImageRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.smartbed.grpc.UploadPatientImageRequest();
  }

  public static com.smartbed.grpc.UploadPatientImageRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UploadPatientImageRequest>
      PARSER = new com.google.protobuf.AbstractParser<UploadPatientImageRequest>() {
    @java.lang.Override
    public UploadPatientImageRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new UploadPatientImageRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UploadPatientImageRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UploadPatientImageRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.smartbed.grpc.UploadPatientImageRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
