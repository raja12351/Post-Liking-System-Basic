package com.example.social.media.platform.Controllers;

import com.example.social.media.platform.Dtos.RequestDtos.UserDto;
import com.example.social.media.platform.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    public ResponseEntity<String> addUser(@RequestBody UserDto userDto){
        String msg = userService.addUser(userDto);
        return new ResponseEntity<>(msg, HttpStatus.ACCEPTED);
    }
     public ResponseEntity<Integer> maxLikes(){
        Integer most = userService.findMax();

        return new ResponseEntity<>(most, HttpStatus.ACCEPTED);
     }
}
