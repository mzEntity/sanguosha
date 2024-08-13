package org.example.tools;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperator {
    public static List<String> readFile(String filePath){
        List<String> content = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }

    public static void saveFileLines(String filePath, List<String> content){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            for (String str : content) {
                writer.write(str);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printStringList(List<String> arr){
        for(String s: arr){
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        List<String> files = FileOperator.readFile("./src/main/resources/table.txt");
        FileOperator.printStringList(files);
    }
}
