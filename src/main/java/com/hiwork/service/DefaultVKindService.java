package com.hiwork.service;

import java.util.List;
import com.hiwork.dao.VKindDao;
import com.hiwork.domain.VKind;

public class DefaultVKindService implements VKindService {

  VKindDao vKindDao;

  public DefaultVKindService(VKindDao vKindDao) {
    this.vKindDao = vKindDao;
  }

  @Override
  public List<VKind> list() throws Exception {
    return vKindDao.find();
  }
}
