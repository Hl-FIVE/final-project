package com.hiwork.service;

import java.util.List;
import com.hiwork.dao.BoardDao;
import com.hiwork.domain.Board;

public class DefaultBoardService implements BoardService {

  BoardDao boardDao;

  @Override
  public List<Board> findAll() throws Exception {
    return boardDao.findAll();
  }


}
