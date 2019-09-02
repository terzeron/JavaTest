package com.terzeron.java;

import com.fasterxml.jackson.core.*;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JacksonStreamingAPITest {
    @Test
    public void test1() throws Exception {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        JsonFactory jFactory = new JsonFactory();
        JsonGenerator jGenerator = jFactory.createGenerator(stream, JsonEncoding.UTF8);
        jGenerator.writeStartObject();
        jGenerator.writeStringField("name", "Tom");
        jGenerator.writeNumberField("age", 25);
        jGenerator.writeFieldName("address");
        jGenerator.writeStartArray();
        jGenerator.writeString("Poland");
        jGenerator.writeString("5th avenue");
        jGenerator.writeEndArray();
        jGenerator.writeEndObject();
        jGenerator.close();

        String json = null;
        json = new String(stream.toByteArray(), "UTF-8");
        assertEquals(json, "{\"name\":\"Tom\",\"age\":25,\"address\":[\"Poland\",\"5th avenue\"]}");
    }

    @Test
    public void test2() throws Exception {
        String json = "{\"name\":\"Tom\",\"age\":25,\"address\":[\"Poland\",\"5th avenue\"]}";
        JsonFactory jFactory = new JsonFactory();
        JsonParser jParser = jFactory.createParser(json);

        String parsedName = null;
        Integer parsedAge = null;
        List<String> addresses = new LinkedList<>();

        while (jParser.nextToken() != JsonToken.END_OBJECT) {
            String fieldName = jParser.getCurrentName();
            if ("name".equals(fieldName)) {
                jParser.nextToken();
                parsedName = jParser.getText();
            }
            if ("age".equals(fieldName)) {
                jParser.nextToken();
                parsedAge = jParser.getIntValue();
            }
            if ("address".equals(fieldName)) {
                jParser.nextToken();
                while (jParser.nextToken() != JsonToken.END_ARRAY) {
                    addresses.add(jParser.getText());
                }
            }
        }
        jParser.close();
        assertEquals(parsedName, "Tom");
        assertEquals(parsedAge, (Integer) 25);
        assertEquals(addresses, Arrays.asList("Poland", "5th avenue"));
    }
}
