package com.example.social.media.platform.Service;

import com.example.social.media.platform.Dtos.RequestDtos.PostDto;
import com.example.social.media.platform.Exceptions.PostNotFound;
import com.example.social.media.platform.Exceptions.UserNotFound;
import com.example.social.media.platform.Models.Post;
import com.example.social.media.platform.Models.User;
import com.example.social.media.platform.Repository.PostRepository;
import com.example.social.media.platform.Repository.UserRepository;
import com.example.social.media.platform.Transformers.PostTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JavaMailSender mailSender;
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

    public String addLike(Integer postId) throws PostNotFound{
       Optional<Post> post = postRepository.findById(postId);
       if(post.isEmpty()){
           throw new PostNotFound("Post is not present");
       }
       Post postNow = post.get();

       int likes = postNow.getLikes();
       likes = likes+1;
       postNow.setLikes(likes);

       User user = postNow.getUser();
       List<String> notification = user.getNotifications();

       SimpleMailMessage mailMessage = new SimpleMailMessage();

       String body = "Congratulation" + postNow.getUser().getUserName() + ", your post with id " + postId +
               " is like at " + postNow.getContentTime();
       mailMessage.setFrom("springtest17@gmail.com");
       mailMessage.setTo(postNow.getUser().getMail());
       mailMessage.setSubject("Your Post has been liked");
       mailMessage.setText(body);

       notification.add(body);
       userRepository.save(user);

       mailSender.send(mailMessage);

       return "Like is added to your post";
    }
}
