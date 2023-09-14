package ru.netology;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Request {
    String[] parts;
    List<String> validPaths;
    BufferedOutputStream out;
    String path;
    public Request (String[] parts, List<String> validPaths, BufferedOutputStream out) {
        this.parts = parts;
        this.validPaths = validPaths;
        this.out = out;
    }
    public Path getQueryParam() throws IOException {
        final var path = parts[1];
//        if (!validPaths.contains(path)) {
//            out.write((
//                    "HTTP/1.1 404 Not Found\r\n" +
//                            "Content-Length: 0\r\n" +
//                            "Connection: close\r\n" +
//                            "\r\n"
//            ).getBytes());
//            out.flush();
//            throw new FileNotFoundException("File not found: " + path); // генерация исключения
//        }

        final var filePath = Path.of(".", "public", path);
        return filePath;
    }
    public String getPath() {
        return path;
    }

    }
