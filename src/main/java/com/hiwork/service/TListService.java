package com.hiwork.service;

import java.util.List;
import com.hiwork.domain.TList;

public interface TListService {

  int delete(int no) throws Exception;
  int add(TList tList) throws Exception;
  List<TList> list() throws Exception;
  int update(TList tList) throws Exception;

}
