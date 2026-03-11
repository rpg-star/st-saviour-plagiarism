package main.java;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Detector {
    public static void main(String[] args) {
        System.out.println("que lo que");
    File poem = new File ("./resources/poem.txt");
    File cheat = new File ("./resources/cheat.txt");
    //reading the files!!
    try {
        Scanner scanner1 = new Scanner (poem);
        String thePoem = scanner1.useDelimiter("\\A").next();
        System.out.println(thePoem);
        scanner1.close();

        Scanner scanner2 = new Scanner (cheat);
        String theCheat = scanner2.nextLine();
        while (scanner2.hasNextLine()){
            System.out.println(scanner2.nextLine());
        }
        scanner2.close();
    } catch (FileNotFoundException e){
            System.out.println(e);
        }

    if (true){
        //  while(true){
        //     int lineNum = 0;
        //     System.out.println("You cheated buddy!");
        //     System.out.println("detected on line " + lineNum);
        //   }
        
    }else{
        System.out.println("you're in the clear... for now...");
    }
    
    } 
}
