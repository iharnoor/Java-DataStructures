package Lab;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CharCount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the file input name");
        String inputFile = input.next();
        System.out.println("-------------------------------------");
        getInput(inputFile);
    }

    public static void getInput(String fileName) {
        String input;
        Scanner fileInput = null;
        int lineCount=0,wordCount=0,letterCount=0;

        File inFile =new File(fileName);
        try {
            fileInput= new Scanner(inFile);
            while (fileInput.hasNext()){
                input = fileInput.nextLine();
                lineCount++;
                for (int i = 0; i < input.length(); i++) {
                    if(input.charAt(i)==' ')
                        wordCount++;
                    if(input.length()-1==i)
                        wordCount++;
                    if(charIsLetter(input.charAt(i)))
                        letterCount++;
                }
            }
            System.out.println("The line count is: "+lineCount);
            System.out.println("The word count is: "+wordCount);
            System.out.println("The letter count is: "+letterCount);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static boolean charIsLetter(char a){
        if(a>='a'&&a<='z')
            return true;
        if(a>='A'&&a<='Z')
            return true;
        else
            return false;
    }
}
