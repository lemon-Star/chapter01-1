package wxx.boker.chapter011.controller.response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class UserInfoResDTO {
    @ApiModelProperty(value = "用户ID")
    private Long userId;
    @ApiModelProperty("用户姓名")
    private String userName;
    @ApiModelProperty("性别")
    private String gender;
    @ApiModelProperty("手机号")
    private String mobilePhone;
}
