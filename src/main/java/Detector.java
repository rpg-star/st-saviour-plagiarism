package main.java;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Detector {
    public static void main(String[] args) {

    File poem = new File ("./resources/poem.txt");
    File cheat = new File ("./resources/cheat.txt");
 
        //reading the files!!!
    try {
        //save the first file as a string, this is the text file in rabin karp
        Scanner scanner1 = new Scanner (poem);
        String thePoem = scanner1.useDelimiter("\\A").next();
        System.out.println(thePoem);
        scanner1.close();
        
        //read the cheat file line by line
        Scanner scanner2 = new Scanner (cheat);
        
        //now compare the 2 texts and tell the user if plagiarism is detected and which line number
        int i = 1;
        while (scanner2.hasNextLine()){
            String pattern = scanner2.nextLine();
            boolean plagiarized = RabinKarp.search(pattern, thePoem);
            if(plagiarized){
                System.out.println("Plagiarism on line " + i + " / " + pattern);
            }
            i++;
        }
        scanner2.close();
    //if any errors occur, let the user know
    } catch (FileNotFoundException e){
            System.out.println(e);
        }
    } 
}
