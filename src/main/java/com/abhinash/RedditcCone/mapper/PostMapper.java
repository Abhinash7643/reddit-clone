package com.abhinash.RedditcCone.mapper;

import com.abhinash.RedditcCone.dto.PostDto;
import com.abhinash.RedditcCone.dto.PostResponse;
import com.abhinash.RedditcCone.model.Post;
import com.abhinash.RedditcCone.model.Subreddit;
import com.abhinash.RedditcCone.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class PostMapper {

    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "description", source = "postRequest.description")
//    @Mapping(target = "voteCount", constant = "0")
    public abstract Post map(PostDto postRequest, Subreddit subreddit, User user);

    @Mapping(target = "id", source = "postId")
    @Mapping(target = "subredditName", source = "subreddit.name")
    @Mapping(target = "userName", source = "user.username")
//    @Mapping(target = "commentCount", expression = "java(commentCount(post))")
//    @Mapping(target = "duration", expression = "java(getDuration(post))")
//    @Mapping(target = "upVote", expression = "java(isPostUpVoted(post))")
//    @Mapping(target = "downVote", expression = "java(isPostDownVoted(post))")
    public abstract PostResponse mapToDto(Post post);
}
