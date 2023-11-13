package com.green.greengram.feed;

import com.green.greengram.ResVo;
import com.green.greengram.feed.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper mapper;
    public ResVo postFeedIns(FeedInsDto dto) {//dto는 최초 프론트에서 넘어온 값을 가진 주소값

        FeedInsProcDto pDto = new FeedInsProcDto(dto);//pDto가 생성될 때 dto의 주소값을 보낸다
        //그럼 pDto안의 멤버필드 값도 dto안의 멤버필드값처럼 변해있다 값이 동일해졌다. 동등
        System.out.println(dto);
        System.out.println(pDto);
        int result = mapper.insFeed(pDto);
        System.out.println(pDto);

        FeedPicsInsProcDto p2Dto = new FeedPicsInsProcDto(pDto.getIfeed(), dto.getPics());
        int result2 = mapper.insFeedPic(p2Dto);
        return new ResVo(pDto.getIfeed());
    }

    public List<FeedSelVo> getFeed(int page){
        FeedSelDto dto = new FeedSelDto(page);
        return mapper.selFeed(dto);
    }
}