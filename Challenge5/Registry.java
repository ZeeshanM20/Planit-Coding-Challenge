import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;

public class Registry{
  public ArrayList<Person> people;
  public ArrayList<Person> duplicates;

  public Registry() {
    people = new ArrayList<Person>();
    duplicates = new ArrayList<Person>();
  }

  public void addPerson(String name, Date DOB, String nationality) {
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
}