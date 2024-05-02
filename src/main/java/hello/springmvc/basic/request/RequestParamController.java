package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}", username, age);

        response.getWriter().write("ok");
    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge) {
        log.info("username={}, age={}", memberName, memberAge);

        return "ok"; //원래라면 ok라는 파일을 찾지만 @ResponseBody을 하거나 맨위의 컨트롤러를 rest컨트롤로 바꿔도 됨
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age) {
        log.info("username={}, age={}", username, age);

        return "ok"; //변수명을 같게 하면 ("username") ("age") 생략가능
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age) {
        log.info("username={}, age={}", username, age);

        return "ok"; //더 생략가능
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) Integer age) {
        log.info("username={}, age={}", username, age);

        return "ok";
        //required true 기본값 필수 값
        //required false 없어도 됨
        //빈문자 null 주의
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(defaultValue = "host") String username,
            @RequestParam(required = false, defaultValue = "23") Integer age) {
        log.info("username={}, age={}", username, age);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(
            @RequestParam Map<String, Object> paramMap )
    {
        log.info("username={}, age={}, sa={}", paramMap.get("username"), paramMap.get("age"), paramMap.get("sa"));

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData){

        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }



    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2( HelloData helloData){

        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }
    /*
    @RequestParam 생략 가능
    @ModelAttribute 생략 가능
    String, int, Integer 인경우 자동으로  @RequestParam
    그 외 경우 @ModelAttribute(argument resolve 로 지정해둔 타입은 예외)
     */
}