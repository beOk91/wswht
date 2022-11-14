package com.wswht.api.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Post {
	
	@Id @GeneratedValue
	private Long id;
	private String title;
	private String content;
	
	@Builder
	public Post(String title, String content) {
		this.title = title;
		this.content = content;
	}
}
