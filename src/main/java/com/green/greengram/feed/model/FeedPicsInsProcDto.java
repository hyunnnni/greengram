package com.green.greengram.feed.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
//@AllArgsConstructor
public class FeedPicsInsProcDto {
     private int ifeed;
     private List<String> pics;


     public FeedPicsInsProcDto(int ifeed, List<String> pics){
         this.pics = pics;
         this.ifeed = ifeed;
     } // 파라미터로 들어온 값의 타입이 멤버필드의 타입과 같고 순서를 동일하게 작성했다면
    // 생성자를 직접 적어 넣어줄 필요는 없고 @AllArgsConstructor를 사용하면 된다



}
