package com.wswht.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wswht.api.dto.Post;
import com.wswht.api.entity.PostEntity;
import com.wswht.api.repository.PostRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public void write(Post post) {
		PostEntity postEntity = new PostEntity(post.getTitle(), post.getContent());

		postRepository.save(postEntity);
		System.out.println(postEntity.toString());
	}
	
	public Post get(Long id) {
		PostEntity postEntity = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 글"));
		Post post =new Post(postEntity.getTitle(),postEntity.getContent());
		//return post;
		return Post.builder().title(postEntity.getTitle()).content(postEntity.getContent()).build();
	}
	
	public List<Post> getPosts() {
		// TODO Auto-generated method stub
		List<Post> postList =new ArrayList<Post>();
		List<PostEntity> postEntityLists=  postRepository.findAll();
		for(PostEntity entity: postEntityLists ) {
			Post post = new Post(entity.getId(),entity.getTitle(),entity.getContent());
			postList.add(post);
		}
		return postList;
	}

}
