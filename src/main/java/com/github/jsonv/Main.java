package com.github.jsonv;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = args[0];
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        String jsonString = new String(encoded, "UTF-8");
        if (jsonString.trim().charAt(0)== '[') {
            try {
                new Gson().fromJson(jsonString, ArrayList.class);
                System.out.println(true);
            } catch (Exception e) {
                System.out.println(false);
                System.out.println(e.getMessage());
            }
        } else {
            try {
                new Gson().fromJson(jsonString, HashMap.class);
                System.out.println(true);
            } catch (Exception e) {
                System.out.println(false);
                System.out.println(e.getMessage());
            }
        }
    }
}
