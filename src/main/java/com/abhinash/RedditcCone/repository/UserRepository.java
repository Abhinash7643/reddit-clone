package com.abhinash.RedditcCone.repository;

import com.abhinash.RedditcCone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
