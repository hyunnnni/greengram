package com.green.greengram.user;

import com.green.greengram.ResVo;
import com.green.greengram.user.model.UserInsDto;
import com.green.greengram.user.model.UserInsSignin;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;

    @PostMapping
    public ResVo postuserIns (@RequestBody UserInsDto dto){
        int result = service.postUserIns(dto);
        return new ResVo(result);
    }

    //1: 아이디/비번 맞췄음,2: 아이디 없음 3:비밀번호 다름
    @PostMapping("/signin")
    public int login(@RequestBody UserInsSignin sdto){
        return service.postUserSign(sdto);
    }

    @GetMapping
    public List<UserInsSignin> getByIdpw(){
        return service.getByIdpw();
    }
}
