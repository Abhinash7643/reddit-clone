package com.abhinash.RedditcCone.repository;

import com.abhinash.RedditcCone.model.Post;
import com.abhinash.RedditcCone.model.Subreddit;
import com.abhinash.RedditcCone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllBySubreddit(Subreddit subreddit);

    List<Post> findByUser(User user);
}
