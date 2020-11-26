package com.hiwork.dao;

import java.util.List;
import com.hiwork.domain.CAuth;

public interface CAuthDao {

  int insert(CAuth cAuth) throws Exception;
  int delete(int no) throws Exception;
  List<CAuth> find() throws Exception;
  int update(CAuth cAuth) throws Exception;
}
