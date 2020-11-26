package com.hiwork.service;

import java.util.List;
import com.hiwork.dao.CAuthDao;
import com.hiwork.domain.CAuth;

public class DefaultCAuthService implements CAuthService {

  CAuthDao cAuthDao;

  public DefaultCAuthService(CAuthDao cAuthDao) {
    this.cAuthDao = cAuthDao;
  }

  @Override
  public int delete(int no) throws Exception {
    return cAuthDao.delete(no);
  }

  @Override
  public int add(CAuth cAuth) throws Exception {
    return cAuthDao.insert(cAuth);
  }

  @Override
  public List<CAuth> list() throws Exception {
    return cAuthDao.find();
  }

  @Override
  public int update(CAuth cAuth) throws Exception {
    return cAuthDao.update(cAuth);
  }
}
