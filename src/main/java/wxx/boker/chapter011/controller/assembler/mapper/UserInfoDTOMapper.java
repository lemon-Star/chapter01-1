package wxx.boker.chapter011.controller.assembler.mapper;

import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import wxx.boker.chapter011.controller.response.UserInfoResDTO;
import wxx.boker.chapter011.domain.entity.UserInfo;

//@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Mapper
public interface UserInfoDTOMapper {

    UserInfoDTOMapper INSTANCE = Mappers.getMapper(UserInfoDTOMapper.class);

    /**
     * 用户类型转换
     * @param userInfo
     * @return
     */
    @Mapping(source = "userId",target = "userInfoId")
    UserInfoResDTO userInfo2UserInfoDTo(UserInfo userInfo);

}
