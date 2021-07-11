package com.crud.user.Controller;

import com.crud.user.Entity.User;
import com.crud.user.Service.UserServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController{

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/create")
    private ResponseEntity<User> saveUsers(@RequestBody User user)
    {
        User userCreated = userServiceImpl.createUsers(user);
        return new ResponseEntity<User>(userCreated,HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    private ResponseEntity<List<User>> getAllUsers()
    {
        List<User> userList = userServiceImpl.getAllUsers();
        return ResponseEntity.ok().body(userList);
    }

    @GetMapping("/{id}")
    private ResponseEntity<User> getById(@PathVariable("id") int id) {
        User user = userServiceImpl.getById(id);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<String> deleteById(@PathVariable("id") int id)
    {
        User userDeleted=userServiceImpl.getById(id);
        userServiceImpl.deleteUserById(id);

        return new ResponseEntity<>("User Deleted : \n"+userDeleted,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    private ResponseEntity<String> deleteAll()
    {
        userServiceImpl.deleteAllUsers();

        return new ResponseEntity<String>("All Users Deleted",HttpStatus.OK);
    }

    @PutMapping("/update")
    private ResponseEntity<User> update(@RequestBody User user)
    {
        User userCreated = userServiceImpl.createUsers(user);
        return new ResponseEntity<User>(userCreated,HttpStatus.CREATED);
    }
}
