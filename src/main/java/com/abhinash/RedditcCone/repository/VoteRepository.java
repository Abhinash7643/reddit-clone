package com.abhinash.RedditcCone.repository;

import com.abhinash.RedditcCone.model.Post;
import com.abhinash.RedditcCone.model.User;
import com.abhinash.RedditcCone.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User currentUser);
}
