package com.green.greengram.feed;

import com.green.greengram.ResVo;
import com.green.greengram.feed.model.FeedFavProcDto;
import com.green.greengram.feed.model.FeedInsDto;
import com.green.greengram.feed.model.FeedSelDto;
import com.green.greengram.feed.model.FeedSelVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/feed")
public class FeedController {
    private final FeedService service;

    @PostMapping
    public ResVo postFeedIns(@RequestBody FeedInsDto dto){
        System.out.println(dto);
        return service.postFeedIns(dto);

    }

    @GetMapping
    public List<FeedSelVo> getFeed(int page, int iuser){
        return service.getFeed(page, iuser
                ,0);
    }

    @GetMapping("/{targetIuser}")
    public List<FeedSelVo> getFeed(@PathVariable int targetIuser, int page, int loginedIuser){
        return service.getFeed(page, loginedIuser
                , targetIuser);
    }



    @GetMapping("/{ifeed}/fav")
    public ResVo procFav (@PathVariable int ifeed, int iuser){
        System.out.println("ifeed : "+ifeed);
        System.out.println("iuser : "+iuser);
        FeedFavProcDto dto = FeedFavProcDto.builder()
                .ifeed(ifeed)
                .iuser(iuser)
                .build();
        return service.procFav(dto);
    }// 서비스는 요청받은 데이터를 가지고 원하는 로직을 구현하는 것이고
    //그 전에 controller에서 데이터를 정리 후 보내주는 것이 좋다
}
