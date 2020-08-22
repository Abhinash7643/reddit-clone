package com.abhinash.RedditcCone.service;


import com.abhinash.RedditcCone.dto.PostDto;
import com.abhinash.RedditcCone.exception.SubredditNotFoundException;
import com.abhinash.RedditcCone.mapper.PostMapper;
import com.abhinash.RedditcCone.model.Subreddit;
import com.abhinash.RedditcCone.repository.PostRepository;
import com.abhinash.RedditcCone.repository.SubredditRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class PostService {

    private final PostRepository postRepository;
    private final SubredditRepository subredditRepository;
    private final PostMapper postMapper;
    private final AuthService authService;

//    public void save(PostDto postRequest) {
//        Subreddit subreddit = subredditRepository.findByName(postRequest.getSubredditName())
//                .orElseThrow(() -> new SubredditNotFoundException(postRequest.getSubredditName()));
//        postRepository.save(postMapper.map(postRequest, subreddit, authService.getCurrentUser()));
//    }
}
