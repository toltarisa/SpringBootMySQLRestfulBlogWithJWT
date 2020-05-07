package com.spring.demoblog.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.spring.demoblog.entity.audit.AuditModel;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="post")
public class Post extends AuditModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="post_id")
	private Long id;
	
	@NotBlank(message="Title of post required")
	@Size(min=20,max=200)
	@Column(name="title")
	private String title;
	
	@NotBlank(message="content of post required")
	@Size(min=50,max=500)
	@Column(name="content")
	private String content;
	

	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;


	public Post() {
		
	}
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}



}
