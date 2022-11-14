package com.wswht.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wswht.api.dto.Post;
import com.wswht.api.service.PostService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class PostController {
	 
	@Autowired
	private PostService postService;
	
	@PostMapping("/posts")
    public void post(@RequestBody Post request) {
        postService.write(request);
    }
	
	@GetMapping("/posts/{postId}")
	public Post get(@PathVariable(name ="postId")Long id ) {
		return postService.get(id);
	}
	
	@GetMapping("/posts")
	public List<Post> getPosts(){
		return postService.getPosts();
	}

}
