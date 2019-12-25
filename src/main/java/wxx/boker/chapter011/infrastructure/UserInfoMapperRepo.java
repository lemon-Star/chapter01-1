package wxx.boker.chapter011.infrastructure;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;
import wxx.boker.chapter011.domain.entity.UserInfo;
import wxx.boker.chapter011.infrastructure.repositories.po.UserInfoPO;

@Repository
public class UserInfoMapperRepo extends ServiceImpl<UserInfoMapperMybatis, UserInfoPO> {

    public UserInfo qryUserInfoFromUserPO(String userId){
        LambdaQueryWrapper<UserInfoPO> lam = new LambdaQueryWrapper();
        lam.eq(UserInfoPO::getUserseq,Long.valueOf(userId));
        UserInfoPO userInfoPO = this.getOne(lam);
        if(userInfoPO == null){
            return new UserInfo();
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userInfoPO.getUsername());
        userInfo.setMobilePhone(userInfoPO.getMobilephone());
        return  userInfo;
    }


}
