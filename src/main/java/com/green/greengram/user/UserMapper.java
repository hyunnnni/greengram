package com.green.greengram.user;

import com.green.greengram.user.model.UserInsDto;
import com.green.greengram.user.model.UserInsSignin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int insUser (UserInsDto dto);
    String selUserById(String uid);

    int selUserById(UserInsSignin sdto);

    List<UserInsSignin> selUserByIdList();
}
