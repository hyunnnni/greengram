package com.green.greengram.feed;

import com.green.greengram.ResVo;
import com.green.greengram.feed.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper mapper;

    public ResVo postFeedIns(FeedInsDto dto) {//dto는 최초 프론트에서 넘어온 값을 가진 주소값

        FeedInsProcDto pDto = new FeedInsProcDto(dto);//pDto가 생성될 때 dto의 주소값을 보낸다
        //그럼 pDto안의 멤버필드 값도 dto안의 멤버필드값처럼 변해있다 값이 동일해졌다. 동등
        //현재 필요한 건 FeedInsDto안의 ifeed를 제외한 멤버필드 값이기 때문에
        System.out.println(dto);
        System.out.println(pDto);
        int result = mapper.insFeed(pDto); // 이 값만 필요하기 때문에 그 값만 있는 클래스를 만들어 값을 넣은 후 해당 클래스의 주소값을
        //사용하는 것
        System.out.println(pDto);

        FeedPicsInsProcDto p2Dto = new FeedPicsInsProcDto(pDto.getIfeed(), dto.getPics());
        int result2 = mapper.insFeedPic(p2Dto);
        return new ResVo(pDto.getIfeed());
    }
    public List<FeedSelVo> getFeed(int page, int iuser){
        final int ROW_COUNT = 20;
        FeedSelDto dto = FeedSelDto.builder()
                .iuser(iuser)
                .startIdx((page - 1) * ROW_COUNT)
                .rowCount(ROW_COUNT)
                .build();
        List<FeedSelVo> feedSelVoList = mapper.selFeed(dto);
        List<Integer> iFeedList = new ArrayList<>();
        Map<Integer, FeedSelVo> feedMap = new HashMap<>();

        for(FeedSelVo vo : feedSelVoList){
            System.out.println(vo);
            iFeedList.add(vo.getIfeed());
            feedMap.put(vo.getIfeed(), vo);
        }
        List<FeedPicsVo> feedPicsVoList = mapper.selFeedPics(iFeedList);
        System.out.println("-----------------------------------");
        for(FeedPicsVo vo : feedPicsVoList) {
            System.out.println(vo);
            FeedSelVo feedVo = feedMap.get(vo.getIfeed());
            feedVo.getPics().add(vo.getPic());
        }
        return feedSelVoList;
    }

    /*public List<FeedSelVo> getFeed(int page) {
        FeedSelDto dto = new FeedSelDto(page);
        return mapper.selFeed(dto);
    }*/
    /* public List<FeedSelVo> getFeed(int page){//build 애노테이션을 이용한 생성자
    //각 멤버필드에 생성자처럼 값을 넣어줄 수 있고 그 주소값을 가질 수 있는데
    //멤버필드에 원하는 값을 넣기 편하고 어디에 어떤 값이 들어가는지 알기 쉽다
    //lombok을 사용하면 build패턴 만들기가 쉽다
        final int ROW_COUNT = 20;
        FeedSelDto dto = FeedSelDto.builder()
                .startIdx((page - 1) * ROW_COUNT)
                .rowCount(ROW_COUNT)
                .build();//원하는 값을 다 넣고 마지막에만 build라는 메소드만 호출해주면 된다
        List<FeedSelVo> feedSelVoList = mapper.selFeed(dto);


        List<Integer> iFeedList = new ArrayList<>();

        Map<Integer, FeedSelVo> feedMap = new HashMap<>();
         //첫번째가 키값, 두번째는 value

        for(FeedSelVo vo : feedSelVoList){//현재 pics의 값은 null인채로 각 주소값이 들어오고 있다
            System.out.println(vo);
            iFeedList.add(vo.getIfeed());
            feedMap.put(vo.getIfeed(), vo);
            //값을 map에 넣는다 (ifeed가 8인것을 담고 있는 FeedSelVo의 주소값)이 들어가 짝을 이루게 해준다
        }
        List<FeedPicsVo> feedPicsVoList = mapper.selFeedPics(iFeedList);
         System.out.println("-----------------------------------");

        for(FeedPicsVo vo : feedPicsVoList){
            System.out.println(vo);
            FeedSelVo feedVo = feedMap.get(vo.getIfeed());//ifeed를 원하는 값을 get하면 거기에 맞는 주소값을 호출할 수 있고
            //그 주소값을 feedVo에 넣었다
            feedVo.getPics().add(vo.getPic());
            //그 주소값의 값은 비어있는 주소값을 가진 List<String> pic에 add(추가하겠다) FeedPicsVo에 있는 pic값을 넣겠다
        }

        return feedSelVoList;
    }
*/
    /*현민씨가 한 거 원래 FeedSelVo에 리스트 객체 생성 안해도 된다
    public List<FeedSelVo> getFeed(Integer page) {
        final int count = 30;
        List<FeedSelVo> feedSelVoList = mapper.selFeed(
                FeedSelDto.builder()
                        .startIdx((page - 1) * count)
                        .rowCount(count)
                        .build());

        List<Integer> ifeedList = new ArrayList<>();

        Map<Integer, FeedSelVo> feedMap = new HashMap<>();

        for (FeedSelVo feedSelVo : feedSelVoList) {
            ifeedList.add(feedSelVo.getIfeed());
            feedMap.put(feedSelVo.getIfeed(), feedSelVo);
        }

        List<FeedPicsVo> feedPicsVoList = mapper.selFeedPics(ifeedList);

        for (FeedPicsVo feedPicsVo : feedPicsVoList) {
            FeedSelVo feedSelVo = feedMap.get(feedPicsVo.getIfeed());
            if (feedSelVo.getPics() == null) {
                feedSelVo.setPics(new ArrayList<>());
            }
            feedSelVo.getPics().add(feedPicsVo.getPic());
        }

        return feedSelVoList;
    }*/

    //좋아요 :1 , 취소 : 2
    //값이 있는지 없는지 확인
    //delete를 먼저 보내고 실행 결과 값에 따라 유무를 체크한다
    //그러면 select을 쓸 필요가 없다
    //그 결과에 따라 insert또는 delete
    //
    public ResVo procFav(FeedFavProcDto dto){
        int result = mapper.delFeedFav(dto);

        if(result == 0 ){
            return new ResVo(mapper.insFeedFav(dto));

        }
        return new ResVo(2);
    }
}

