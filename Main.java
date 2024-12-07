
import java.util.Scanner;
public class Main {

    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan angka: ");
        
        if (scanner.hasNextInt()) {
            int angka = scanner.nextInt();
            System.out.println("Anda memasukkan angka: " + angka);
        } else {
            System.out.println("Input bukan angka.");
        }
        
        scanner.close();
    }
    
}