package wxx.boker.chapter011;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@ComponentScan(basePackages={"wxx"})
@MapperScan("wxx.boker.chapter011.infrastructure")
public class Chapter011Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter011Application.class, args);
/* 关闭 banner 展示
        SpringApplicationBuilder sb = new SpringApplicationBuilder((Chapter011Application.class));
        sb.bannerMode(Banner.Mode.OFF).run(args);
*/
    }

}
