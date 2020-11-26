package com.hiwork.dao;

import java.util.List;
import com.hiwork.domain.Worker;

public interface WorkerDao {
  List<Worker> findAll() throws Exception; // 회원 찾기
}
