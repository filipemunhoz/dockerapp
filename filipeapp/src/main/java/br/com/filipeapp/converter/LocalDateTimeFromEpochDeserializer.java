package br.com.filipeapp.converter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import com.fasterxml.jackson.databind.util.StdConverter;

public class LocalDateTimeFromEpochDeserializer extends StdConverter<String, LocalDateTime>{


    @Override
    public LocalDateTime convert(String value) {
    
        return Instant.ofEpochMilli(Long.valueOf(value) * 1000)
        		.atZone(ZoneId.of("America/Sao_Paulo"))
        		.toLocalDateTime();
    }	
}
