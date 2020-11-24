package com.hiwork.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.hiwork.dao.CInfoDao;
import com.hiwork.domain.CInfo;

// Mybatis 적용
// => SqlSessionFactory를 자체적으로 생성하지 않고
//    생성자를 통해 외부에서 주입 받는다.(Dependency Injection: DI)
//
public class CInfoDaoImpl implements CInfoDao{

  SqlSessionFactory sqlSessionFactory;

  // 생성자
  public CInfoDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }



  @Override
  public int delete(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.delete("CInfo.delete", no);
    }
  }


  @Override
  public List<CInfo> find() throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("CInfoDao.find");
    }
  }

  @Override
  public int update(CInfo cInfo) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.update("CInfoDao.update", cInfo);
    }
  }



  @Override
  public int insert(CInfo cInfo) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.insert("CInfoDao.insert", cInfo);
    }
  }
}








