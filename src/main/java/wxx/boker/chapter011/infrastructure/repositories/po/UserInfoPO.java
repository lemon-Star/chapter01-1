package wxx.boker.chapter011.infrastructure.repositories.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@KeySequence("USERINFO_SEQ")
@TableName("USER_INFO")
public class UserInfoPO implements Serializable {

    private static final long serialVersionUID = 8731116262793710292L;

    @TableId(value = "USERSEQ",type = IdType.INPUT)
    private Long userseq;

    @TableField("USERNAME")
    private String username;

    @TableField("MOBILEPHONE")
    private String mobilephone;

    @TableField("IDNO")
    private String idno;

    @TableField("LOGINDATE")
    private Date logindate;

    @TableField("LOGINPASSWORD")
    private String loginpassword;

}
