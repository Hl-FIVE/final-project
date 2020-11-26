package com.hiwork.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.hiwork.dao.CAuthDao;
import com.hiwork.domain.CAuth;

public class CAuthDaoImpl implements CAuthDao{

  SqlSessionFactory sqlSessionFactory;

  public CAuthDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }
  @Override
  public int delete(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.delete("CAuth.delete", no);
    }
  }
  @Override
  public List<CAuth> find() throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("CAuthDao.find");
    }
  }
  @Override
  public int update(CAuth cAuth) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.update("CAuthDao.update", cAuth);
    }
  }
  @Override
  public int insert(CAuth cAuth) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.insert("CAuthDao.insert", cAuth);
    }
  }
}
