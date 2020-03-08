package com.spring.demoblog.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.demoblog.entity.Post;

@Repository
public interface PostRepository extends CrudRepository<Post,Long> {
	public List<Post> findByUserId(Long userid);
	public Optional<Post> findByIdAndUserId(Long id,Long userid);
	
}
