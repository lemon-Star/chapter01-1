package wxx.boker.chapter011.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wxx.boker.chapter011.dao.UserDao;
import wxx.boker.chapter011.domain.entity.UserInfo;
import wxx.boker.chapter011.util.RedisUtils;

@Service
@Slf4j
public class UserService {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private UserDao userDao;

//    @Autowired
//    private UserInfoMapperMybatis userInfoMapperMybatis;

    public UserInfo getUserById(String userId) {
        log.info("this is getUserById");
        UserInfo userInfo = (UserInfo) redisUtils.get(userId);
        log.info(userInfo.getGender());
        log.info(userInfo.getMobilePhone());
        log.info(userInfo.getUserName());
        log.info(userInfo.getUserId()+"");
        return userInfo;

    }

    public String uptUserInfoById(String userId){
        log.info("update userInfo");
        UserInfo userInfo = (UserInfo) redisUtils.get(userId);
        userInfo.setMobilePhone("1111111");
        userInfo.setGender("爷们儿");
        userInfo.setUserName("更新了名字儿");
        redisUtils.set(userId,userInfo);
        return "true";
    }


    public String setUserById(String userId) {
        log.info("this is getUserById");
        UserInfo userInfo = new UserInfo();
        userInfo.setGender("男");
        userInfo.setMobilePhone("18510559775");
        userInfo.setUserName("孙悟空");
        userInfo.setUserId(Long.valueOf(userId));
        redisUtils.set(userId,userInfo);
        return "user";

    }

    public void deleteUserById(String userId){
        log.info("this is delteUserId");
        log.info("this is delteUserId");
    }

    public String userInfoBySql(String userSeq){
        userDao.uptUserInfo("1");
//        UserInfoPO userInfoPO = new UserInfoPO();
//        userInfoPO.setIdno("142727199108080017");
//        userInfoPO.setLoginpassword("88888888");
//        userInfoPO.setMobilephone("16603406060");
//        userInfoMapperMybatis.insert(userInfoPO);
//        userInfoMapperRepo.insertIntoUserInfo(userInfoPO);
        return "true";
    }

    public String qryuserInfoBySql(String userseq){
//        UserInfoPO userInfoPO = userInfoMapperMybatis.selectById(userseq);
//        log.info(userInfoPO.toString());
//        return userInfoPO.getMobilephone();
        return "";
    }

}
