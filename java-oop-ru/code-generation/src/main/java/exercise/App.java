package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static void save(Path path, Car car) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String carAsString = objectMapper.writeValueAsString(car);
        InputStream input = new ByteArrayInputStream(carAsString.getBytes());

        Files.copy(input, path, StandardCopyOption.REPLACE_EXISTING);
    }

    public static Car extract(Path path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json;
        OutputStream out = new ByteArrayOutputStream();

        Files.copy(path, out);
        json = out.toString();
        return objectMapper.readValue(json, Car.class);
    }
}
// END
