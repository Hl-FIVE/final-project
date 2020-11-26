package com.hiwork.service;

import java.util.List;
import com.hiwork.dao.CalenderDao;
import com.hiwork.domain.Calender;


public class DefaultCalenderService implements CalenderService {

  CalenderDao calenderDao;

  public DefaultCalenderService(CalenderDao calenderDao) {
    this.calenderDao = calenderDao;
  }

  @Override
  public List<Calender> list() throws Exception {
    return calenderDao.find();
  }

}
