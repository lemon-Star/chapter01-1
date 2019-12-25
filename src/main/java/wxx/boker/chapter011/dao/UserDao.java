package wxx.boker.chapter011.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void uptUserInfo(String userSeq){
        jdbcTemplate.update("update USER_INFO set USERNAME=?,MOBILEPHONE=?,IDNO=? where USERSEQ=?","1111","2222","3333",userSeq);
    }

}
