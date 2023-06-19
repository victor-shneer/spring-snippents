package com.carmel.json;

import com.carmel.json.pojo.Author;
import com.carmel.json.pojo.InterviewDay;
import com.carmel.json.pojo.JsonPojo;
import com.carmel.springSnippents.json.Json;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JacksonTest {
    private final String jsonSource = """
        {\s
          "code":"forget();",
          "author":"Rui"
        }""";

    private final String dayScenario1 = """
        {\s
        "date": "2023-06-19",
        "name": "Yotpo interview"
        }""";

    private final String authorBooks = """
        {
          "author": "Roi",
          "books": [
            {
              "title": "haim",
              "inPrint": true,
              "publishDate": "2019-12-25"
            },
            {
              "title": "eladim",
              "inPrint": true,
              "publishDate": "2019-11-25"
            }
          ]
        }
        """;

    JsonNode jsonNode;

    @Test
    void jacksonTest() throws JsonProcessingException {
        jsonNode = Json.parse(jsonSource);
        assertThat(jsonNode.get("code").asText()).isEqualTo("forget();");
    }

    @Test
    void fromJson() throws JsonProcessingException {
        jsonNode = Json.parse(jsonSource);
        JsonPojo pojo =  Json.fromJson(jsonNode, JsonPojo.class);
        assertThat(pojo.getCode()).isEqualTo("forget();");
    }

    @Test
    void fromJsonDate() throws JsonProcessingException {
        jsonNode = Json.parse(dayScenario1);
        InterviewDay interviewDay =  Json.fromJson(jsonNode, InterviewDay.class);
        assertThat(interviewDay.getDate().toString()).isEqualTo("2023-06-19");
    }

    @Test
    void fromJsonAuthorBooks() throws JsonProcessingException {
        jsonNode = Json.parse(authorBooks);
        Author interviewDay =  Json.fromJson(jsonNode, Author.class);
        assertThat(interviewDay.getBooks().stream().toString()).isNotNull();
    }


    @Test
    void toJson(){
        JsonPojo pojo = new JsonPojo();
        pojo.setCode("forget();");
        JsonNode node = Json.toJson(pojo);
        assertThat(node.get("code").asText()).isEqualTo("forget();");
    }

    @Test
    void stringify() throws JsonProcessingException {
        JsonNode jsonNode = Json.parse(jsonSource);
        String str = Json.stringify(jsonNode);
        assertThat(str).isEqualTo(jsonSource.replaceAll("[\\n\\s]", ""));
    }

    @Test
    void prettyPrint() throws JsonProcessingException {
        JsonNode jsonNode = Json.parse(jsonSource);
        String str = Json.prettyPrint(jsonNode);
        System.out.println(str);
    }
}
