package com.blog.assignment.Repository;

import com.blog.assignment.Model.Post;
import com.blog.assignment.Model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class AdminRepositoryImpl implements AdminRepository {

    @Override
    public List<User> findAllDetails() {
        RestTemplate r = new RestTemplate();
        String getUsersUrl = "https://jsonplaceholder.typicode.com/users";
        ResponseEntity<User[]> responseEntityUser =
                r.getForEntity(getUsersUrl, User[].class);
        User[] userArray = responseEntityUser.getBody();
        List<User> users = Arrays.asList(userArray);
        String getPostUrl = "https://jsonplaceholder.typicode.com/posts";
        ResponseEntity<Post[]> responseEntityPost =
                r.getForEntity(getPostUrl, Post[].class);
        Post[] postArray = responseEntityPost.getBody();
        List<Post> posts = Arrays.asList(postArray);
        for (User u: users) {
            List<Post> p1 = posts.stream().filter(p -> Objects.equals(u.getId(), p.getUserId())).collect(Collectors.toList());
            u.setPosts(p1);
        }
        return users;
    }

    @Override
    public User findUserById(Long id) {
        RestTemplate r = new RestTemplate();
        String getUsersUrl = "https://jsonplaceholder.typicode.com/users";
        ResponseEntity<User[]> responseEntityUser =
                r.getForEntity(getUsersUrl, User[].class);
        User[] userArray = responseEntityUser.getBody();
        List<User> users = Arrays.asList(userArray);
        String getPostUrl = "https://jsonplaceholder.typicode.com/posts";
        ResponseEntity<Post[]> responseEntityPost =
                r.getForEntity(getPostUrl, Post[].class);
        Post[] postArray = responseEntityPost.getBody();
        List<Post> posts = Arrays.asList(postArray);
        List<Post> p1 = posts.stream().filter(p -> Objects.equals(id, p.getUserId())).collect(Collectors.toList());;
        Optional<User> result = users.stream().filter(p -> Objects.equals(p.getId(), id)).findAny();
        if (result.isPresent()){
            result.get().setPosts(p1);
            return result.get();
        }
        return null;
    }


}
