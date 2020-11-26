package com.hiwork.domain;

import java.sql.Date;

public class Worker {
  
  public static final int ADMIN = 9; // 관리자
  public static final int STAFF = 0; // 사원
  public static final int HR= 1; // Human Resources 인사
  
  private int authority;
  
  private int wNo; // 사원 번호
  private int gender; // 성별
  private String wName; // 사원 이름
  private String email; // 사원 이메일
  private int pwd; // 비밀번호
  private String wPhoto; // 사원 사진
  private String rank; // 사원 직급
  private int tel; // 휴대폰번호
  private String eType; // 고용형태
  private Date regiDate; // 입사일  
  private int tAnnu; // 총 연차
  private int eSt; // 재직상태
  
  public int getAuthority() {
    return authority;
  }
  public void setAuthority(int authority) {
    this.authority = authority;
  }
  
  public static int getAdmin() {
    return ADMIN;
  }
  public static int getStaff() {
    return STAFF;
  }
  public static int getHr() {
    return HR;
  }
  public int getwNo() {
    return wNo;
  }
  public int getGender() {
    return gender;
  }
  public String getwName() { 
    return wName;
  }
  public String getEmail() {
    return email;
  }
  public int getPwd() {
    return pwd;
  }
  public String getwPhoto() {
    return wPhoto;
  }
  public String getRank() {
    return rank;
  }
  public int getTel() {
    return tel;
  }
  public String geteType() {
    return eType;
  }
  public Date getRegiDate() {
    return regiDate;
  }
  public int gettAnnu() {
    return tAnnu;
  }
  public int geteSt() {
    return eSt;
  }
  public void setwNo(int wNo) {
    this.wNo = wNo;
  }
  public void setGender(int gender) {
    this.gender = gender;
  }
  public void setwName(String wName) {
    this.wName = wName;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public void setPwd(int pwd) {
    this.pwd = pwd;
  }
  public void setwPhoto(String wPhoto) {
    this.wPhoto = wPhoto;
  }
  public void setRank(String rank) {
    this.rank = rank;
  }
  public void setTel(int tel) {
    this.tel = tel;
  }
  public void seteType(String eType) {
    this.eType = eType;
  }
  public void setRegiDate(Date regiDate) {
    this.regiDate = regiDate;
  }
  public void settAnnu(int tAnnu) {
    this.tAnnu = tAnnu;
  }
  public void seteSt(int eSt) {
    this.eSt = eSt;
  }
  
}
