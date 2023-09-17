package com.fabrick.testfabrick.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class JsonFileReader {

    public static String readJsonFileAsString(String filePath) throws IOException {
        // Ottieni il flusso di input per il file JSON
        InputStream inputStream = JsonFileReader.class.getResourceAsStream(filePath);

        if (inputStream == null) {
            throw new IOException("File non trovato: " + filePath);
        }

        try (Scanner scanner = new Scanner(inputStream, "UTF-8")) {
            return scanner.useDelimiter("\\A").next();
        }
    }
}
