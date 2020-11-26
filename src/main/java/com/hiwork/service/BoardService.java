package com.hiwork.service;

import java.util.List;
import com.hiwork.domain.Board;

public interface BoardService {

  List<Board> findAll() throws Exception;
}
