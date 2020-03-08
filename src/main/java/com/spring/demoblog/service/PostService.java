package com.spring.demoblog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demoblog.entity.Post;
import com.spring.demoblog.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	
	public void createPost(Post post) {
		postRepository.save(post);
	}
	
	public Iterable<Post> listPosts(){
		return postRepository.findAll();
	}
	
	public Post getPostById(Long id) {
		Post post = postRepository.findById(id).get();
		return post;
	}
	
	public void removePost(Long id) {
		postRepository.deleteById(id);
	}
	
	public List<Post> findPostByUserId(Long user_id){
		return postRepository.findByUserId(user_id);
	}

}
