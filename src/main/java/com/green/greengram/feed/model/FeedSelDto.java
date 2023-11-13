package com.green.greengram.feed.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FeedSelDto {
    private int stattIdx;
    private final int rowCount = 20;

    public FeedSelDto(int page){
        stattIdx = ( page-1 )*rowCount;
    }
}
