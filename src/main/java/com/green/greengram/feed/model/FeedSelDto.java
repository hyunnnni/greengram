package com.green.greengram.feed.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FeedSelDto {
    private int startIdx;
    private final int rowCount = 20;

    public FeedSelDto(int page){
        startIdx = ( page-1 )*rowCount;
    }
}
