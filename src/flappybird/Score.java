/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybird;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ndriqim Haxhaj
 */
public class Score {
    public static int score=0;
    File file;
    PrintWriter pw;
    FileReader fileReader;
    BufferedReader bufReader = null;
    String str="";
    
    public Score(){
        file = new File("scores.txt");
        
        try {
            fileReader = new FileReader(file);
            bufReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException ex) {
            System.out.println("File Reader error");
            System.exit(1);
        }
        
        readScore();
    }
    
    public void writeScore(int sc){
        score=sc;
        try {
            pw = new PrintWriter(file);
            pw.print(score);
            pw.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Print Writer error");
            System.exit(1);
        }
        
    }
    
    public void readScore(){
         try {
            str = bufReader.readLine();
            bufReader.close();
            System.out.println(str);
        } catch (IOException ex) {
             System.out.println("Couldn't read from file");
             System.exit(1);
        }
          this.score = Integer.parseInt(str);
    }
}
