package com.blog.assignment.Repository;

import com.blog.assignment.Model.User;

import java.util.List;

public interface AdminRepository {

    public List<User> findAllDetails();

    public User findUserById(Long id);

}
