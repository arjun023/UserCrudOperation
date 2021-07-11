package com.crud.user.Service;

import com.crud.user.Entity.User;
import com.crud.user.Repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserServiceImpl{

    @Autowired
    UserRepository userRepository;

    @PostConstruct
    public void init()
    {
        userRepository.saveAll(Stream.of(
                new User(999l,"PreCreated1","ASGARD"),
                new User(1000l,"PreCreated2","Vormir")
        ).collect(Collectors.toList()));
    }

    @Override
    public List<User> getAllUsers()
    {
        List<User> userList=new ArrayList<>();
        userRepository.findAll().forEach(user -> userList.add(user));
        return userList;
    }

    @Override
    public User getById(long id) { return userRepository.findById(id).get(); }

    @Override
    public User createUsers(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

}
