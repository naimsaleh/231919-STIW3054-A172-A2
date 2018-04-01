/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.Scanner;

/**
 *
 * @author Naim Saleh
 */
public class countword {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        Scanner scannerFile = null;
        File file = new File("C:\\Users\\Naim Saleh\\231919-STIW3054-A172-A1.wiki\\Result2.md");
       
        
        Writer w = null;
        File files = new File ("C:\\Users\\Naim Saleh\\231919-STIW3054-A172-A2.wiki\\Result.md");
        w = new BufferedWriter(new FileWriter(files));
        
        
        FileInputStream fileStream = new FileInputStream(file);
        InputStreamReader input = new InputStreamReader(fileStream);
        BufferedReader reader = new BufferedReader(input);
         
        String line;
         
        // Initializing counters
        int countWord = 0;
        int sentenceCount = 0;
        int characterCount = 0;
        int paragraphCount = 1;
        int whitespaceCount = 0;
        int lineC = 0;
         
        // Reading line by line from the 
        // file until a null is returned
        while((line = reader.readLine()) != null)
        {
            lineC++;
            if(line.equals(""))
            {
                paragraphCount++;
            }
            if(!(line.equals("")))
            {
                 
                characterCount += line.length();
                 
                // \\s+ is the space delimiter in java
                String[] wordList = line.split("\\s+");
                 
                countWord += wordList.length;
                whitespaceCount += countWord -1;
                 
                // [!?.:]+ is the sentence delimiter in java
                String[] sentenceList = line.split("[!?.:]+");
                 
                sentenceCount += sentenceList.length;
            }
        }
         
        System.out.println("Total word count = " + countWord);
        w.write("\n * Total word count = " + countWord);
        System.out.println("Total number of sentences = " + sentenceCount);
        w.write("\n * Total number of sentences = " + sentenceCount);
        System.out.println("Total number of characters = " + characterCount);
        w.write("\n * Total number of characters = " + characterCount);
        System.out.println("Total number of line = " + lineC);
        w.write("\n * Total number of line = " + lineC);
        System.out.println("Total number of whitespaces = " + whitespaceCount);
        w.write("\n * Total number of whitespaces = " + whitespaceCount);
        
        try {
            if(w != null){
                w.close();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}
