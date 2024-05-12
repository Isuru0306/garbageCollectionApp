package com.garbagecollections.utils.models.helpers;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import android.content.Context;

public class FileHelper {

    private  File file;
    public FileHelper(Context context, String fileName) {
        File directory = context.getExternalFilesDir(null);
        this.file = new File(directory, fileName);
    }

    public  boolean writeToFile(String data) {
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(data);
            writer.close();
            return true;
        } catch (IOException e) {
            System.out.println("=============");
            System.out.println(e.getMessage());
        }
        return false;
    }

    public String readFromFile() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("=============");
            System.out.println(e);
        }
        return stringBuilder.toString();
    }
}
