package com.lakjeew.phonebook.services.impl;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.lakjeew.phonebook.dao.UserDao;
import com.lakjeew.phonebook.dao.impl.UserDaoimpl;
import com.lakjeew.phonebook.models.User;
import com.lakjeew.phonebook.services.UserService;

public class UserServiceImpl implements UserService {
    @Inject
    @Named("userDao")
    private UserDao userDao;


    @Override
    public User addUser(User userToAdd) {
        UserDao userDao = new UserDaoimpl();

        User newuser = new User() ;
        if (!userToAdd.getuFirstname().isEmpty() && !userToAdd.getuLasttname().isEmpty()
                && !userToAdd.getuEmail().isEmpty()&& !userToAdd.getuPhoneno().isEmpty()
                && !userToAdd.getuPassword().isEmpty()) {
            newuser.setuFirstname(userToAdd.getuFirstname());
            newuser.setuLasttname(userToAdd.getuLasttname());
            newuser.setuEmail(userToAdd.getuEmail());
            newuser.setuPhoneno(userToAdd.getuPhoneno());
            newuser.setuPassword(userToAdd.getuPassword());
        }
        return userDao.addUser(newuser);
    }

    /**
     * Validate and transfer data from the database user to req user and update
     * @param userToUpdate user object from the request
     * @return updated user in the database
     */
    @Override
    public User updateUser(User userToUpdate) {

        UserDao userDao = new UserDaoimpl();


//        userToUpdate != null

        //Get user from database
        User userInDb = userDao.searchUser(userToUpdate.getuId());


        //Transfer data from request object..
        if (!userToUpdate.getuFirstname().isEmpty())
            userInDb.setuFirstname(userToUpdate.getuFirstname());
        //Last name
        //Email
        //Password


        //update and return updated user
        return userDao.updateUser(userInDb);
    }


    /**
     * Delete user from database
     * @param idToDelete user's id to delete
     * @return deleted User
     */
    @Override
    public User deleteUser(long idToDelete) {

        //Get user from the database
        User userInDb = userDao.searchUser(idToDelete);

        //Check user is null
        if (userInDb == null){
            return null;
        }

        //Delete user and return user
        return userDao.deleteUser(userInDb);
    }
}
