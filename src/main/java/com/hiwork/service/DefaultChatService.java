package com.hiwork.service;

import java.util.List;
import com.hiwork.dao.ChatDao;
import com.hiwork.domain.Chat;

public class DefaultChatService implements ChatService {

  ChatDao chatDao;

  public DefaultChatService(ChatDao chatDao) {
    this.chatDao = chatDao;
  }

  @Override
  public List<Chat> list() throws Exception {
    return chatDao.find();
  }

}
