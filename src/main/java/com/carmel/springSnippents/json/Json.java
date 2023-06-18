package com.carmel.springSnippents.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;

public class Json {
    private static ObjectMapper objectMapper = getDefaultObjectMapper();

    private static ObjectMapper getDefaultObjectMapper(){
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return defaultObjectMapper;
    }

    public static JsonNode parse(String src) throws JsonProcessingException {
       return objectMapper.readTree(src);
    }

    public static <A> A fromJson(JsonNode jsonNode, Class<A> clazz) throws JsonProcessingException {
        return objectMapper.treeToValue(jsonNode, clazz);
    }

    public static JsonNode toJson(Object a){
        return objectMapper.valueToTree(a);
    }

    public static String stringify(JsonNode node) throws JsonProcessingException {
        ObjectWriter writer = objectMapper.writer();
        return writer.writeValueAsString(node);
    }

    public static String prettyPrint(JsonNode node) throws JsonProcessingException {
        ObjectWriter writer = objectMapper.writer();
        writer = writer.with(SerializationFeature.INDENT_OUTPUT);
        return writer.writeValueAsString(node);
    }
}
