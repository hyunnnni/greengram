package com.green.greengram.user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginVo {
    private int result; //로그인 성공(1), 아이디 없음(2), 비밀번호 다름(3)
    private int iuser; //로그인 성공 시 iuser, nm, pic가 넘어올 수 있도록
    private String nm;
    private String pic;


}
