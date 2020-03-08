package com.spring.demoblog.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.demoblog.entity.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment,Long> {
	public List<Comment> findByPostId(Long post_id);
	public Optional<Comment> findByIdAndPostId(Long id , Long post_id);
	
	public List<Comment> findByUserId(Long id);
	public Optional<Comment> findByIdAndUserId(Long id, Long user_id);
	
}
