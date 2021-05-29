import java.time.LocalDate;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class Registry{
  public ArrayList<Person> people;
  public ArrayList<Person> duplicates;

  public Registry() {
    people = new ArrayList<Person>();
    duplicates = new ArrayList<Person>();
  }

  public void addPerson(String name, LocalDate DOB, String nationality) {
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

  public boolean removeDuplicates() {
    try {
      File file = new File("people.txt");
      FileWriter fileWriter = new FileWriter(file, false); 
      fileWriter.write("name,DOB,nationality" + "\n");
      people.forEach((person) -> { 
        try {
          fileWriter.write(person.getName() + "," + person.getDOB() + "," + person.getNationality() + "\n");          
        }
        catch(Exception e) {
          e.printStackTrace();
        }
      });
      fileWriter.close();
      duplicates.removeAll(duplicates);
    } catch (Exception e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return true;
  }
}