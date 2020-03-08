package com.spring.demoblog.controller;

import com.spring.demoblog.entity.Post;
import com.spring.demoblog.entity.User;
import com.spring.demoblog.service.PostService;
import com.spring.demoblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;


    @RequestMapping(value="/api/posts",method = RequestMethod.POST)
    public void createPost(@RequestBody Post post){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        postService.createPost(post);
    }
    @RequestMapping(value = "/api/posts",method = RequestMethod.GET)
    public ResponseEntity<Iterable<Post>> getAllPosts(){
        return ResponseEntity.ok(postService.listPosts());
    }

    @RequestMapping(value = "/api/posts/{id}",method = RequestMethod.GET)
    public ResponseEntity<Post> getPostByID(@PathVariable Long id){
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @RequestMapping(value = "/api/posts/{id}", method = RequestMethod.DELETE)
    public void removePost(@PathVariable Long id){
        postService.removePost(id);
    }
    @RequestMapping(value = "/api/{user_id}/posts")
    public ResponseEntity<List<Post>> getPostByUserId(@PathVariable Long user_id){
        return ResponseEntity.ok(postService.findPostByUserId(user_id));
    }

}
