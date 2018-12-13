package com.springboot2.important.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.springboot2.important.entity.People;

import java.io.IOException;

public class JsonCustomSerialize extends JsonSerializer<People>{

    @Override
    public void serialize(People people, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeStartObject();

        jsonGenerator.writeStringField("p-name",people.getName());
        jsonGenerator.writeStringField("p-address",people.getAddress());

        jsonGenerator.writeEndObject();
    }
}
