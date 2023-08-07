package com.example.social.media.platform.Repository;

import com.example.social.media.platform.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
