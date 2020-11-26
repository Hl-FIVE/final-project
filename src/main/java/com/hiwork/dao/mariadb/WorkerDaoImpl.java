package com.hiwork.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.hiwork.dao.WorkerDao;
import com.hiwork.domain.Worker;

public class WorkerDaoImpl implements WorkerDao{

  SqlSessionFactory sqlSessionFactory;

  public WorkerDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public List<Worker> findAll() throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("WorkerDao.findAll");
    }
  }
}
