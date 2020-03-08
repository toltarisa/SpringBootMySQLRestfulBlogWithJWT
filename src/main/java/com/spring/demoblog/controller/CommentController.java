package com.spring.demoblog.controller;
import com.spring.demoblog.entity.Comment;
import com.spring.demoblog.entity.Post;
import com.spring.demoblog.entity.User;
import com.spring.demoblog.service.CommentService;
import com.spring.demoblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private PostService postService;

    @PostMapping
    public void addComment(@RequestBody Comment comment,@PathVariable Long post_id){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post post = postService.getPostById(post_id);
        comment.setUser(user);
        comment.setPost(post);
        commentService.addComment(comment);
    }
    @RequestMapping(value = "/api/comments/{id}", method = RequestMethod.GET)
    public ResponseEntity<Comment> getComment(@PathVariable Long id) {
        return ResponseEntity.ok(commentService.getCommentById(id));
    }
    @RequestMapping(value = "/api/{user_id}/comments")
    public ResponseEntity<List<Comment>> getCommentsByUserId(@PathVariable Long user_id){
        return ResponseEntity.ok(commentService.findByUserId(user_id));
    }
    @RequestMapping(value = "/api/{post_id}/comments")
    public ResponseEntity<List<Comment>> getCommentsByPostId(@PathVariable Long post_id){
        return ResponseEntity.ok(commentService.findByPostId(post_id));
    }
}
