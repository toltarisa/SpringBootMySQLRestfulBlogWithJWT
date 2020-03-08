package com.spring.demoblog.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="post")
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at",nullable=false,updatable=false)
	@CreationTimestamp
	private Date createdAt;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy="post", cascade= {CascadeType.ALL})
	private List<Comment> comment;
	
	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


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


	public List<Comment> getComment() {
		return comment;
	}


	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	
	
	

	
	
}
