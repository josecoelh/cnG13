// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpcService.proto

package services;

public interface SessionIdOrBuilder extends
    // @@protoc_insertion_point(interface_extends:primesservice.SessionId)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string id = 1;</code>
   */
  java.lang.String getId();
  /**
   * <code>string id = 1;</code>
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <code>bool credentials = 2;</code>
   */
  boolean getCredentials();

  /**
   * <code>bool alreadyLoggedIn = 3;</code>
   */
  boolean getAlreadyLoggedIn();
}