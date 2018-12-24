package com.github.convertdoc;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;
import jdk.nashorn.api.scripting.URLReader;
import org.junit.Test;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class ConvertDocApplicationTests {


    @Test
    public void contextLoads() throws IOException {
        JsonFactory jsonFactory = new JsonFactory();
        URL url = ResourceUtils.getURL("classpath:demo.json");
        ObjectMapper objectMapper = new ObjectMapper(jsonFactory);
        ObjectReader reader = objectMapper.reader();
        JsonNode root = reader.readTree(new URLReader(url));
        SwaggerParser parser = new SwaggerParser();
        Swagger read = parser.read(root);
        System.out.println(read);

    }

}

