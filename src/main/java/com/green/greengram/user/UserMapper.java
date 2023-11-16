package com.green.greengram.user;

import com.green.greengram.user.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int insUser (UserInsDto dto);
    UserSigninProcVo selUserById(String uid);

    UserLoginVo selUserById2(UserInsSignin sdto);// mybatis는 id이름이 무조건 유일해야한다 리턴과 파라미터로 구분이 되지 않는다


    List<UserInsSignin> selUserByIdList();

    UserSelProVo selUserProfileInfo(int iuser);
}