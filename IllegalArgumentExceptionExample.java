package javaapplication1;
    
import java.util.*; 
  
public class IllegalArgumentExceptionExample  { 
     public static void main(String[] args) { 
         Scanner scan= new Scanner(System.in); 
         while (true){ 
  
         System.out.print("Enter a positive number: "); 
         int Input = scan.nextInt(); 
        scan.nextLine();
         try { 
             if (Input < 0) { 
                 throw new IllegalArgumentException("Input must be a positive number.\n"); 
             } 
             System.out.println("You entered: " + Input + "\n"); 
         } 
         catch (IllegalArgumentException e) { 
             System.err.println("IllegalArgumentException: " + e.getMessage() + "\n"); 
           } 
        } 
     } 
 }
