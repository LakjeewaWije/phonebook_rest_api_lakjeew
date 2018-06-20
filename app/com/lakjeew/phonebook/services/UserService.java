package com.lakjeew.phonebook.services;

import com.lakjeew.phonebook.models.User;

public interface UserService {
    User addUser(User userToAdd);

    User updateUser(User userToUpdate);

    User deleteUser(long idToDelete);
}
