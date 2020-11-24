package com.hiwork.service;

import java.util.List;
import com.hiwork.dao.BoardDao;
import com.hiwork.domain.Board2;

public class DefaultBoardService2 implements BoardService2 {

  BoardDao boardDao;

  public DefaultBoardService2(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public int delete(int no) throws Exception {
    return boardDao.delete(no);
  }

  @Override
  public int add(Board2 board) throws Exception {
    return boardDao.insert(board);
  }

  @Override
  public List<Board2> list() throws Exception {
    return boardDao.findAll(null);
  }

  @Override
  public List<Board2> list(String keyword) throws Exception {
    return boardDao.findAll(keyword);
  }

  @Override
  public Board2 get(int no) throws Exception {
    Board2 board = boardDao.findByNo(no);
    if (board != null) {
      boardDao.updateViewCount(no);
    }
    return board;
  }

  @Override
  public int update(Board2 board) throws Exception {
    return boardDao.update(board);
  }

}
