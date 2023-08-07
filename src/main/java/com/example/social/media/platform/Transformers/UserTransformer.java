package com.example.social.media.platform.Transformers;

import com.example.social.media.platform.Dtos.RequestDtos.UserDto;
import com.example.social.media.platform.Models.User;

public class UserTransformer {

    public static User convertDtoToEntity(UserDto userDto){
        User user = User.builder().userName(userDto.getUserName()).age(userDto.getAge()).
                build();

        return user;
    }
}
