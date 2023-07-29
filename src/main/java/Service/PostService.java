package Service;

import Dtos.RequestDtos.PostDto;
import Exceptions.PostNotFound;
import Exceptions.UserNotFound;
import Models.Notifications;
import Models.Post;
import Models.User;
import Repository.PostRepository;
import Repository.UserRepository;
import Transformers.PostTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;
    public String addPost(PostDto postDto) throws UserNotFound {

        Integer userId = postDto.getUserId();

        Optional<User> userOptional = userRepository.findById(userId);

        if(userOptional.isEmpty()){
            throw new UserNotFound("User is not present with given id");
        }

        User user = userOptional.get();

        Post post = PostTransformer.convertDtoToEntity(postDto);
        post.setUser(user);
        List<String> List = post.getContentList();
        List.add(postDto.getContentDetail());
        post.setContentList(List);

        user.getPostList().add(post);

        userRepository.save(user);
        postRepository.save(post);

        return "Post is added to database";
    }

    public Notifications addLike(Integer postId) throws PostNotFound{
       Optional<Post> post = postRepository.findById(postId);
       if(post.isEmpty()){
           throw new PostNotFound("Post is not present");
       }
       Post postNow = post.get();

       int likes = postNow.getLikes();
       likes = likes+1;
       postNow.setLikes(likes);


       Notifications notifications = new Notifications();
       notifications.setPost(postNow);
       notifications.setNotificationTime(postNow.getContentTime());
       notifications.setMsg("Liked your post");
        postNow.getNotifications().add(notifications);
        postRepository.save(postNow);

       return notifications;
    }
}
