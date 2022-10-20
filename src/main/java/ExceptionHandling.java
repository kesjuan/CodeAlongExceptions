import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) {
    //createNewFile();
        //createNewFileRethrow();
        numbersExceptionHandling();
        numbersExceptionHandlingResources();
    }
    public static void createNewFile(){
        File file = new File("resources/nonexistent.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Directory does not exist.");
            e.printStackTrace();

        }
    }
    public static void createNewFileRethrow() throws IOException{
        // ! now any method that calls this method will have to handle it or throw it again
        File file = new File("resources/nonexistent.txt");
       file.createNewFile();
    }
    public static void numbersExceptionHandling(){
        File file = new File("resources/numbers.txt");
        Scanner fileReader = null;
        try {
             fileReader = new Scanner(file);
            while (fileReader.hasNext()){
                double num = fileReader.nextDouble();
                System.out.println(num);
            }

        } catch (FileNotFoundException | InputMismatchException e){
            e.printStackTrace();
        } finally {
            fileReader.close();
        }
    }
    // try with resources will automatically close resources
    public static void numbersExceptionHandlingResources(){
        File file = new File("resources/numbers.txt");

        try(Scanner fileReader = new Scanner(file)) {
         // !^^ try with resources closes scanner so no need for finally block
            while (fileReader.hasNext()){
                double num = fileReader.nextDouble();
                System.out.println(num);
            }

        } catch (FileNotFoundException | InputMismatchException e){
            e.printStackTrace();
        }
    }

}
