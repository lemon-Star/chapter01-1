package wxx.boker.chapter011.domain.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {

    private Long userId;

    private String userName;

    private String gender;

    private String mobilePhone;

}
