package com.hiwork.dao;

import java.util.List;
import com.hiwork.domain.Auth;

public interface AuthDao {

  int insert(Auth auth) throws Exception;
  int delete(int no) throws Exception;
  List<Auth> find() throws Exception;
  int update(Auth auth) throws Exception;
}
