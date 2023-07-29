package Transformers;

import Dtos.RequestDtos.PostDto;
import Models.Post;

public class PostTransformer {

    public static Post convertDtoToEntity(PostDto postDto){
        Post post = Post.builder().contentTime(postDto.getPostTime()).build();

        return post;
    }
}
