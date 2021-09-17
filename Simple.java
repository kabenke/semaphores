import java.util.concurrent.Semaphore;
public class Simple
{
  // Initialise 3 Semaphores
  private final static Semaphore S1 = new Semaphore(0);
  private final static Semaphore S2 = new Semaphore(0);
  private final static Semaphore S3 = new Semaphore(0);


  public static void main(String[] args) {
  try{
    f1();
    f2();
    f3();
  } catch (InterruptedException e) {
    e.printStackTrace();
  }
  }

  public static void f1() throws InterruptedException {
    System.out.println("2");
    S1.acquire();
    S3.release();
    System.out.println("13");
  }

  public static void f2() throws InterruptedException {
    S1.release();
    System.out.println("3");
    System.out.println("5");
    S2.release();
  }

  public static void f3() throws InterruptedException {
    S2.acquire();
    System.out.println("7");
    System.out.println("11");
    S3.release();
  }
}
