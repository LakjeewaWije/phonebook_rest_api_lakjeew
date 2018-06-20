package com.lakjeew.phonebook.util;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.lakjeew.phonebook.dao.UserDao;
import com.lakjeew.phonebook.dao.impl.UserDaoimpl;
import com.lakjeew.phonebook.services.UserService;
import com.lakjeew.phonebook.services.impl.UserServiceImpl;

public class OnStartupModule extends AbstractModule {
    @Override
    protected void configure() {
        //Bind dao
        bind(UserDao.class).annotatedWith(Names.named("userDao")).to(UserDaoimpl.class);
        //bind Service
        bind(UserService.class).to(UserServiceImpl.class);
    }
}
