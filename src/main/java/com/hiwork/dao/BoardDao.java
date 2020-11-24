package com.hiwork.dao;

import java.util.List;
import com.hiwork.domain.Board2;

public interface BoardDao {
  int insert(Board2 board) throws Exception;
  int delete(int no) throws Exception;
  Board2 findByNo(int no) throws Exception;
  List<Board2> findAll(String keyword) throws Exception;
  int update(Board2 board) throws Exception;
  int updateViewCount(int no) throws Exception;
}








