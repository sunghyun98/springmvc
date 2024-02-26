package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    //{"/hello-basic", "/hello-go"} or 둘 중에 하나 가능

    //method 속성을 지정하지 않으면 메서드와 무관하게 호출된다.
    //GET이 아닌 다른 요청을 하게 된다면 오류발생
    @RequestMapping(value = "/hello-basic")
    public String helloBasic() {
        log.info("basic");
        return "ok";

    }

    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1(){
        log.info("mappingGetV1");
        return "ok";
    }

    /**
     * 편리한 축약 애노테이션(코드보기)
     * @GetMapping
     * @PostMapping
     * @PutMapping
     * @DeleteMapping
     * @PatchMapping
     */
    @GetMapping(value = "/mapping-get-v2")
    public String mappingGet2(){
        log.info("mappingGetV2");
        return "ok";
    }

    /**
     * PathVariable 사용
     * 변수명이 같으면 생략 가능
     * @PathVariable("userId") String userId => @PathVariable userId
     * 경로변수
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data){
        log.info("mappingPath userId ={}",data);
        //mappingPath userId =userA
        return "ok";
    }
}
