package com.mycompany.app;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public App() {
    }

    public List<String> readFile() throws Exception {
        List<String> rows = Files.readAllLines(Paths.get("input"));
        return rows;
    }

}
