package com.blog.assignment.Controller;

import com.blog.assignment.Model.User;
import com.blog.assignment.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    AdminRepository adminrep;

    @GetMapping("users")
    public List<User> findAllDetails(){
        return adminrep.findAllDetails();
    }

    @GetMapping("users/{id}")
    public User findUserById(@PathVariable Long id){
        User res = adminrep.findUserById(id);
        if(res == null){
            throw new RuntimeException("User not found - " + id);
        }
        return res;
    }

}
