package com.lakjeew.phonebook.dao;

import com.lakjeew.phonebook.models.User;

public interface UserDao {

    User addUser(User usertoAdd);
    User updateUser(User usertoUpdate);
    User deleteUser(User usertoDelete);
    User searchUser(Long idtoSearch);

}
