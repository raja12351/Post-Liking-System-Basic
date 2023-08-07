package com.example.social.media.platform.Controllers;

import com.example.social.media.platform.Dtos.RequestDtos.PostDto;
import com.example.social.media.platform.Exceptions.PostNotFound;
import com.example.social.media.platform.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    public ResponseEntity<String> addPost(@RequestBody PostDto postDto){
        try{
            String message = postService.addPost(postDto);
            return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    public ResponseEntity<String> addLike(@RequestParam Integer postId) throws PostNotFound {
        try{
            String mess = postService.addLike(postId);
            return new ResponseEntity<>(mess, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
