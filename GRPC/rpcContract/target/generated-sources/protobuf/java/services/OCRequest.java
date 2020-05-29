// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpcService.proto

package services;

/**
 * Protobuf type {@code primesservice.OCRequest}
 */
public  final class OCRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:primesservice.OCRequest)
    OCRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use OCRequest.newBuilder() to construct.
  private OCRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private OCRequest() {
    imageId_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private OCRequest(
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
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            imageId_ = s;
            break;
          }
          case 18: {
            services.SessionId.Builder subBuilder = null;
            if (user_ != null) {
              subBuilder = user_.toBuilder();
            }
            user_ = input.readMessage(services.SessionId.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(user_);
              user_ = subBuilder.buildPartial();
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
    return services.RpcService.internal_static_primesservice_OCRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return services.RpcService.internal_static_primesservice_OCRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            services.OCRequest.class, services.OCRequest.Builder.class);
  }

  public static final int IMAGEID_FIELD_NUMBER = 1;
  private volatile java.lang.Object imageId_;
  /**
   * <code>string imageId = 1;</code>
   */
  public java.lang.String getImageId() {
    java.lang.Object ref = imageId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      imageId_ = s;
      return s;
    }
  }
  /**
   * <code>string imageId = 1;</code>
   */
  public com.google.protobuf.ByteString
      getImageIdBytes() {
    java.lang.Object ref = imageId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      imageId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int USER_FIELD_NUMBER = 2;
  private services.SessionId user_;
  /**
   * <code>.primesservice.SessionId user = 2;</code>
   */
  public boolean hasUser() {
    return user_ != null;
  }
  /**
   * <code>.primesservice.SessionId user = 2;</code>
   */
  public services.SessionId getUser() {
    return user_ == null ? services.SessionId.getDefaultInstance() : user_;
  }
  /**
   * <code>.primesservice.SessionId user = 2;</code>
   */
  public services.SessionIdOrBuilder getUserOrBuilder() {
    return getUser();
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getImageIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, imageId_);
    }
    if (user_ != null) {
      output.writeMessage(2, getUser());
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getImageIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, imageId_);
    }
    if (user_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getUser());
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
    if (!(obj instanceof services.OCRequest)) {
      return super.equals(obj);
    }
    services.OCRequest other = (services.OCRequest) obj;

    boolean result = true;
    result = result && getImageId()
        .equals(other.getImageId());
    result = result && (hasUser() == other.hasUser());
    if (hasUser()) {
      result = result && getUser()
          .equals(other.getUser());
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
    hash = (37 * hash) + IMAGEID_FIELD_NUMBER;
    hash = (53 * hash) + getImageId().hashCode();
    if (hasUser()) {
      hash = (37 * hash) + USER_FIELD_NUMBER;
      hash = (53 * hash) + getUser().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static services.OCRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static services.OCRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static services.OCRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static services.OCRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static services.OCRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static services.OCRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static services.OCRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static services.OCRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static services.OCRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static services.OCRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static services.OCRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static services.OCRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(services.OCRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
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
   * Protobuf type {@code primesservice.OCRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:primesservice.OCRequest)
      services.OCRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return services.RpcService.internal_static_primesservice_OCRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return services.RpcService.internal_static_primesservice_OCRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              services.OCRequest.class, services.OCRequest.Builder.class);
    }

    // Construct using services.OCRequest.newBuilder()
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
    public Builder clear() {
      super.clear();
      imageId_ = "";

      if (userBuilder_ == null) {
        user_ = null;
      } else {
        user_ = null;
        userBuilder_ = null;
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return services.RpcService.internal_static_primesservice_OCRequest_descriptor;
    }

    public services.OCRequest getDefaultInstanceForType() {
      return services.OCRequest.getDefaultInstance();
    }

    public services.OCRequest build() {
      services.OCRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public services.OCRequest buildPartial() {
      services.OCRequest result = new services.OCRequest(this);
      result.imageId_ = imageId_;
      if (userBuilder_ == null) {
        result.user_ = user_;
      } else {
        result.user_ = userBuilder_.build();
      }
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof services.OCRequest) {
        return mergeFrom((services.OCRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(services.OCRequest other) {
      if (other == services.OCRequest.getDefaultInstance()) return this;
      if (!other.getImageId().isEmpty()) {
        imageId_ = other.imageId_;
        onChanged();
      }
      if (other.hasUser()) {
        mergeUser(other.getUser());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      services.OCRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (services.OCRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object imageId_ = "";
    /**
     * <code>string imageId = 1;</code>
     */
    public java.lang.String getImageId() {
      java.lang.Object ref = imageId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        imageId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string imageId = 1;</code>
     */
    public com.google.protobuf.ByteString
        getImageIdBytes() {
      java.lang.Object ref = imageId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        imageId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string imageId = 1;</code>
     */
    public Builder setImageId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      imageId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string imageId = 1;</code>
     */
    public Builder clearImageId() {
      
      imageId_ = getDefaultInstance().getImageId();
      onChanged();
      return this;
    }
    /**
     * <code>string imageId = 1;</code>
     */
    public Builder setImageIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      imageId_ = value;
      onChanged();
      return this;
    }

    private services.SessionId user_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        services.SessionId, services.SessionId.Builder, services.SessionIdOrBuilder> userBuilder_;
    /**
     * <code>.primesservice.SessionId user = 2;</code>
     */
    public boolean hasUser() {
      return userBuilder_ != null || user_ != null;
    }
    /**
     * <code>.primesservice.SessionId user = 2;</code>
     */
    public services.SessionId getUser() {
      if (userBuilder_ == null) {
        return user_ == null ? services.SessionId.getDefaultInstance() : user_;
      } else {
        return userBuilder_.getMessage();
      }
    }
    /**
     * <code>.primesservice.SessionId user = 2;</code>
     */
    public Builder setUser(services.SessionId value) {
      if (userBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        user_ = value;
        onChanged();
      } else {
        userBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.primesservice.SessionId user = 2;</code>
     */
    public Builder setUser(
        services.SessionId.Builder builderForValue) {
      if (userBuilder_ == null) {
        user_ = builderForValue.build();
        onChanged();
      } else {
        userBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.primesservice.SessionId user = 2;</code>
     */
    public Builder mergeUser(services.SessionId value) {
      if (userBuilder_ == null) {
        if (user_ != null) {
          user_ =
            services.SessionId.newBuilder(user_).mergeFrom(value).buildPartial();
        } else {
          user_ = value;
        }
        onChanged();
      } else {
        userBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.primesservice.SessionId user = 2;</code>
     */
    public Builder clearUser() {
      if (userBuilder_ == null) {
        user_ = null;
        onChanged();
      } else {
        user_ = null;
        userBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.primesservice.SessionId user = 2;</code>
     */
    public services.SessionId.Builder getUserBuilder() {
      
      onChanged();
      return getUserFieldBuilder().getBuilder();
    }
    /**
     * <code>.primesservice.SessionId user = 2;</code>
     */
    public services.SessionIdOrBuilder getUserOrBuilder() {
      if (userBuilder_ != null) {
        return userBuilder_.getMessageOrBuilder();
      } else {
        return user_ == null ?
            services.SessionId.getDefaultInstance() : user_;
      }
    }
    /**
     * <code>.primesservice.SessionId user = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        services.SessionId, services.SessionId.Builder, services.SessionIdOrBuilder> 
        getUserFieldBuilder() {
      if (userBuilder_ == null) {
        userBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            services.SessionId, services.SessionId.Builder, services.SessionIdOrBuilder>(
                getUser(),
                getParentForChildren(),
                isClean());
        user_ = null;
      }
      return userBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:primesservice.OCRequest)
  }

  // @@protoc_insertion_point(class_scope:primesservice.OCRequest)
  private static final services.OCRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new services.OCRequest();
  }

  public static services.OCRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<OCRequest>
      PARSER = new com.google.protobuf.AbstractParser<OCRequest>() {
    public OCRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new OCRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<OCRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<OCRequest> getParserForType() {
    return PARSER;
  }

  public services.OCRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

