package com.tutorial.api.controller;

import com.tutorial.api.dto.MemberDto;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    // RequestMapping을 활용하여 GET 메서드에 대한 응답을 정의
    @RequestMapping(value="/hello", method= RequestMethod.GET)
    public String getHello() {

        return "Hello World";
    }

    // GetMapping을 활용하여 매개변수를 전달하는 GET 메서드에 대한 응답을 정의
    @GetMapping(value="/request/{variable}")
    public String getRequestParam(@PathVariable("variable") String variable){

        return variable;
    }

    // GET 호출 시 request 파라미터(?key1=value1&key2=...)를 참고하여 Map 컬렉션에 관련 정보들을 저장
    @GetMapping(value = "/request2")
    public String getRequestParams(@RequestParam Map<String, String> params) {
        JSONObject jsonObject = new JSONObject(params);

        return jsonObject.toString();
    }

    // GET 호출 시 request 파라미터(?name=value1&email=...)를 참고하여 DTO에 관련 정보들을 저장
    @GetMapping(value = "/request3")
    public MemberDto getRequestParamsToDto(MemberDto memberDto) {
        return memberDto;
    }
}
