package wxx.boker.chapter011.controller.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserInfoResDTO {
    @ApiModelProperty(value = "用户ID")
    private Long userInfoId;
    @ApiModelProperty("用户姓名")
    private String userName;
    @ApiModelProperty("性别")
    private String gender;
    @ApiModelProperty("手机号")
    private String mobilePhone;


}
