package com.abhinash.RedditcCone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    private Long postId;
    private String subredditName;
    private String postName;
    private String url;
    private String description;
}
