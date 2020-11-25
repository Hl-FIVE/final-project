package com.hiwork.dao;

import java.util.List;
import com.hiwork.domain.CRoom;

public interface CRoomDao {

  int insert(CRoom cRoom) throws Exception;
  int delete(int no) throws Exception;
  List<CRoom> findAll() throws Exception;
  int update(CRoom cRoom) throws Exception;
}







