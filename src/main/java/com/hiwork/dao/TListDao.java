package com.hiwork.dao;

import java.util.List;
import com.hiwork.domain.TList;

public interface TListDao {
  int insert(TList tList) throws Exception;
  int delete(int no) throws Exception;
  List<TList> find() throws Exception;
  int update(TList tList) throws Exception;
}
