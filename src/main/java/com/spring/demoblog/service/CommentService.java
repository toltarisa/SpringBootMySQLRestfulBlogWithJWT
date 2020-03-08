package com.spring.demoblog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demoblog.entity.Comment;
import com.spring.demoblog.repository.CommentRepository;


@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;
	
	
	public void addComment(Comment comment) {
		commentRepository.save(comment);
	}
	
	public Comment getCommentById(Long id) {
		return commentRepository.findById(id).get();
	}
	
	public List<Comment> findByUserId(Long id){
		return commentRepository.findByUserId(id);
	}
	
	public List<Comment> findByPostId(Long post_id){
		return commentRepository.findByPostId(post_id);
	}

	
}
