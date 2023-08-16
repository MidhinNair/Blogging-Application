package com.blog.blogappapiutlimate.PayloadDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
//for pagination
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostResponse {
    private List<PostDto> content;
    private  Integer pageNumber;
    private Integer pageSize;
    private long totalElement;
    private Integer totalPages;
    private  boolean lastPage;

}
