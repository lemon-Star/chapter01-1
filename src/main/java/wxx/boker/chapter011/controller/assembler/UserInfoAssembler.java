package wxx.boker.chapter011.controller.assembler;

import org.springframework.stereotype.Component;
import wxx.boker.chapter011.controller.assembler.mapper.UserInfoDTOMapper;
import wxx.boker.chapter011.controller.response.UserInfoResDTO;
import wxx.boker.chapter011.domain.entity.UserInfo;

@Component
public class UserInfoAssembler implements  UserInfoDTOMapper{


    /**
     * 类型转换
     * @param userInfo
     * @return
     */
    public UserInfoResDTO userInfo2UserInfoDTo(UserInfo userInfo){
        return UserInfoDTOMapper.INSTANCE.userInfo2UserInfoDTo(userInfo);
    }
}
