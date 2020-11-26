package com.hiwork.service;

import java.util.List;
import com.hiwork.dao.mariadb.VAppDao;
import com.hiwork.domain.VApp;

public class DefaultVAppService implements VAppService {
  VAppDao vAppDao;

  public DefaultVAppService(VAppDao vAppDao) {
    this.vAppDao = vAppDao;
  }

  @Override
  public int delete(int no) throws Exception {
    return vAppDao.delete(no);
  }

  @Override
  public int add(VApp vApp) throws Exception {
    return vAppDao.insert(vApp);
  }

  @Override
  public List<VApp> list() throws Exception {
    return vAppDao.find();
  }

  @Override
  public int update(VApp vApp) throws Exception {
    return vAppDao.update(vApp);
  }
}
