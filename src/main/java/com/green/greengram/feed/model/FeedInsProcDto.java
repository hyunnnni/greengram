package com.green.greengram.feed.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedInsProcDto {
    public FeedInsProcDto(FeedInsDto dto){
        this.iuser = dto.getIuser();
        this.contents = dto.getContents();
        this.location = dto.getLocation();
    }
    private int ifeed;
    private int iuser;
    private String contents;
    private String location;
}
