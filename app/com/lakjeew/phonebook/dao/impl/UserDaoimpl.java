package com.lakjeew.phonebook.dao.impl;

import com.avaje.ebean.Model;
import com.lakjeew.phonebook.dao.UserDao;
import com.lakjeew.phonebook.models.User;

public class UserDaoimpl implements UserDao {

    public static final Model.Finder<Long, User> find = new Model.Finder<>(User.class);
    @Override
    public User addUser(User usertoAdd) {
        usertoAdd.save();
        return usertoAdd;
    }

    @Override
    public User updateUser(User usertoUpdate) {
        usertoUpdate.update();
        return usertoUpdate;
    }

    @Override
    public User deleteUser(User usertoDelete) {
        usertoDelete.delete();
        return usertoDelete;
    }

    @Override
    public User searchUser(Long idtoSearch) {
        return find.byId(idtoSearch);

    }
}
