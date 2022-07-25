import java.util.Scanner;
public class PakuriProgram {
    public static void main(String[] args) {

        Scanner scnr =new Scanner(System.in);
        int option = 1;
        Pakudex pakudex;


        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        System.out.print("Enter max capacity of the pakudex: ");


        int capacity = scnr.nextInt();
        System.out.println("The Pakudex can hold " + capacity + " species of Pakuri");
        

        for (int i = 0; i < 1;) {



            pakudex = new Pakudex(capacity);

            System.out.println();
            System.out.println("Pakudex Main Menu");
            System.out.println("-----------------");
            System.out.println("1. List Pakuri");
            System.out.println("2. Show Pakuri");
            System.out.println("3. Add Pakuri");
            System.out.println("4. Evolve Pakuri");
            System.out.println("5. Sort Pakuri");
            System.out.println("6. Exit");
            System.out.println();
            System.out.print("What would you like to do? ");

            option = scnr.nextInt();

            if (option == 1) {
                String [] speciesArray = pakudex.getSpeciesArray();
                if (speciesArray == null); {
                    System.out.println("No Pakuri in pakudex yet!");

                }
            }

            if (option == 2) {
                System.out.print("Enter the name of the species to display: ");
                String species = scnr.next();
                int[] stats = pakudex.getStats(species);

                if(stats == null)
                {
                    System.out.println("Error: No such Pakuri!");
                    continue;
                }

                System.out.println("\nSpecies: " + species);
                System.out.println("Attack: " + stats[0]);
                System.out.println("Defense: " + stats[1]);
                System.out.println("Speed: " + stats[2] + "\n");

            }

            if (option == 3) {
                int size = pakudex.getSize();
                if(size == capacity)
                {
                    System.out.println("Error: Pakudex is full!");
                    continue;
                }

                System.out.print("Enter the name of the species to add: ");
                String species = scnr.next();

                boolean methodAnswer = pakudex.addPakuri(species);
                if(methodAnswer)
                {
                    System.out.println("Pakuri species " + species + " successfully added!");
                }
                else
                {
                    System.out.println("Error: Pakudex already contains this species!");
                }
            }

            if (option == 4) {
                System.out.print("Enter the name of the species to evolve:");
                String species = scnr.next();
                boolean evolve = pakudex.evolveSpecies(species);
                if (evolve) {
                    System.out.println(species + "has evolved!");
                }
                else {
                    System.out.println("Error: No such Pakuri!");
                }

            }

            if (option == 5) {
                pakudex.sortPakuri();
                System.out.print("Pakuri have been sorted!");
            }

            if (option == 6 ) {
                i = 1;
            }



        }
        System.out.println("Thanks for using Pakudex! Bye!");

    }

}
