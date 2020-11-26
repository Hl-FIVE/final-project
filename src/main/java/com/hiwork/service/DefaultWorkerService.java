package com.hiwork.service;

import java.util.List;
import com.hiwork.dao.WorkerDao;
import com.hiwork.domain.Worker;

public class DefaultWorkerService implements WorkerService {

  WorkerDao workerDao;

  public DefaultWorkerService(WorkerDao workerDao) {
    this.workerDao = workerDao;
  }

  @Override
  public List<Worker> list() throws Exception {
    return workerDao.findAll();
  }
}
