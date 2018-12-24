package com.github.convertdoc.controller;

import io.swagger.models.Info;
import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;
import io.swagger.parser.util.SwaggerDeserializationResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Package:   com.github.convertdoc.controller 
 * @ClassName: DocUpDownController
 * @Statement: <p></p>
 * @JDK version used: 1.8
 * @Author: 胆木
 * @Create Date: 2018年12月24日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 3.0
 */
@RestController("doc")
public class DocUpDownController {
    private Map<String,Swagger> tempDoc = new HashMap<>();


    @PostMapping("swagger")
    public String downloadJson(String url){
        SwaggerParser swaggerParser = new SwaggerParser();
        SwaggerDeserializationResult result = swaggerParser.readWithInfo(url);
        Swagger swagger = result.getSwagger();
        String key = UUID.randomUUID().toString();
        tempDoc.put(key,swagger);
        return key;
    }

    @GetMapping("markdown")
    public String showMarkdown(String key){
        Swagger swagger = tempDoc.get(key);
        StringBuilder builder = new StringBuilder();
        Info info = swagger.getInfo();
        // TODO: 2018/12/24 增加解析markdown
        return "";
    }
}
