package com.example.consumer_producer_kafka;

import java.io.FileOutputStream;
import java.io.IOException;

public class File{
    public void toFile(String users){
        try (FileOutputStream fileOutputStream = new FileOutputStream("users.txt", true)){
            users = users + "\n";
            byte[] buffer = users.getBytes();
            fileOutputStream.write(buffer, 0, buffer.length);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
