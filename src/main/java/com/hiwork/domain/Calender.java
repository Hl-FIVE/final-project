package com.hiwork.domain;

import java.sql.Date;

public class Calender {
  private String calCode;
  private int wNo;
  private String title;
  private Date sdt;
  private Date edt;
  private String content;
  private String place;

  public String getCalCode() {
    return calCode;
  }
  public void setCalCode(String calCode) {
    this.calCode = calCode;
  }
  public int getwNo() {
    return wNo;
  }
  public void setwNo(int wNo) {
    this.wNo = wNo;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public Date getSdt() {
    return sdt;
  }
  public void setSdt(Date sdt) {
    this.sdt = sdt;
  }
  public Date getEdt() {
    return edt;
  }
  public void setEdt(Date edt) {
    this.edt = edt;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public String getPlace() {
    return place;
  }
  public void setPlace(String place) {
    this.place = place;
  }



}
