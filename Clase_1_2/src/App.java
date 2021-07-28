import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite el numero de elementos");
        int n = Integer.parseInt(sc.nextLine());
        String file_name = "Archivo";
        LLenarArchivo(sc, file_name, n);
    }

    public static void LLenarArchivo(Scanner input, String file_name, int n){
        try{
            File archivo = new File(file_name+".txt"); // Se crea el puente al archivo
            PrintStream writer = new PrintStream(archivo); // escribir en el archivo
            System.out.println("Se esta llenando el archivo");

            for(int i = 0;i<n;i++){
                String codigo = input.nextLine();
                String nombre = input.nextLine();
                writer.println(codigo);
                writer.println(nombre);
                writer.println(i);
            }
            writer.close();

        }catch(FileNotFoundException e){
            System.out.println("Ocurrio un error al momento de crear el archivo");
        }
    }
}
