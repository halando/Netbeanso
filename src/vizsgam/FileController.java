/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vizsgam;

/**
 *
 * @author ando
 */
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class FileController {

    public FileController(){

    }
    public ArrayList<Lending>ReadKolcsonzesek(String fileName){

        FileReader fr = null;

        try {
            
            fr = new FileReader("../" + fileName);

        } catch (FileNotFoundException ex) {
          System.out.println("Nincs meg a fájl");
        }

        Scanner scanner = new Scanner(fr);
        ArrayList<Lending> lendings = new ArrayList<>();
        scanner.nextLine();

        while(scanner.hasNext()){
            String row = scanner.nextLine();
            String[] rowSp = row.split(";");
            Lending lending = new Lending();
            lending.setLender_id(rowSp[0]);
            lending.setWriter(rowSp[1]);
            lending.setType(rowSp[2]);
            lending.setTitle(rowSp[3]);

            lendings.add(lending);

        }
       return lendings;
    }
    public ArrayList<Lender>ReadKolcsonzok(String fileName){

        FileReader fr = null;

        try {
            
            //fr = new FileReader("../" + fileName);
            fr = new FileReader(fileName);


        } catch (FileNotFoundException ex) {
          System.out.println("Nincs meg a fájl");
        }

        Scanner scanner = new Scanner(fr);
        ArrayList<Lender> lenders = new ArrayList<>();
        scanner.nextLine();

        while(scanner.hasNext()){
            String row = scanner.nextLine();
            String[] rowSp = row.split(";");
            Lender lender = new Lender();
            lender.setName (rowSp[0]);
            lender.setBorn(rowSp[1]);
            

            lenders.add(lender);

        }
        
       return lenders;
    }
}