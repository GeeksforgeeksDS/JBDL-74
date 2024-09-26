import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerExample {


    public static void main(String[] args) throws InterruptedException {
        // server
        // running 24 x 7
        Scanner scanner = new Scanner(System.in);
        ExecutorService service = Executors.newFixedThreadPool(6);

        while (true){
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("suspend")){
                System.exit(0);
            }
            service.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception exception){
                    }
                    System.out.println(" input data is - " + input + " by " + Thread.currentThread().getName() );
                }
            });
        }

    }


}
