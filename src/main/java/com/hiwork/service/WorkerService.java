package com.hiwork.service;

import java.util.List;
import com.hiwork.domain.Worker;

public interface WorkerService {
  List<Worker> list() throws Exception;
}
