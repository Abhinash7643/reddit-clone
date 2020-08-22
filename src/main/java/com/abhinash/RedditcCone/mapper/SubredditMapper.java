package com.abhinash.RedditcCone.mapper;

import com.abhinash.RedditcCone.dto.SubredditDto;
import com.abhinash.RedditcCone.model.Post;
import com.abhinash.RedditcCone.model.Subreddit;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubredditMapper {

    @Mapping(target = "numberOfPosts", expression = "java(mapPosts(subreddit.getPosts()))")
    SubredditDto mapSubredditToDto(Subreddit subreddit);

    default Integer mapPosts(List<Post> numberOfPosts) {
        return numberOfPosts.size();
    }

    @InheritInverseConfiguration
    @Mapping(target = "posts", ignore = true) //ignoring posts
    Subreddit mapDtoToSubreddit(SubredditDto subredditDto);

}
