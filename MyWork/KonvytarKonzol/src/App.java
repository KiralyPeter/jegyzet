import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    static ArrayList<Kolcsonzok> kolcsonVevokLista = new ArrayList<>();
    static ArrayList<Kolcsonzesek> kolcsonLista = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        
        // System.out.println("Args.length = " + args.length);
        // System.out.println("Arg0: " + args[0]);
        // System.out.println("Arg1: " + args[1]);

        DataService service = new DataService();
        
        if(args.length == 2){
            String pathKocsonzok = initKolcsonzok(args);
            // System.out.println("pathKocsonzok: " + pathKocsonzok);
            String pathKocsonzesek = initKolcsonzesek(args);
            // System.out.println("pathKocsonzesek: " + pathKocsonzesek);

            readFileKolcsonzok(pathKocsonzok);
            readFileKolcsonzesek(pathKocsonzesek);
            
            service.insertKolcsonzok(kolcsonVevokLista);
            service.insertKolcsonzesek(kolcsonLista);
        }else {
            System.err.println("Hiba! Nem meggelelo parameterek!");
            System.out.println("A program hasznalata:");
            System.out.println("\tjava App Kolcsonzok.csv Kolcsonzesek.csv");       
        }


        
        
    }


    private static String initKolcsonzok(String args[]){
       
        File fileKolcsonzok = new File(args[0]);
        if(!fileKolcsonzok.exists()) {
            System.err.println("Hiba! A Kolcsonzok.csv fajl nem talahato!");
            System.exit(1002);
        }    
        return args[0];
    }

    private static String initKolcsonzesek(String args[]){
        File fileKocsonzesek = new File(args[1]);
        if(!fileKocsonzesek.exists()) {
            System.err.println("Hiba! A Kolcsonzesek.csv fajl nem talahato!");
            System.exit(1003);
        } 
        return args[1];
    }

    private static void readFileKolcsonzok(String path) throws FileNotFoundException {
        int sorokSzama = 0;
        File file = new File(path);
        Scanner sc = new Scanner(file);
        String mezonevek = sc.nextLine();
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] lineArray = line.split(";");
            Kolcsonzok kolcsonVevo = new Kolcsonzok();
            kolcsonVevo.nev = lineArray[0];
            kolcsonVevo.szulido = lineArray[1];
            kolcsonVevokLista.add(kolcsonVevo);
            sorokSzama++;

        }
        System.out.println("Sikeresein importalt Kolcsonzok szama: " + sorokSzama);
        sc.close();
    }

    private static void readFileKolcsonzesek(String path) throws FileNotFoundException {
        int sorokSzama = 0;
        File file = new File(path);
        Scanner sc = new Scanner(file);
        String mezonevek = sc.nextLine();
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] lineArray = line.split(";");
            Kolcsonzesek kolcson = new Kolcsonzesek();
            kolcson.kolcsonzoId = Integer.parseInt(lineArray[0]);
            kolcson.iro = lineArray[1];
            kolcson.mufaj = lineArray[2];
            kolcson.cim = lineArray[3];
            kolcsonLista.add(kolcson);
            sorokSzama++;

        }
        System.out.println("Sikeresein importalt Kolcsonzesek szama: " + sorokSzama);
        sc.close();
    }
}
