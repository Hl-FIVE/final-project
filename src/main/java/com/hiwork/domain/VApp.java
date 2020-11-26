package com.hiwork.domain;

import java.sql.Date;

public class VApp {
  private int vNo;
  private String vCode;
  private int wNo;
  private Date adt;
  private Date sdt;
  private Date edt;
  private int used;
  private String rs;
  private String appr;

  public int getvNo() {
    return vNo;
  }
  public void setvNo(int vNo) {
    this.vNo = vNo;
  }
  public String getvCode() {
    return vCode;
  }
  public void setvCode(String vCode) {
    this.vCode = vCode;
  }
  public int getwNo() {
    return wNo;
  }
  public void setwNo(int wNo) {
    this.wNo = wNo;
  }
  public Date getAdt() {
    return adt;
  }
  public void setAdt(Date adt) {
    this.adt = adt;
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
  public int getUsed() {
    return used;
  }
  public void setUsed(int used) {
    this.used = used;
  }
  public String getRs() {
    return rs;
  }
  public void setRs(String rs) {
    this.rs = rs;
  }
  public String getAppr() {
    return appr;
  }
  public void setAppr(String appr) {
    this.appr = appr;
  }
}
