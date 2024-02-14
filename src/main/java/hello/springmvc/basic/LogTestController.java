package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//RestController => return에서 문자를 반환할때 그냥 반환해줌
//Controller 일땐 뷰 이름으로 반환됨
@RestController
public class LogTestController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "spring";

        System.out.println("name = " + name);

        //로그의 레벨 상태

        //치환
        log.trace("trace log = {}, {}", name, name);
        //개발서버에서 보는 로그
        log.debug("debug log = {}", name);
        //중요한 정보 로그
        log.info(" info log = {}  ",name);
        //경고 로그
        log.warn("warn log = {}", name );
        //에러 로그
        log.error("error log = {}", name );

        //2024-02-14T01:06:02.147+09:00  INFO 31852 --- [nio-8081-exec-1] h.springmvc.basic.LogTestController      :  info log = spring
        //2024-02-14T01:06:02.151+09:00  WARN 31852 --- [nio-8081-exec-1] h.springmvc.basic.LogTestController      : warn log = spring
        //2024-02-14T01:06:02.151+09:00 ERROR 31852 --- [nio-8081-exec-1] h.springmvc.basic.LogTestController      : error log = spring
        return "ok";
    }
}
