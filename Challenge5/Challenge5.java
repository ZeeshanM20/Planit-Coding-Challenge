import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;
import java.io.File;
import java.text.SimpleDateFormat; 

import java.io.FileNotFoundException;  // Import this class to handle errors

public class Challenge5{
  public static void main(String []args) {

    Registry registry = new Registry();
    boolean run = true;

    try {
      File peopleList = new File("people.txt");
      Scanner reader = new Scanner(peopleList);
      String headers = reader.nextLine();
      while (reader.hasNextLine()) {
        String data = reader.nextLine();
        String[] values = data.split(",");
        Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(values[1]);  
        registry.addPerson(values[0], dob, values[2]);
      }
      reader.close();
    } catch (Exception e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    System.out.println(registry.people.size());
    System.out.println(registry.duplicates.size());

    while (run == true) {
      System.out.println("Enter D for a list of duplicates");
      System.out.println("Enter RD to remove all duplicates");
      System.out.println("Enter AVG to claculate the average age of the peopl in the list");
      System.out.println("Enter S to find all the people with age less than variable N");
      System.out.println("Enter UC to obtain a list of unique countries");
      System.out.println("Enter EX to Exit program");

      Scanner input = new Scanner(System.in);  
      String choice = input.nextLine().toUpperCase();

      switch (choice) {
        case "D":
           System.out.println(registry.getFormatedDuplicates() + "\n");
          break;
        case "RD":
          System.out.println("Alter the original list and remove duplicates");
          break;
        case "AVG":
          System.out.println("Calculate the average age");
          break;
        case "S":
          System.out.println("Find all the people with age less than N");
          System.out.println("Enter a value for N");
          Scanner sc = new Scanner(System.in);  
          int n = sc.nextInt();
          System.out.println("N = " + n);
          break;
        case "UC":
          System.out.println("Obtain a list of unique countries");
          break;
        case "EX":
          System.out.println("Exit");
          run = false;
          break;
        default:
          System.out.println("Please enter a valid choice");
      }
    }
  }
}