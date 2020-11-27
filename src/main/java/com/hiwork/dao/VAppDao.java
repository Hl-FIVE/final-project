package com.hiwork.dao;

import java.util.List;
import com.hiwork.domain.VApp;

public interface VAppDao {

  int insert(VApp vApp) throws Exception;
  int delete(int no) throws Exception;
  List<VApp> find() throws Exception;
  int update(VApp vApp) throws Exception;
}
