// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpcService.proto

package services;

/**
 * Protobuf type {@code primesservice.UserImages}
 */
public  final class UserImages extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:primesservice.UserImages)
    UserImagesOrBuilder {
private static final long serialVersionUID = 0L;
  // Use UserImages.newBuilder() to construct.
  private UserImages(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UserImages() {
    imageId_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private UserImages(
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
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              imageId_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000001;
            }
            imageId_.add(s);
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
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        imageId_ = imageId_.getUnmodifiableView();
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return services.RpcService.internal_static_primesservice_UserImages_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return services.RpcService.internal_static_primesservice_UserImages_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            services.UserImages.class, services.UserImages.Builder.class);
  }

  public static final int IMAGEID_FIELD_NUMBER = 1;
  private com.google.protobuf.LazyStringList imageId_;
  /**
   * <pre>
   * list of topic names
   * </pre>
   *
   * <code>repeated string imageId = 1;</code>
   */
  public com.google.protobuf.ProtocolStringList
      getImageIdList() {
    return imageId_;
  }
  /**
   * <pre>
   * list of topic names
   * </pre>
   *
   * <code>repeated string imageId = 1;</code>
   */
  public int getImageIdCount() {
    return imageId_.size();
  }
  /**
   * <pre>
   * list of topic names
   * </pre>
   *
   * <code>repeated string imageId = 1;</code>
   */
  public java.lang.String getImageId(int index) {
    return imageId_.get(index);
  }
  /**
   * <pre>
   * list of topic names
   * </pre>
   *
   * <code>repeated string imageId = 1;</code>
   */
  public com.google.protobuf.ByteString
      getImageIdBytes(int index) {
    return imageId_.getByteString(index);
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
    for (int i = 0; i < imageId_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, imageId_.getRaw(i));
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < imageId_.size(); i++) {
        dataSize += computeStringSizeNoTag(imageId_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getImageIdList().size();
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
    if (!(obj instanceof services.UserImages)) {
      return super.equals(obj);
    }
    services.UserImages other = (services.UserImages) obj;

    boolean result = true;
    result = result && getImageIdList()
        .equals(other.getImageIdList());
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
    if (getImageIdCount() > 0) {
      hash = (37 * hash) + IMAGEID_FIELD_NUMBER;
      hash = (53 * hash) + getImageIdList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static services.UserImages parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static services.UserImages parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static services.UserImages parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static services.UserImages parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static services.UserImages parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static services.UserImages parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static services.UserImages parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static services.UserImages parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static services.UserImages parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static services.UserImages parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static services.UserImages parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static services.UserImages parseFrom(
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
  public static Builder newBuilder(services.UserImages prototype) {
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
   * Protobuf type {@code primesservice.UserImages}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:primesservice.UserImages)
      services.UserImagesOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return services.RpcService.internal_static_primesservice_UserImages_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return services.RpcService.internal_static_primesservice_UserImages_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              services.UserImages.class, services.UserImages.Builder.class);
    }

    // Construct using services.UserImages.newBuilder()
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
      imageId_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return services.RpcService.internal_static_primesservice_UserImages_descriptor;
    }

    public services.UserImages getDefaultInstanceForType() {
      return services.UserImages.getDefaultInstance();
    }

    public services.UserImages build() {
      services.UserImages result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public services.UserImages buildPartial() {
      services.UserImages result = new services.UserImages(this);
      int from_bitField0_ = bitField0_;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        imageId_ = imageId_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.imageId_ = imageId_;
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
      if (other instanceof services.UserImages) {
        return mergeFrom((services.UserImages)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(services.UserImages other) {
      if (other == services.UserImages.getDefaultInstance()) return this;
      if (!other.imageId_.isEmpty()) {
        if (imageId_.isEmpty()) {
          imageId_ = other.imageId_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureImageIdIsMutable();
          imageId_.addAll(other.imageId_);
        }
        onChanged();
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
      services.UserImages parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (services.UserImages) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.google.protobuf.LazyStringList imageId_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureImageIdIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        imageId_ = new com.google.protobuf.LazyStringArrayList(imageId_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <pre>
     * list of topic names
     * </pre>
     *
     * <code>repeated string imageId = 1;</code>
     */
    public com.google.protobuf.ProtocolStringList
        getImageIdList() {
      return imageId_.getUnmodifiableView();
    }
    /**
     * <pre>
     * list of topic names
     * </pre>
     *
     * <code>repeated string imageId = 1;</code>
     */
    public int getImageIdCount() {
      return imageId_.size();
    }
    /**
     * <pre>
     * list of topic names
     * </pre>
     *
     * <code>repeated string imageId = 1;</code>
     */
    public java.lang.String getImageId(int index) {
      return imageId_.get(index);
    }
    /**
     * <pre>
     * list of topic names
     * </pre>
     *
     * <code>repeated string imageId = 1;</code>
     */
    public com.google.protobuf.ByteString
        getImageIdBytes(int index) {
      return imageId_.getByteString(index);
    }
    /**
     * <pre>
     * list of topic names
     * </pre>
     *
     * <code>repeated string imageId = 1;</code>
     */
    public Builder setImageId(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureImageIdIsMutable();
      imageId_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * list of topic names
     * </pre>
     *
     * <code>repeated string imageId = 1;</code>
     */
    public Builder addImageId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureImageIdIsMutable();
      imageId_.add(value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * list of topic names
     * </pre>
     *
     * <code>repeated string imageId = 1;</code>
     */
    public Builder addAllImageId(
        java.lang.Iterable<java.lang.String> values) {
      ensureImageIdIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, imageId_);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * list of topic names
     * </pre>
     *
     * <code>repeated string imageId = 1;</code>
     */
    public Builder clearImageId() {
      imageId_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * list of topic names
     * </pre>
     *
     * <code>repeated string imageId = 1;</code>
     */
    public Builder addImageIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureImageIdIsMutable();
      imageId_.add(value);
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:primesservice.UserImages)
  }

  // @@protoc_insertion_point(class_scope:primesservice.UserImages)
  private static final services.UserImages DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new services.UserImages();
  }

  public static services.UserImages getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UserImages>
      PARSER = new com.google.protobuf.AbstractParser<UserImages>() {
    public UserImages parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new UserImages(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UserImages> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UserImages> getParserForType() {
    return PARSER;
  }

  public services.UserImages getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
