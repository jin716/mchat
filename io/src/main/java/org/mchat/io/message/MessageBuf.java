// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Message.proto

package org.mchat.io.message;

public final class MessageBuf {
  private MessageBuf() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface MessageOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Message)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional int64 length = 1;</code>
     */
    long getLength();

    /**
     * <code>optional .Message.MessageType type = 2;</code>
     */
    int getTypeValue();
    /**
     * <code>optional .Message.MessageType type = 2;</code>
     */
    Message.MessageType getType();

    /**
     * <code>optional int32 version = 3;</code>
     */
    int getVersion();

    /**
     * <code>optional string from = 4;</code>
     */
    String getFrom();
    /**
     * <code>optional string from = 4;</code>
     */
    com.google.protobuf.ByteString
        getFromBytes();

    /**
     * <code>optional string to = 5;</code>
     */
    String getTo();
    /**
     * <code>optional string to = 5;</code>
     */
    com.google.protobuf.ByteString
        getToBytes();

    /**
     * <code>optional string chatId = 6;</code>
     */
    String getChatId();
    /**
     * <code>optional string chatId = 6;</code>
     */
    com.google.protobuf.ByteString
        getChatIdBytes();

    /**
     * <code>repeated bytes data = 7;</code>
     */
    java.util.List<com.google.protobuf.ByteString> getDataList();
    /**
     * <code>repeated bytes data = 7;</code>
     */
    int getDataCount();
    /**
     * <code>repeated bytes data = 7;</code>
     */
    com.google.protobuf.ByteString getData(int index);

    /**
     * <code>optional int32 flag = 8;</code>
     */
    int getFlag();
  }
  /**
   * Protobuf type {@code Message}
   */
  public  static final class Message extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:Message)
      MessageOrBuilder {
    // Use Message.newBuilder() to construct.
    private Message(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
    }
    private Message() {
      length_ = 0L;
      type_ = 0;
      version_ = 0;
      from_ = "";
      to_ = "";
      chatId_ = "";
      data_ = java.util.Collections.emptyList();
      flag_ = 0;
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private Message(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              length_ = input.readInt64();
              break;
            }
            case 16: {
              int rawValue = input.readEnum();

              type_ = rawValue;
              break;
            }
            case 24: {

              version_ = input.readInt32();
              break;
            }
            case 34: {
              String s = input.readStringRequireUtf8();

              from_ = s;
              break;
            }
            case 42: {
              String s = input.readStringRequireUtf8();

              to_ = s;
              break;
            }
            case 50: {
              String s = input.readStringRequireUtf8();

              chatId_ = s;
              break;
            }
            case 58: {
              if (!((mutable_bitField0_ & 0x00000040) == 0x00000040)) {
                data_ = new java.util.ArrayList<com.google.protobuf.ByteString>();
                mutable_bitField0_ |= 0x00000040;
              }
              data_.add(input.readBytes());
              break;
            }
            case 64: {

              flag_ = input.readInt32();
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
        if (((mutable_bitField0_ & 0x00000040) == 0x00000040)) {
          data_ = java.util.Collections.unmodifiableList(data_);
        }
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return MessageBuf.internal_static_Message_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return MessageBuf.internal_static_Message_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Message.class, Builder.class);
    }

    /**
     * Protobuf enum {@code Message.MessageType}
     */
    public enum MessageType
        implements com.google.protobuf.ProtocolMessageEnum {
      /**
       * <code>TEXT = 0;</code>
       */
      TEXT(0),
      /**
       * <code>LOCATION = 1;</code>
       */
      LOCATION(1),
      /**
       * <code>VOICE = 2;</code>
       */
      VOICE(2),
      /**
       * <code>IMAGE = 3;</code>
       */
      IMAGE(3),
      /**
       * <code>ACK = 4;</code>
       */
      ACK(4),
      /**
       * <code>ERROR = 5;</code>
       */
      ERROR(5),
      UNRECOGNIZED(-1),
      ;

      /**
       * <code>TEXT = 0;</code>
       */
      public static final int TEXT_VALUE = 0;
      /**
       * <code>LOCATION = 1;</code>
       */
      public static final int LOCATION_VALUE = 1;
      /**
       * <code>VOICE = 2;</code>
       */
      public static final int VOICE_VALUE = 2;
      /**
       * <code>IMAGE = 3;</code>
       */
      public static final int IMAGE_VALUE = 3;
      /**
       * <code>ACK = 4;</code>
       */
      public static final int ACK_VALUE = 4;
      /**
       * <code>ERROR = 5;</code>
       */
      public static final int ERROR_VALUE = 5;


      public final int getNumber() {
        if (this == UNRECOGNIZED) {
          throw new IllegalArgumentException(
              "Can't get the number of an unknown enum value.");
        }
        return value;
      }

      /**
       * @deprecated Use {@link #forNumber(int)} instead.
       */
      @Deprecated
      public static MessageType valueOf(int value) {
        return forNumber(value);
      }

      public static MessageType forNumber(int value) {
        switch (value) {
          case 0: return TEXT;
          case 1: return LOCATION;
          case 2: return VOICE;
          case 3: return IMAGE;
          case 4: return ACK;
          case 5: return ERROR;
          default: return null;
        }
      }

      public static com.google.protobuf.Internal.EnumLiteMap<MessageType>
          internalGetValueMap() {
        return internalValueMap;
      }
      private static final com.google.protobuf.Internal.EnumLiteMap<
          MessageType> internalValueMap =
            new com.google.protobuf.Internal.EnumLiteMap<MessageType>() {
              public MessageType findValueByNumber(int number) {
                return MessageType.forNumber(number);
              }
            };

      public final com.google.protobuf.Descriptors.EnumValueDescriptor
          getValueDescriptor() {
        return getDescriptor().getValues().get(ordinal());
      }
      public final com.google.protobuf.Descriptors.EnumDescriptor
          getDescriptorForType() {
        return getDescriptor();
      }
      public static final com.google.protobuf.Descriptors.EnumDescriptor
          getDescriptor() {
        return Message.getDescriptor().getEnumTypes().get(0);
      }

      private static final MessageType[] VALUES = values();

      public static MessageType valueOf(
          com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
        if (desc.getType() != getDescriptor()) {
          throw new IllegalArgumentException(
            "EnumValueDescriptor is not for this type.");
        }
        if (desc.getIndex() == -1) {
          return UNRECOGNIZED;
        }
        return VALUES[desc.getIndex()];
      }

      private final int value;

      private MessageType(int value) {
        this.value = value;
      }

      // @@protoc_insertion_point(enum_scope:Message.MessageType)
    }

    private int bitField0_;
    public static final int LENGTH_FIELD_NUMBER = 1;
    private long length_;
    /**
     * <code>optional int64 length = 1;</code>
     */
    public long getLength() {
      return length_;
    }

    public static final int TYPE_FIELD_NUMBER = 2;
    private int type_;
    /**
     * <code>optional .Message.MessageType type = 2;</code>
     */
    public int getTypeValue() {
      return type_;
    }
    /**
     * <code>optional .Message.MessageType type = 2;</code>
     */
    public MessageType getType() {
      MessageType result = MessageType.forNumber(type_);
      return result == null ? MessageType.UNRECOGNIZED : result;
    }

    public static final int VERSION_FIELD_NUMBER = 3;
    private int version_;
    /**
     * <code>optional int32 version = 3;</code>
     */
    public int getVersion() {
      return version_;
    }

    public static final int FROM_FIELD_NUMBER = 4;
    private volatile Object from_;
    /**
     * <code>optional string from = 4;</code>
     */
    public String getFrom() {
      Object ref = from_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        from_ = s;
        return s;
      }
    }
    /**
     * <code>optional string from = 4;</code>
     */
    public com.google.protobuf.ByteString
        getFromBytes() {
      Object ref = from_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        from_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TO_FIELD_NUMBER = 5;
    private volatile Object to_;
    /**
     * <code>optional string to = 5;</code>
     */
    public String getTo() {
      Object ref = to_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        to_ = s;
        return s;
      }
    }
    /**
     * <code>optional string to = 5;</code>
     */
    public com.google.protobuf.ByteString
        getToBytes() {
      Object ref = to_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        to_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int CHATID_FIELD_NUMBER = 6;
    private volatile Object chatId_;
    /**
     * <code>optional string chatId = 6;</code>
     */
    public String getChatId() {
      Object ref = chatId_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        chatId_ = s;
        return s;
      }
    }
    /**
     * <code>optional string chatId = 6;</code>
     */
    public com.google.protobuf.ByteString
        getChatIdBytes() {
      Object ref = chatId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        chatId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int DATA_FIELD_NUMBER = 7;
    private java.util.List<com.google.protobuf.ByteString> data_;
    /**
     * <code>repeated bytes data = 7;</code>
     */
    public java.util.List<com.google.protobuf.ByteString>
        getDataList() {
      return data_;
    }
    /**
     * <code>repeated bytes data = 7;</code>
     */
    public int getDataCount() {
      return data_.size();
    }
    /**
     * <code>repeated bytes data = 7;</code>
     */
    public com.google.protobuf.ByteString getData(int index) {
      return data_.get(index);
    }

    public static final int FLAG_FIELD_NUMBER = 8;
    private int flag_;
    /**
     * <code>optional int32 flag = 8;</code>
     */
    public int getFlag() {
      return flag_;
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
      if (length_ != 0L) {
        output.writeInt64(1, length_);
      }
      if (type_ != MessageType.TEXT.getNumber()) {
        output.writeEnum(2, type_);
      }
      if (version_ != 0) {
        output.writeInt32(3, version_);
      }
      if (!getFromBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessage.writeString(output, 4, from_);
      }
      if (!getToBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessage.writeString(output, 5, to_);
      }
      if (!getChatIdBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessage.writeString(output, 6, chatId_);
      }
      for (int i = 0; i < data_.size(); i++) {
        output.writeBytes(7, data_.get(i));
      }
      if (flag_ != 0) {
        output.writeInt32(8, flag_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (length_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(1, length_);
      }
      if (type_ != MessageType.TEXT.getNumber()) {
        size += com.google.protobuf.CodedOutputStream
          .computeEnumSize(2, type_);
      }
      if (version_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(3, version_);
      }
      if (!getFromBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessage.computeStringSize(4, from_);
      }
      if (!getToBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessage.computeStringSize(5, to_);
      }
      if (!getChatIdBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessage.computeStringSize(6, chatId_);
      }
      {
        int dataSize = 0;
        for (int i = 0; i < data_.size(); i++) {
          dataSize += com.google.protobuf.CodedOutputStream
            .computeBytesSizeNoTag(data_.get(i));
        }
        size += dataSize;
        size += 1 * getDataList().size();
      }
      if (flag_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(8, flag_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    public static Message parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Message parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Message parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Message parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Message parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseWithIOException(PARSER, input);
    }
    public static Message parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Message parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Message parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Message parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseWithIOException(PARSER, input);
    }
    public static Message parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(Message prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Message}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Message)
        MessageOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return MessageBuf.internal_static_Message_descriptor;
      }

      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return MessageBuf.internal_static_Message_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Message.class, Builder.class);
      }

      // Construct using org.mchat.io.message.MessageBuf.Message.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        length_ = 0L;

        type_ = 0;

        version_ = 0;

        from_ = "";

        to_ = "";

        chatId_ = "";

        data_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000040);
        flag_ = 0;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return MessageBuf.internal_static_Message_descriptor;
      }

      public Message getDefaultInstanceForType() {
        return Message.getDefaultInstance();
      }

      public Message build() {
        Message result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Message buildPartial() {
        Message result = new Message(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        result.length_ = length_;
        result.type_ = type_;
        result.version_ = version_;
        result.from_ = from_;
        result.to_ = to_;
        result.chatId_ = chatId_;
        if (((bitField0_ & 0x00000040) == 0x00000040)) {
          data_ = java.util.Collections.unmodifiableList(data_);
          bitField0_ = (bitField0_ & ~0x00000040);
        }
        result.data_ = data_;
        result.flag_ = flag_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Message) {
          return mergeFrom((Message)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Message other) {
        if (other == Message.getDefaultInstance()) return this;
        if (other.getLength() != 0L) {
          setLength(other.getLength());
        }
        if (other.type_ != 0) {
          setTypeValue(other.getTypeValue());
        }
        if (other.getVersion() != 0) {
          setVersion(other.getVersion());
        }
        if (!other.getFrom().isEmpty()) {
          from_ = other.from_;
          onChanged();
        }
        if (!other.getTo().isEmpty()) {
          to_ = other.to_;
          onChanged();
        }
        if (!other.getChatId().isEmpty()) {
          chatId_ = other.chatId_;
          onChanged();
        }
        if (!other.data_.isEmpty()) {
          if (data_.isEmpty()) {
            data_ = other.data_;
            bitField0_ = (bitField0_ & ~0x00000040);
          } else {
            ensureDataIsMutable();
            data_.addAll(other.data_);
          }
          onChanged();
        }
        if (other.getFlag() != 0) {
          setFlag(other.getFlag());
        }
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
        Message parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Message) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private long length_ ;
      /**
       * <code>optional int64 length = 1;</code>
       */
      public long getLength() {
        return length_;
      }
      /**
       * <code>optional int64 length = 1;</code>
       */
      public Builder setLength(long value) {
        
        length_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int64 length = 1;</code>
       */
      public Builder clearLength() {
        
        length_ = 0L;
        onChanged();
        return this;
      }

      private int type_ = 0;
      /**
       * <code>optional .Message.MessageType type = 2;</code>
       */
      public int getTypeValue() {
        return type_;
      }
      /**
       * <code>optional .Message.MessageType type = 2;</code>
       */
      public Builder setTypeValue(int value) {
        type_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional .Message.MessageType type = 2;</code>
       */
      public MessageType getType() {
        MessageType result = MessageType.forNumber(type_);
        return result == null ? MessageType.UNRECOGNIZED : result;
      }
      /**
       * <code>optional .Message.MessageType type = 2;</code>
       */
      public Builder setType(MessageType value) {
        if (value == null) {
          throw new NullPointerException();
        }
        
        type_ = value.getNumber();
        onChanged();
        return this;
      }
      /**
       * <code>optional .Message.MessageType type = 2;</code>
       */
      public Builder clearType() {
        
        type_ = 0;
        onChanged();
        return this;
      }

      private int version_ ;
      /**
       * <code>optional int32 version = 3;</code>
       */
      public int getVersion() {
        return version_;
      }
      /**
       * <code>optional int32 version = 3;</code>
       */
      public Builder setVersion(int value) {
        
        version_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 version = 3;</code>
       */
      public Builder clearVersion() {
        
        version_ = 0;
        onChanged();
        return this;
      }

      private Object from_ = "";
      /**
       * <code>optional string from = 4;</code>
       */
      public String getFrom() {
        Object ref = from_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          from_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>optional string from = 4;</code>
       */
      public com.google.protobuf.ByteString
          getFromBytes() {
        Object ref = from_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          from_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string from = 4;</code>
       */
      public Builder setFrom(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        from_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string from = 4;</code>
       */
      public Builder clearFrom() {
        
        from_ = getDefaultInstance().getFrom();
        onChanged();
        return this;
      }
      /**
       * <code>optional string from = 4;</code>
       */
      public Builder setFromBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        from_ = value;
        onChanged();
        return this;
      }

      private Object to_ = "";
      /**
       * <code>optional string to = 5;</code>
       */
      public String getTo() {
        Object ref = to_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          to_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>optional string to = 5;</code>
       */
      public com.google.protobuf.ByteString
          getToBytes() {
        Object ref = to_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          to_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string to = 5;</code>
       */
      public Builder setTo(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        to_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string to = 5;</code>
       */
      public Builder clearTo() {
        
        to_ = getDefaultInstance().getTo();
        onChanged();
        return this;
      }
      /**
       * <code>optional string to = 5;</code>
       */
      public Builder setToBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        to_ = value;
        onChanged();
        return this;
      }

      private Object chatId_ = "";
      /**
       * <code>optional string chatId = 6;</code>
       */
      public String getChatId() {
        Object ref = chatId_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          chatId_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>optional string chatId = 6;</code>
       */
      public com.google.protobuf.ByteString
          getChatIdBytes() {
        Object ref = chatId_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          chatId_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string chatId = 6;</code>
       */
      public Builder setChatId(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        chatId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string chatId = 6;</code>
       */
      public Builder clearChatId() {
        
        chatId_ = getDefaultInstance().getChatId();
        onChanged();
        return this;
      }
      /**
       * <code>optional string chatId = 6;</code>
       */
      public Builder setChatIdBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        chatId_ = value;
        onChanged();
        return this;
      }

      private java.util.List<com.google.protobuf.ByteString> data_ = java.util.Collections.emptyList();
      private void ensureDataIsMutable() {
        if (!((bitField0_ & 0x00000040) == 0x00000040)) {
          data_ = new java.util.ArrayList<com.google.protobuf.ByteString>(data_);
          bitField0_ |= 0x00000040;
         }
      }
      /**
       * <code>repeated bytes data = 7;</code>
       */
      public java.util.List<com.google.protobuf.ByteString>
          getDataList() {
        return java.util.Collections.unmodifiableList(data_);
      }
      /**
       * <code>repeated bytes data = 7;</code>
       */
      public int getDataCount() {
        return data_.size();
      }
      /**
       * <code>repeated bytes data = 7;</code>
       */
      public com.google.protobuf.ByteString getData(int index) {
        return data_.get(index);
      }
      /**
       * <code>repeated bytes data = 7;</code>
       */
      public Builder setData(
          int index, com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureDataIsMutable();
        data_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated bytes data = 7;</code>
       */
      public Builder addData(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureDataIsMutable();
        data_.add(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated bytes data = 7;</code>
       */
      public Builder addAllData(
          Iterable<? extends com.google.protobuf.ByteString> values) {
        ensureDataIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, data_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated bytes data = 7;</code>
       */
      public Builder clearData() {
        data_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000040);
        onChanged();
        return this;
      }

      private int flag_ ;
      /**
       * <code>optional int32 flag = 8;</code>
       */
      public int getFlag() {
        return flag_;
      }
      /**
       * <code>optional int32 flag = 8;</code>
       */
      public Builder setFlag(int value) {
        
        flag_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 flag = 8;</code>
       */
      public Builder clearFlag() {
        
        flag_ = 0;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:Message)
    }

    // @@protoc_insertion_point(class_scope:Message)
    private static final Message DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Message();
    }

    public static Message getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Message>
        PARSER = new com.google.protobuf.AbstractParser<Message>() {
      public Message parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new Message(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Message> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<Message> getParserForType() {
      return PARSER;
    }

    public Message getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Message_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_Message_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\rMessage.proto\"\345\001\n\007Message\022\016\n\006length\030\001 " +
      "\001(\003\022\"\n\004type\030\002 \001(\0162\024.Message.MessageType\022" +
      "\017\n\007version\030\003 \001(\005\022\014\n\004from\030\004 \001(\t\022\n\n\002to\030\005 \001" +
      "(\t\022\016\n\006chatId\030\006 \001(\t\022\014\n\004data\030\007 \003(\014\022\014\n\004flag" +
      "\030\010 \001(\005\"O\n\013MessageType\022\010\n\004TEXT\020\000\022\014\n\010LOCAT" +
      "ION\020\001\022\t\n\005VOICE\020\002\022\t\n\005IMAGE\020\003\022\007\n\003ACK\020\004\022\t\n\005" +
      "ERROR\020\005B\"\n\024org.mchat.io.messageB\nMessage" +
      "Bufb\006proto3"
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
    internal_static_Message_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Message_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_Message_descriptor,
        new String[] { "Length", "Type", "Version", "From", "To", "ChatId", "Data", "Flag", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}