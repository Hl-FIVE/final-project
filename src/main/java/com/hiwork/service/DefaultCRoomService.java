package com.hiwork.service;

import java.util.List;
import com.hiwork.dao.CRoomDao;
import com.hiwork.domain.CRoom;

public class DefaultCRoomService implements CRoomService {

  CRoomDao cRoomDao;

  public DefaultCRoomService(CRoomDao cRoomDao) {
    this.cRoomDao = cRoomDao;
  }

  @Override
  public List<CRoom> list() throws Exception {
    return cRoomDao.find();
  }

}
