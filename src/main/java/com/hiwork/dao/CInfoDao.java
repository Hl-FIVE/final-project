package com.hiwork.dao;

import java.util.List;
import com.hiwork.domain.CInfo;

public interface CInfoDao {

  int insert(CInfo cInfo) throws Exception;
  int delete(int no) throws Exception;
  List<CInfo> find() throws Exception;
  int update(CInfo cInfo) throws Exception;
}







