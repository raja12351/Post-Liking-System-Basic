package Controllers;

import Dtos.RequestDtos.PostDto;
import Models.Notifications;
import Service.PostService;
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
    public ResponseEntity<Notifications> addLike(@RequestParam Integer postId){
        Notifications notifications = postService.addLike(postId);
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }
}
