package main.java;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Detector {
    public static void main(String[] args) {
    //reading the files!!
    File poem = new File ("./resources/poem.txt");
    File cheat = new File ("./resources/cheat.txt");
 

    try {
        Scanner scanner1 = new Scanner (poem);
        String thePoem = scanner1.useDelimiter("\\A").next();
        System.out.println(thePoem);
        scanner1.close();

        Scanner scanner2 = new Scanner (cheat);
        
        //now compare the 2 texts and tell the user if plagiarism is detected and which line number
        int i = 1;
        while (scanner2.hasNextLine()){
            String pattern = scanner2.nextLine();
            boolean plagiarized = RabinKarp.search(pattern, thePoem);
            if(plagiarized){
                System.out.println("Plagiarism on line: " + i + " / " + pattern);
            }
            i++;
        }
        scanner2.close();
    } catch (FileNotFoundException e){
            System.out.println(e);
        }
    if (true){
        System.out.println("Cheater detected!!!!");
    }
   else{
        System.out.println("you're in the clear... for now...");
    }
    
    } 
}
