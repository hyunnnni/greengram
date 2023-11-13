package com.green.greengram.feed.model;

import lombok.Data;

import java.util.List;

@Data
public class FeedSelVo {
    private int ifeed;
    private String contents;
    private String location;
    private int iuser;
    private String writer;
    private String createAt;
    private List<String> pics;
}
