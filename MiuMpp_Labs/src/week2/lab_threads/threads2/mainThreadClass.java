package week2.lab_threads.threads2;

public class mainThreadClass {

    public static void main( String[] args ) {

        System.out.println("Inside main  ");   
        int i;
        for (i = 1; i <= 10; i++ )
        {
           PrimeThread p = new PrimeThread(i);
           p.start();
        }

    }
}
