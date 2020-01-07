package wxx.boker.chapter011.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class BookJson {

    @ApiModelProperty(value = "作者名称")
    private String name;
    @ApiModelProperty(value = "随便写的")
    private String auth;
    @ApiModelProperty(value = "价格")
    private Long price;

    @ApiModelProperty(value = "时间")
    private Date date;
}
