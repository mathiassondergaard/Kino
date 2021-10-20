package com.example.kino.configuration;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class MyLocalTimeSerializer extends JsonSerializer<LocalTime> {

    DateTimeFormatter dftTime = DateTimeFormatter.ofPattern("HH:mm");

    @Override
    public void serialize(
            LocalTime time,
            JsonGenerator gen,
            SerializerProvider arg2) throws IOException, JsonProcessingException {
        gen.writeString(time.format(dftTime));
    }

}

