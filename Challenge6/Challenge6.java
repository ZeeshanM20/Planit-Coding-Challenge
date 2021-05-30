import java.util.Scanner;

public class Challenge6{
  public static void main(String []args) {

    Registry registry = new Registry();
    boolean run = true;

    registry.readFile(args[0]);

    //Main loop for program
    while (run == true) {
      System.out.println("Enter D for a list of duplicates");
      System.out.println("Enter RD to remove all duplicates");
      System.out.println("Enter AVG to claculate the average age of the peopl in the list");
      System.out.println("Enter S to find all the people with age less than variable N");
      System.out.println("Enter UC to obtain a list of unique countries");
      System.out.println("Enter Q to Exit program");

      Scanner input = new Scanner(System.in);  
      String choice = input.nextLine().toUpperCase();

      switch (choice) {
        case "D":
           System.out.println(registry.getFormatedDuplicates() + "\n");
          break;
        case "RD":
          registry.removeDuplicates(args[0]);
          System.out.println("\nDuplicates removed from originl list" + "\n");
          break;
        case "AVG":
          System.out.println("\nThe average age for people in the list is: " + registry.getAverageAge() + "\n");
          break;
        case "S":
          System.out.println("\nEnter a value for N \n");
          Scanner sc = new Scanner(System.in);  
          int n = sc.nextInt();
          System.out.println(registry.getPeopleWithAgeLessThan(n) + "\n");
          break;
        case "UC":
          System.out.println("\nFollowing is a list of the unique countries \n" + registry.getUniqueCountries() + "\n");
          break;
        case "Q":
          System.out.println("Exit");
          run = false;
          break;
        default:
          System.out.println("Please enter a valid choice");
      }
    }
  }
}