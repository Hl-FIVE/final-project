package com.hiwork.domain;

import java.sql.Date;

public class Chat {
  private int cNo;
  private int wNo;
  private int gChatCode;
  private String cContent;
  private String cName;
  private Date cDate;
  public int getcNo() {
    return cNo;
  }
  public void setcNo(int cNo) {
    this.cNo = cNo;
  }
  public int getwNo() {
    return wNo;
  }
  public void setwNo(int wNo) {
    this.wNo = wNo;
  }
  public int getgChatCode() {
    return gChatCode;
  }
  public void setgChatCode(int gChatCode) {
    this.gChatCode = gChatCode;
  }
  public String getcContent() {
    return cContent;
  }
  public void setcContent(String cContent) {
    this.cContent = cContent;
  }
  public String getcName() {
    return cName;
  }
  public void setcName(String cName) {
    this.cName = cName;
  }
  public Date getcDate() {
    return cDate;
  }
  public void setcDate(Date cDate) {
    this.cDate = cDate;
  }



}
