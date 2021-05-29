public class Challenge1{
  public static void main(String []args){
    final int Iterations = 100;
    for(int i=1; i<=Iterations; i++ ){
      if ((i%3 == 0) && (i%5 == 0)) {
          System.out.println("PlanitTesting");
      }
      else if ((i%3 == 0)) {
          System.out.println("Planit");
      }
      else if ((i%5 == 0)) {
          System.out.println("Testing");
      }
      else {
          System.out.println(i);
      }
    }
  }
}