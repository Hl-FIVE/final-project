package com.hiwork.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.hiwork.dao.VAppDao;
import com.hiwork.domain.VApp;

public class VAppDaoImpl implements VAppDao {

  SqlSessionFactory sqlSessionFactory;

  public VAppDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public int insert(VApp vApp) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.insert("VAppDao.insert", vApp);
    }
  }

  @Override
  public int delete(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.delete("VApp.delete", no);
    }
  }

  @Override
  public List<VApp> find() throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("VAppDao.find");
    }
  }

  @Override
  public int update(VApp vApp) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.update("VAppDao.update", vApp);
    }
  }
}
