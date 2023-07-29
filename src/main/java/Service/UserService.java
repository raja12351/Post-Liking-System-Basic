package Service;

import Dtos.RequestDtos.UserDto;
import Models.User;
import Repository.UserRepository;
import Transformers.UserTransformer;
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
             if(user1.getNotificationsList().size()>max){
                 max = user1.getNotificationsList().size();
             }
         }
         return max;
    }
}
