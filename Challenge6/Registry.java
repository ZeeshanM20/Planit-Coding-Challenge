import java.time.LocalDate;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Registry{
  public ArrayList<Person> people;
  public ArrayList<Person> duplicates;
  public int sumOfAges = 0;

  public Registry() {
    people = new ArrayList<Person>();
    duplicates = new ArrayList<Person>();
  }

  // Parse data from list and call addPerson.
  public void readFile(String path) {
    try {
      File peopleList = new File(path);
      Scanner reader = new Scanner(peopleList);
      String headers = reader.nextLine();
      while (reader.hasNextLine()) {
        String data = reader.nextLine();
        String[] values = data.split(",");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dob = LocalDate.parse(values[1], formatter); 
        this.addPerson(values[0], dob, values[2]);
      }
      reader.close();
    } catch (Exception e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
  
  // Create instances of person class and populate people and duplicate lists
  private void addPerson(String name, LocalDate DOB, String nationality) {
    Person person = new Person( name, DOB, nationality);
    for (Person existingPerson : people) {
      if(existingPerson.getName().equals(person.getName())) {
        duplicates.add(person);
        return;
      }
    }
    people.add(person);
  }

  public ArrayList<String> getFormatedDuplicates() {
    ArrayList<String> duplicatesArray = new ArrayList<String>();
    duplicates.forEach((duplicatePerson) -> {
      duplicatesArray.add("\n" + "Name: " + duplicatePerson.getName() + ", Date of Birth: " +  duplicatePerson.getDOB() + ", Nationality: " +  duplicatePerson.getNationality());    
    });
    return duplicatesArray;
  }

  public boolean removeDuplicates(String path) {
    try {
      File file = new File(path);
      FileWriter fileWriter = new FileWriter(file, false); 
      fileWriter.write("name,DOB,nationality" + "\n");
      for(Person person: people ) {
        fileWriter.write(person.getName() + "," + person.getDOB() + "," + person.getNationality() + "\n");          
      }
      fileWriter.close();
      duplicates.removeAll(duplicates);
    } catch (Exception e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return true;
  }

  public Integer getAverageAge() {
    sumOfAges = 0;
    people.forEach((currentPerson) -> {
      sumOfAges = sumOfAges + currentPerson.getAge();
    });
    int avgAge = sumOfAges/people.size();
    return avgAge;
  }

  public ArrayList<String> getPeopleWithAgeLessThan(int n) {
    ArrayList<String> peopleArray = new ArrayList<String>();
    people.forEach((currentPerson) -> {
      if(currentPerson.getAge() < n) {
        peopleArray.add("\n" + "Name: " + currentPerson.getName() + ", Date of Birth: " +  currentPerson.getDOB() + ", Nationality: " +  currentPerson.getNationality());    
      }
    });
    return peopleArray;
  }

  public Set<String> getUniqueCountries() {
    Set<String> countries = new HashSet<>();
    people.forEach((currentPerson) -> {
      countries.add("\n" + currentPerson.getNationality());
    });
    return countries;
  }
}