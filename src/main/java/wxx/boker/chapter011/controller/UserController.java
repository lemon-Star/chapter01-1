package wxx.boker.chapter011.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wxx.boker.chapter011.domain.entity.UserInfo;
import wxx.boker.chapter011.service.UserService;

import javax.validation.Valid;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "根据用户ID查询用户信息", notes = "用户信息服务")
    @GetMapping(value = "/getUserInfoById")
    @ApiImplicitParam(value = "用户ID",name = "userId", dataType = "String" , required = true,paramType = "query")
    public UserInfo getUserInfoById(@Valid String userId) {
        log.info("userId = " + userId);
        userService.qryuserInfoBySql(userId);
        return userService.getUserById(userId);
    }

    @ApiOperation(value = "设置用户信息", notes = "用户信息服务")
    @PostMapping(value = "/setUserInfoById")
    @ApiImplicitParam(value = "用户ID",name = "userId", dataType = "String" , required = true,paramType = "query")
    public String setUserInfoById(@Valid @RequestParam  String userId) {
        log.info("userId = " + userId);
        return userService.setUserById(userId);
    }

    @ApiModelProperty(value = "更新用户信息" ,notes = "用户信息管理")
    @PostMapping(value = "/updateUserInfoById")
    @ApiImplicitParam(value = "用户ID",name = "userId", required = true,dataType = "String",paramType = "query")
    public String updateUserInfo(@Valid @RequestParam String userId){
        return userService.userInfoBySql(userId);
//        return userService.uptUserInfoById(userId);
    }




}
