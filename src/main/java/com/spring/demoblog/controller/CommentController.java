package com.spring.demoblog.controller;
import com.spring.demoblog.entity.Comment;
import com.spring.demoblog.service.CommentService;
import com.spring.demoblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private PostService postService;

    @RequestMapping(value = "/api/posts/{post_id}/comments",method = RequestMethod.GET)
    public Page<Comment> getAllCommentsById(@PathVariable (value="post_id") Long post_id, Pageable pageable) {
        return commentService.findByPostId(post_id,  pageable);
    }

    @RequestMapping(value = "/api/posts/{post_id}/comments",method = RequestMethod.POST)
    public Comment addComment(@PathVariable (value = "post_id") Long post_id, @Valid @RequestBody Comment comment){
        return commentService.createComment(post_id,comment);
    }

    @RequestMapping(value = "/api/posts/{post_id}/comments/{comment_id}", method = RequestMethod.PUT)
    public Comment updateComment(@PathVariable (value = "post_id") Long post_id,
                                 @PathVariable (value="comment_id") Long comment_id,
                                 @Valid @RequestBody Comment commentRequest
    ){
        return commentService.updateComment(post_id,comment_id,commentRequest);
    }

    @RequestMapping(value = "/api/posts/{post_id}/comments/{comment_id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteComment(@PathVariable (value = "post_id") Long post_id,
                                           @PathVariable (value = "comment_id") Long comment_id
    ) {
        return commentService.deleteComment(post_id,comment_id);
    }
}
