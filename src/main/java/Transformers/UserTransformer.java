package Transformers;

import Dtos.RequestDtos.UserDto;
import Models.User;

public class UserTransformer {

    public static User convertDtoToEntity(UserDto userDto){
        User user = User.builder().userName(userDto.getUserName()).age(userDto.getAge()).
                build();

        return user;
    }
}
