
import java.io.*;

public class ClassNotFoundException{
    public static void main(String[] args) {
        try {
            
            Class.forName("NonExistentClass");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: " + e.getMessage());
        }
    }
}
