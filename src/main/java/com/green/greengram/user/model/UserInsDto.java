package com.green.greengram.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

/*@ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor*/
@Data //위의 애노테이션을 전부 대신 해준다
public class UserInsDto {

    private String uid;
    private String upw;
    private String nm;
    private String pic;

}
