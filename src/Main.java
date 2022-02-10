import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args)
    {
        Markov markovObj = new Markov();
        markovObj.citire();
        markovObj.validareReguli();
        markovObj.afisare();

        Scanner sc = new Scanner(System.in);

        do
        {

            System.out.println("Introduceti un cuvant: ");

            String cuvant = sc.nextLine();

            System.out.println("Noul cuvant este: " + markovObj.derivare(cuvant));
        }
        while (continuareProgram());


        sc.close();
    }

    private static boolean continuareProgram()
    {
        System.out.println("Introduceti alt cuvant? (Y/N) " );
        Scanner sc = new Scanner(System.in);
        String decizie = sc.nextLine();


        if (decizie.equalsIgnoreCase("y"))
        {
            return true;
        }
        else
        {
            System.out.println("Iteratie finalizata");
            return false;
        }
    }

}