package com.crud.user.Service;

import com.crud.user.Entity.User;
import java.util.List;

public interface UserServiceImpl {

    public List<User> getAllUsers();

    public User getById(long id);

    public User createUsers(User user);

    public void deleteUserById(long id);

    void deleteAllUsers();
}
