import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static ArrayList<Erdo> erdoLista = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        String path = initProgram(args);
        readFile(path);
        System.out.println("Folytatas...");
        // DataService service = new DataService();
        // service.insertData(erdoLista);
        
        DataService.insertData(erdoLista);
    }
    private static String initProgram(String[] args) {
        if(args.length == 0) {
            System.err.println("Hiba! Nem adatal meg parametert!");
            System.out.println("Hasznalat:");
            System.out.println("\tjava App <fajlnev>");
            System.exit(1001);
        }
        
        File file = new File(args[0]);
        if(!file.exists()) {
            System.err.println("Hiba! A fajl nem talahato!");
            System.exit(1002);
        }
        return args[0];
    }    
    private static void readFile(String path) 
            throws FileNotFoundException {
        File file = new File(path);
        Scanner sc = new Scanner(file);
        String mezonevek = sc.nextLine();
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] lineArray = line.split(",");
            Erdo erdo = new Erdo();
            erdo.id = Integer.parseInt(lineArray[0]);
            erdo.nev = lineArray[1];
            erdo.tipus = lineArray[2];
            erdo.meret = Integer.parseInt(lineArray[3]);
            erdo.terulet = lineArray[4];
            erdo.orszag = lineArray[5];
            erdo.vedett = Boolean.parseBoolean(lineArray[6]);
            erdoLista.add(erdo);            
        }
    }
}
