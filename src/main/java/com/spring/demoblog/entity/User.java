package com.spring.demoblog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private Long id;

	@Size(min=5,max=255)
	@NotBlank(message="You need to enter your username")
	@Column(name="username",nullable=false,unique = true)
	private String username;

	@Size(min=5,max=50)
	@NotBlank(message="You need to enter your name")
	@Column(name="name",nullable=false)
	private String name;

	@Size(min=13,max=255)
	@Email(message="Please provide valid email")
	@NotBlank(message="You need to specify an email address")
	@Column(name="email",nullable=false,unique=true)
	private String email;


	@Size(min=6,max=120)
	@NotBlank(message="You need the enter valid password(min 6 character,max 120 character)")
	@Column(name="password",nullable=false)
	private String password;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles",joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	@OneToMany(mappedBy="user", cascade= {CascadeType.ALL})
	private List<Post> post;
	
	@OneToMany(mappedBy="user", cascade= {CascadeType.ALL})
	private List<Comment> comment;
	
	public User() {
		
	}

    public User(String name, String username, String email, String encode) {
    }


    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
