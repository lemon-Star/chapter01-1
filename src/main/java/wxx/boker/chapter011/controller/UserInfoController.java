package wxx.boker.chapter011.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wxx.boker.chapter011.controller.response.UserInfoResDTO;
import wxx.boker.chapter011.domain.entity.UserInfo;
import wxx.boker.chapter011.infrastructure.UserInfoMapperRepo;

import javax.validation.Valid;

@RestController
@Slf4j
public class UserInfoController {
    @Autowired
    private UserInfoMapperRepo userInfoMapperRepo;


    @ApiOperation(value = "根据用户ID查询后台用户信息", notes = "用户信息服务")
    @GetMapping(value = "/user/userInfo")
    @ApiImplicitParam(value = "用户ID",name = "userId", dataType = "Long" , required = true,paramType = "query")
    public UserInfoResDTO getUserInfoById(@Valid String userId) {
        UserInfo userInfo = userInfoMapperRepo.qryUserInfoFromUserPO(userId);
        if(userInfo == null){
            return new UserInfoResDTO();
        }
        UserInfoResDTO userInfoResDTO = UserInfoResDTO.builder().userId(userInfo.getUserId())
                .userName(userInfo.getUserName()).gender(userInfo.getGender()).mobilePhone(userInfo.getMobilePhone()).build();
        return userInfoResDTO;
    }
}
