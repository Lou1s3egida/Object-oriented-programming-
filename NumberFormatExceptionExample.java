import java.io.*;
import java.util.Scanner;

public class NumberFormatExceptionExample{
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.print("Enter input: ");
        String str = scanner.nextLine();
        try {
            
            int number = Integer.parseInt(str);
            System.out.println(number + " is a number");
        } catch (NumberFormatException e) {
            System.out.println("Input is not a number");
        }
    }
}
