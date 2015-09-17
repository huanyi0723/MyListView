/*
 * Model.java
 * classes : com.nolanlawson.customfastscrollviewdemo.Model
 * @author  张奕
 * V 1.0.0
 * Create at 2015年8月19日 下午2:53:38
 */
package com.example.mylistview;

/**
 * com.nolanlawson.customfastscrollviewdemo.Model
 * 
 * @author 张奕 <br/>
 *         create at 2015年8月19日 下午2:53:38
 */
public class Model {

  private String key; // 列表中显示
  private String value; // 提示中显示
  private String other;

  public Model(String key, String value) {
    super();
    this.key = key;
    this.value = value;
  }

  /**
   * @return the key
   */
  public String getKey() {
    return this.key;
  }

  /**
   * @param key
   *          the key to set
   */
  public void setKey(String key) {
    this.key = key;
  }

  /**
   * @return the value
   */
  public String getValue() {
    return this.value;
  }

  /**
   * @param value
   *          the value to set
   */
  public void setValue(String value) {
    this.value = value;
  }

}
