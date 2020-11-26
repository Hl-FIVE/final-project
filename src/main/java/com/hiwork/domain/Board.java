package com.hiwork.domain;

import java.util.Date;

public class Board {

  // 게시판
  public static final int NOTICE = 1;      // 공지사항
  public static final int NEWS = 2;        // 사내소식
  public static final int BB = 3;          // 사내게시판
  public static final int CAFETERIA = 4;   // 구내식단

  // 게시글 정보
  private int bNo;
  // private int bNo2;              // 게시판 번호 (외래키)
  // private int wNo;               // 사원 번호 (외래키)
  private String title;
  private Date regiDate;
  private int vCount;
  private String aFile;
  private int fSize;
  private String content;


  public int getbNo() {
    return bNo;
  }

  public void setbNo(int bNo) {
    this.bNo = bNo;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Date getRegiDate() {
    return regiDate;
  }

  public void setRegiDate(Date regiDate) {
    this.regiDate = regiDate;
  }

  public int getvCount() {
    return vCount;
  }

  public void setvCount(int vCount) {
    this.vCount = vCount;
  }

  public String getaFile() {
    return aFile;
  }

  public void setaFile(String aFile) {
    this.aFile = aFile;
  }

  public int getfSize() {
    return fSize;
  }

  public void setfSize(int fSize) {
    this.fSize = fSize;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public static int getNotice() {
    return NOTICE;
  }

  public static int getNews() {
    return NEWS;
  }

  public static int getBb() {
    return BB;
  }

  public static int getCafeteria() {
    return CAFETERIA;
  }





}
