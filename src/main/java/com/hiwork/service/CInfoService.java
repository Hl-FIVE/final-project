package com.hiwork.service;

import java.util.List;
import com.hiwork.domain.CInfo;

public interface CInfoService {

  int delete(int no) throws Exception;
  int add(CInfo cInfo) throws Exception;
  List<CInfo> list() throws Exception;
  int update(CInfo cInfo) throws Exception;

}
