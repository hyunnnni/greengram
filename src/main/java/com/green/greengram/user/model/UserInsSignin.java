package com.green.greengram.user.model;

import lombok.Data;

/*@ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor*/
@Data //위의 애노테이션을 전부 대신 해준다
public class UserInsSignin {

    private String uid;
    private String upw;

}