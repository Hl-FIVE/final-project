package com.hiwork.service;

import java.util.List;
import com.hiwork.domain.Board2;

public interface BoardService2 {
  int delete(int no) throws Exception;
  int add(Board2 board) throws Exception;
  List<Board2> list() throws Exception;
  List<Board2> list(String keyword) throws Exception;
  Board2 get(int no) throws Exception;
  int update(Board2 board) throws Exception;
}
