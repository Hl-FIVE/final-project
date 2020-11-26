package com.hiwork.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.hiwork.dao.AuthDao;
import com.hiwork.domain.Auth;

public class AuthDaoImpl implements AuthDao{

  SqlSessionFactory sqlSessionFactory;

  public AuthDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }
  @Override
  public int delete(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.delete("Auth.delete", no);
    }
  }
  @Override
  public List<Auth> find() throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("AuthDao.find");
    }
  }
  @Override
  public int update(Auth auth) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.update("AuthDao.update", auth);
    }
  }
  @Override
  public int insert(Auth auth) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.insert("AuthDao.insert", auth);
    }
  }
}
