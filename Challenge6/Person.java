import java.time.LocalDate;
import java.time.Period;

// Person class to create instances of people from provided list.
public class Person{
  private final String name;
  private final LocalDate dob;
  private final String nationality;
  private final int age;

  public Person(String name, LocalDate dob, String nationality) {
    this.name = name;
    this.dob = dob;
    this.nationality = nationality;
    this.age = this.getAge();
  }
  public String getName() {
    return this.name;
  }

  public LocalDate getDOB() {
    return this.dob;
  }

  public String getNationality() {
    return this.nationality;
  }

  // Calculating age from passed date of births.
  public int getAge() {
    return Period.between(dob, LocalDate.now()).getYears();
  }
}