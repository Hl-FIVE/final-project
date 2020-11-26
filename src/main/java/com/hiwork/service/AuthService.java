package com.hiwork.service;

import java.util.List;
import com.hiwork.domain.Auth;

public interface AuthService {

  int delete(int no) throws Exception;
  int add(Auth auth) throws Exception;
  List<Auth> list() throws Exception;
  int update(Auth auth) throws Exception;

}
