package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    //{"/hello-basic", "/hello-go"} or 둘 중에 하나 가능
    @RequestMapping({"/hello-basic", "/hello-go"})
    public String helloBasic() {
        log.info("basic");
        return "ok";

    }
}
