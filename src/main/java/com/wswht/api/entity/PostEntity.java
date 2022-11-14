package com.wswht.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class PostEntity {

	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String content;

	@Builder
	public PostEntity(String title, String content) {
		this.title = title;
		this.content = content;
	}
}
