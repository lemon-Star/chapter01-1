package wxx.boker.chapter011.controller.assembler;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserInfoDTOMapper {

    UserInfoDTOMapper INSTANCE = Mappers.getMapper(UserInfoDTOMapper.class);

    

}
