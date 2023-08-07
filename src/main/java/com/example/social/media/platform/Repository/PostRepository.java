package com.example.social.media.platform.Repository;

import com.example.social.media.platform.Models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
