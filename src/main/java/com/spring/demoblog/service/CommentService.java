package com.spring.demoblog.service;


import java.util.List;
import java.util.Optional;

import com.spring.demoblog.exception.ResourceNotFoundException;
import com.spring.demoblog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.demoblog.entity.Comment;
import com.spring.demoblog.repository.CommentRepository;


@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private PostRepository postRepository;
	
	
	public Comment createComment(Long post_id,Comment comment) {
		return postRepository.findById(post_id).map(post -> {
			comment.setPost(post);
			return commentRepository.save(comment);
		}).orElseThrow(()->new ResourceNotFoundException("PostId " + post_id + " not found"));
	}

	public Page<Comment> findByPostId(Long post_id, Pageable pageable){
		return commentRepository.findByPostId(post_id,pageable);
	}



	public Comment updateComment(Long post_id,Long comment_id,Comment commentRequest) {
		if(!postRepository.existsById(post_id)) {
			throw new ResourceNotFoundException("post_id"+post_id+"not found");
		}

		return commentRepository.findById(comment_id).map(comment -> {
			comment.setComment(commentRequest.getComment());
			return commentRepository.save(comment);
		}).orElseThrow(()->new ResourceNotFoundException("comment_id"+comment_id+"not found"));
	}

	public ResponseEntity<?> deleteComment(Long post_id,Long comment_id) {
		return commentRepository.findByIdAndPostId(comment_id,post_id).map(comment->{
			commentRepository.delete(comment);
			return ResponseEntity.ok().build();
		}).orElseThrow(()-> new ResourceNotFoundException("Comment not found with id"+comment_id+"and post_id"+post_id));
	}

	
	public List<Comment> findByUserId(Long id){
		return commentRepository.findByUserId(id);
	}
	


	
}
