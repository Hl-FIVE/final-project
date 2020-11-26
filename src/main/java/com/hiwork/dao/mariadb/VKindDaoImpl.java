package com.hiwork.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.hiwork.dao.VKindDao;
import com.hiwork.domain.VKind;

public class VKindDaoImpl implements VKindDao {
  SqlSessionFactory sqlSessionFactory;

  public VKindDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public List<VKind> find() throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("VKindDao.find");
    }
  }
}
