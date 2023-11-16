package com.green.greengram.feed;

import com.green.greengram.ResVo;
import com.green.greengram.feed.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface FeedMapper {
    int insFeed(FeedInsProcDto dto);

    int insFeedPic(FeedPicsInsProcDto fpdto);

    List<FeedSelVo> selFeed(FeedSelDto idx);

    List<FeedPicsVo> selFeedPics(List<Integer> list);

    int delFeedFav(FeedFavProcDto dto);

    int insFeedFav(FeedFavProcDto dto);


}