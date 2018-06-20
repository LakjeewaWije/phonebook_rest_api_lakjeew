package com.lakjeew.phonebook.controllers;

import com.lakjeew.phonebook.dao.UserDao;
import com.lakjeew.phonebook.dao.impl.UserDaoimpl;
import com.lakjeew.phonebook.models.User;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;

public class UserController extends Controller{
    /**
     * Save user to databases from the request(Use hard coded user)
     * @return user saved in the database
     */
    public Result addUser(){

        User usertosave = new User();
        usertosave.setuFirstname("laki");
        usertosave.setuLasttname("Wije");
        usertosave.setuEmail("123@gmail.com");
        usertosave.setuPassword("123");
        usertosave.setuPhoneno("121212121");

        UserDao userDao = new UserDaoimpl();

        User addedUser = userDao.addUser(usertosave);
        return ok("successfully added");

    }
}
