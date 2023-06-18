package com.carmel.json;

import com.carmel.json.pojo.JsonPojo;
import com.carmel.springSnippents.json.Json;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JacksonTest {
    String jsonSource = "{\"code\":\"int i = 0;\",\"author\":\"Rui\"}";

    JsonNode jsonNode;

    @Test
    void jacksonTest() throws JsonProcessingException {
        jsonNode = Json.parse(jsonSource);
        assertThat(jsonNode.get("code").asText()).isEqualTo("int i = 0;");
    }

    @Test
    void fromJson() throws JsonProcessingException {
        jsonNode = Json.parse(jsonSource);
        JsonPojo pojo =  Json.fromJson(jsonNode, JsonPojo.class);
        assertThat(pojo.getCode()).isEqualTo("int i = 0;");
    }

    @Test
    void toJson(){
        JsonPojo pojo = new JsonPojo();
        pojo.setCode("int i = 0;");
        JsonNode node = Json.toJson(pojo);
        assertThat(node.get("code").asText()).isEqualTo("int i = 0;");
    }

    @Test
    void stringify() throws JsonProcessingException {
        JsonNode jsonNode = Json.parse(jsonSource);
        String str = Json.stringify(jsonNode);
        assertThat(str).isEqualTo(jsonSource);
    }

    @Test
    void prettyPrint() throws JsonProcessingException {
        JsonNode jsonNode = Json.parse(jsonSource);
        String str = Json.prettyPrint(jsonNode);
        System.out.println(str);
    }
}
