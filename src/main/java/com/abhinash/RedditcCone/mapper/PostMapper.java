package com.abhinash.RedditcCone.mapper;

import com.abhinash.RedditcCone.dto.PostDto;
import com.abhinash.RedditcCone.dto.PostResponse;
import com.abhinash.RedditcCone.model.Post;
import com.abhinash.RedditcCone.model.Subreddit;
import com.abhinash.RedditcCone.model.User;
import com.abhinash.RedditcCone.repository.CommentRepository;
import com.abhinash.RedditcCone.repository.VoteRepository;
import com.abhinash.RedditcCone.service.AuthService;
import com.github.marlonlom.utilities.timeago.TimeAgo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")//annotation to specify that this interface is a Mapstruct Mapper and Spring
// should identify it as a component and should be able to inject it into other components like SubredditService.
public abstract class PostMapper {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private AuthService authService;

    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "description", source = "postRequest.description")
    @Mapping(target = "voteCount", constant = "0")
    public abstract Post map(PostDto postRequest, Subreddit subreddit, User user);


    @Mappings({
            @Mapping(source = "postId", target = "id"),
            @Mapping(source = "subreddit.name", target = "subredditName"),
            @Mapping(target = "userName", source = "user.username"),
            @Mapping(target = "commentCount", expression = "java(commentCount(post))"),
            @Mapping(target = "duration", expression = "java(getDuration(post))")
    })
    public abstract PostResponse mapToDto(Post post);

    Integer commentCount(Post post) {
        return commentRepository.findByPost(post).size();
    }

    String getDuration(Post post) {
        return TimeAgo.using(post.getCreatedDate().toEpochMilli());
    }
}
