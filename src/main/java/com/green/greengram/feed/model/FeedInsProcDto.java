package com.green.greengram.feed.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedInsProcDto {

    private int ifeed; //아웃풋 때 필요하다 insert 문 - keyProperty
    //레코드 저장 시 자동으로 주어지니깐 auto
    private int iuser; // 인풋 때 필요
    private String contents;
    private String location;
    public FeedInsProcDto(FeedInsDto dto){ //생성자를 사용해 값을 바꾼 이유는 ifeed때문
        //ifeed값은
        //그냥 따로 추가하면 되는데 한 이유는 스웨거에 ifeed가 뜨면서 거기에 이건 쓸데없는 값이니 어쩌구를 덧붙여야 하니 지저분해진다
        //더 깔끔하고 명확하게 하기 위해 박스갈이를 함

        this.iuser = dto.getIuser();
        this.contents = dto.getContents();
        this.location = dto.getLocation();
    }
}
