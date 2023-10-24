
import java.io.*;

public class ArrayIndexOutOfBoundsException{
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        try {
            
            int value = arr[3];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }
}
