package com.hiwork.service;

import java.util.List;
import com.hiwork.dao.TListDao;
import com.hiwork.domain.TList;

public class DefaultTListService implements TListService {
  TListDao tListDao;

  public DefaultTListService(TListDao tListDao) {
    this.tListDao = tListDao;
  }

  @Override
  public int delete(int no) throws Exception {
    return tListDao.delete(no);
  }

  @Override
  public int add(TList tList) throws Exception {
    return tListDao.insert(tList);
  }

  @Override
  public List<TList> list() throws Exception {
    return tListDao.find();
  }

  @Override
  public int update(TList tList) throws Exception {
    return tListDao.update(tList);
  }
}
