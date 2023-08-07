package com.example.social.media.platform.Transformers;

import com.example.social.media.platform.Dtos.RequestDtos.PostDto;
import com.example.social.media.platform.Models.Post;

public class PostTransformer {

    public static Post convertDtoToEntity(PostDto postDto){
        Post post = Post.builder().contentTime(postDto.getPostTime()).build();

        return post;
    }
}
