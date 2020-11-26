package com.hiwork.service;

import java.util.List;
import com.hiwork.dao.AuthDao;
import com.hiwork.domain.Auth;

public class DefaultAuthService implements AuthService {

  AuthDao authDao;

  public DefaultAuthService(AuthDao authDao) {
    this.authDao = authDao;
  }

  @Override
  public int delete(int no) throws Exception {
    return authDao.delete(no);
  }

  @Override
  public int add(Auth auth) throws Exception {
    return authDao.insert(auth);
  }

  @Override
  public List<Auth> list() throws Exception {
    return authDao.find();
  }

  @Override
  public int update(Auth auth) throws Exception {
    return authDao.update(auth);
  }
}
