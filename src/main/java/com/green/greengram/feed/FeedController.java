package com.green.greengram.feed;

import com.green.greengram.ResVo;
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
        service.postFeedIns(dto);
        return null;
    }

    @GetMapping
    public List<FeedSelVo> getFeed(int page){
        return service.getFeed(page);
    }
}
