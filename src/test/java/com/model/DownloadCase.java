package com.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.StructureCase;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DownloadCase {
    public List<StructureCase> testData(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(
                new File(path),
                objectMapper.getTypeFactory().constructCollectionType(List.class, StructureCase.class)
        );
    }
}
