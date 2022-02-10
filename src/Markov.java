import java.util.*;
import java.io.*;

public class Markov {

    private int numarReguli;
    private int nuumarSimboluri;
    private char[] alfabet = {'a', '#', 'x','y','z'};
    private List<String> left;
    private List<String> right;
    public String Sfarsit = ".";
    public String lambda = "`";

    public Markov()
    {
        right = new ArrayList<String>();
        left = new ArrayList<String>();

    }

    public void citire()//citim din fisier
    {
        numarReguli = 5;

        numarReguli = 7;

        left.add("ax");
        right.add("xa");
        left.add("a#a");
        right.add("``");
        left.add("a#");
        right.add("#y");
        left.add("y");
        right.add("a");
        left.add("x");
        right.add("z");
        left.add("z");
        right.add("a");
        left.add("#");
        right.add(".");


    }
    public void afisare()
    {
        System.out.println("Simboluri: ");
        for (int i = 0; i < nuumarSimboluri; i++)
        {
            System.out.print(" '" + alfabet[i] + "' ");
        }
        System.out.println();

        System.out.println("Reguli: " );
        for(int i = 0; i < numarReguli; i++)
        {
            System.out.println((i+1) + ". " + left.get(i) + " -> " +  right.get(i));
        }


    }

    public String derivare(String cuvant)
    {

        if (validareString(cuvant) != true)
        {
            System.out.println("Cuvantul nu este valid");
            return null;
        }



        int numarulPasului = 1;


        for (int i = 0; i < numarReguli; i++)
        {
            boolean verificRegula = false;// verifica daca o regula a fost aplicata, dupa ce a fost aplicata ne intoarcem la prima si verificam daca aceasta se poate aplica din nou
            while(cuvant.contains(left.get(i)) && !cuvant.contains(Sfarsit)) //atata timp cat regula curenta se poate aplica in cuvant, iteratia continua
            {
                if (right.get(i).equals(lambda))
                    cuvant = cuvant.replaceFirst(left.get(i), "");//daca gaseste lambda inlocuim cu cuvant vid
                else
                    cuvant = cuvant.replaceFirst(left.get(i), right.get(i));
                verificRegula = true;
                System.out.println("Pasul " + numarulPasului + " al algoritmului: " + cuvant);//enumeram pasii algoritmul
                numarulPasului++;
            }
            if (verificRegula == true)
                i  = 0; //i = regula la care am ajuns
        }

        return cuvant;
    }

    private boolean validareString(String cuvant)
    {

        boolean esteInAlfabet = false;

        for (int i = 0; i < cuvant.length(); i++)
        {
            esteInAlfabet = false;
            for (int j = 0; j < alfabet.length; j++)
            {
                if (cuvant.charAt(i) == alfabet[j])
                    esteInAlfabet = true;

            }
            if (esteInAlfabet == false)
            {
                return false;
            }
        }
        return esteInAlfabet;
    }

    public void validareReguli()
    {
        for (int i = 0; i < numarReguli; i++)
        {
            if (validareString(left.get(i)) != true || validareString(right.get(i)) != true)
            {
                System.out.println("Regulile nu sunt valide");
                return;
            }


        }

    }

}