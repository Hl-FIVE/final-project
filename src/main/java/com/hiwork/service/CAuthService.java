package com.hiwork.service;

import java.util.List;
import com.hiwork.domain.CAuth;

public interface CAuthService {

  int delete(int no) throws Exception;
  int add(CAuth cAuth) throws Exception;
  List<CAuth> list() throws Exception;
  int update(CAuth cAuth) throws Exception;

}
