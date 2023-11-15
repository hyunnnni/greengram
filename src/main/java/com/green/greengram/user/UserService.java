package com.green.greengram.user;

import com.green.greengram.ResVo;
import com.green.greengram.user.model.UserInsDto;
import com.green.greengram.user.model.UserInsSignin;
import com.green.greengram.user.model.UserLoginVo;
import com.green.greengram.user.model.UserSigninProcVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;
    static List<UserInsSignin> idlist;

    public int postUserIns(UserInsDto dto){
        return mapper.insUser(dto);
    }


    //1: 아이디/비번 맞췄음,2: 아이디 없음 3:비밀번호 다름
    public UserLoginVo postUserSign(UserInsSignin sdto){
        UserLoginVo ulv = new UserLoginVo();


        ulv.setResult(3);

        UserSigninProcVo savedUpw = mapper.selUserById(sdto.getUid());

        System.out.println("savedUpw : " + savedUpw);
        if(savedUpw.getUpw() == null){
            ulv.setResult(2);
        } else if(savedUpw.getUpw().equals(sdto.getUpw())){
            ulv.setNm(savedUpw.getNm());
            ulv.setIuser(savedUpw.getIuser());
            ulv.setPic(savedUpw.getPic());
            ulv.setResult(1);

        }


        return ulv;
    }

    public List<UserInsSignin> getByIdpw(){
        idlist =mapper.selUserByIdList();
        return mapper.selUserByIdList();
    }

   /* public int postUserSign(UserInsSignin sdto){
        idlist = mapper.selUserByIdList();
        getByIdpw();

        int result = 2;
        for(UserInsSignin a : idlist){
            if(a.getUid() .equals(sdto.getUid()) && a.getUpw() .equals(sdto.getUpw())){
                result = 1;
                return result;
            } else if(a.getUid() .equals(sdto.getUid())&&!(a.getUpw() .equals(sdto.getUpw()))){
                result = 3;
                return result;
            }
        }
        System.out.println("result :" + result );
        return result;
    }*/


}