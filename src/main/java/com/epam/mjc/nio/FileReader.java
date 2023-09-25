package com.epam.mjc.nio;

import java.io.File;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        try (java.io.FileReader fileReader = new java.io.FileReader(file);) {
            StringBuilder fileContent = new StringBuilder();
            int ch;
            while ((ch = fileReader.read()) != -1) {
                fileContent.append((char) ch);
            }
            String name = fileContent.substring(fileContent.indexOf(":") + 2, fileContent.indexOf("\n")).strip();
            fileContent.delete(0, fileContent.indexOf("\n") + 1);
            String age = fileContent.substring(fileContent.indexOf(":") + 2, fileContent.indexOf("\n")).strip();
            fileContent.delete(0, fileContent.indexOf("\n") + 1);
            String email = fileContent.substring(fileContent.indexOf(":") + 2, fileContent.indexOf("\n")).strip();
            fileContent.delete(0, fileContent.indexOf("\n") + 1);
            String phone = fileContent.substring(fileContent.indexOf(":") + 2, fileContent.indexOf("\n")).strip();
            fileContent.delete(0, fileContent.indexOf("\n") + 1);
            return new Profile(name, Integer.parseInt(age), email, Long.parseLong(phone));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
