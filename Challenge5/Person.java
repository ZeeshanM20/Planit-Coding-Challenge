import java.util.Date;
import java.time.LocalDate;
import java.time.Period;

public class Person{
  private final String name;
  private final Date dob;
  private final String nationality;
  private final int age;

  public Person(String name, Date dob, String nationality) {
    System.out.println("Age" + this.age);
    this.name = name;
    this.dob = dob;
    this.nationality = nationality;
    this.age = this.getAge();
  }
  public String getName() {
    return this.name;
  }

  public Date getDOB() {
    return this.dob;
  }

  public String getNationality() {
    return this.nationality;
  }

  public int getAge() {
    LocalDate now = new LocalDate();
    return Period.between(dob, now).getYears();
  }
}