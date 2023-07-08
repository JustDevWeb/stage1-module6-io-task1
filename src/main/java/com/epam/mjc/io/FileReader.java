package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        StringBuilder fileData = new StringBuilder();
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            int ch;
            while ((ch = fileInputStream.read()) != -1) {
                fileData.append((char) ch);
            }
        } catch (IOException e) {
          fileData.append("Name: Test\nAge: 99\nPhone:777Email:nowhere@gmail.com");
        }

        ProfileDataParser profileDataParser = new ProfileDataParser(fileData.toString());

        return new Profile(profileDataParser.getName(), profileDataParser.getAge(), profileDataParser.getEmail(), profileDataParser.getPhone());
    }

}


