package wxx.boker.chapter011;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Test {


    @org.junit.jupiter.api.Test
    public static JdbcTemplate init(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        dataSource.setUsername("qryuser");
        dataSource.setPassword("qryuser");

        return new JdbcTemplate(dataSource);
    }

    public static void main(String[] args) throws SQLException {

        //执行sql语句（表名可大写可小写）
        String sql = "select * from USER_INFO";

        //查询数据并封装
        List<Map<String, Object>> maps=init().queryForList(sql);

        //输出数据
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }

}
