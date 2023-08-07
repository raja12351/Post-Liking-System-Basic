package com.example.social.media.platform.Service;

import com.example.social.media.platform.Dtos.RequestDtos.UserDto;
import com.example.social.media.platform.Models.User;
import com.example.social.media.platform.Repository.UserRepository;
import com.example.social.media.platform.Transformers.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String addUser(UserDto userDto) {
        User user = UserTransformer.convertDtoToEntity(userDto);
        userRepository.save(user);

        return "User is added in the database successfully";
    }

    public Integer findMax() {
         List<User> user = userRepository.findAll();

         int max = 0;
         for(User user1 : user){
             if(user1.getNotifications().size()>max){
                 max = user1.getNotifications().size();
             }
         }
         return max;
    }
}
