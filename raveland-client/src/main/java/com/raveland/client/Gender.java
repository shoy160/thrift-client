/**
 * Autogenerated by Thrift Compiler (0.14.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.raveland.client;


@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.14.1)", date = "2021-05-26")
public enum Gender implements org.apache.thrift.TEnum {
  Male(1),
  Female(2);

  private final int value;

  private Gender(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  @org.apache.thrift.annotation.Nullable
  public static Gender findByValue(int value) { 
    switch (value) {
      case 1:
        return Male;
      case 2:
        return Female;
      default:
        return null;
    }
  }
}
