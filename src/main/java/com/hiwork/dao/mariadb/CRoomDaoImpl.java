package com.hiwork.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.hiwork.dao.CRoomDao;
import com.hiwork.domain.CRoom;

// Mybatis 적용
// => SqlSessionFactory를 자체적으로 생성하지 않고
//    생성자를 통해 외부에서 주입 받는다.(Dependency Injection: DI)
//
public class CRoomDaoImpl implements CRoomDao {

  SqlSessionFactory sqlSessionFactory;

  // 생성자
  public CRoomDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }


  @Override
  public List<CRoom> find() throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("CRoomDao.find");
    }
  }


}








