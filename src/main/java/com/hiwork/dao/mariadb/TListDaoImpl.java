package com.hiwork.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.hiwork.dao.TListDao;
import com.hiwork.domain.TList;

public class TListDaoImpl implements TListDao {
  SqlSessionFactory sqlSessionFactory;

  public TListDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public int delete(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.delete("TList.delete", no);
    }
  }
  @Override
  public List<TList> find() throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("TListDao.find");
    }
  }
  @Override
  public int update(TList tList) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.update("TListDao.update", tList);
    }
  }
  @Override
  public int insert(TList tList) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.insert("TListDao.insert", tList);
    }
  }
}
