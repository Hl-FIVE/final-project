package com.hiwork.service;

import java.util.List;
import com.hiwork.domain.VApp;

public interface VAppService {

  int delete(int no) throws Exception;
  int add(VApp vApp) throws Exception;
  List<VApp> list() throws Exception;
  int update(VApp vApp) throws Exception;
}
