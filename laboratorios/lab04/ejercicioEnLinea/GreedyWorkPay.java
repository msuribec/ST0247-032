import java.util.Arrays;
import java.util.Scanner;


public class GreedyWorkPay {

    public static void main(String [] args){
        read();
    }

    private static void read (){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n!=0){
            int d = sc.nextInt();
            int r = sc.nextInt();
            int [] morning = new int[n];
            int [] afternoon = new int[n];
            int extrahrs = 0, extrapay=0;

            for (int i = 0; i < n; i++) morning[i]= sc.nextInt();
            for (int i = 0; i < n; i++) afternoon[i]= sc.nextInt();


            Arrays.sort(morning);//worst case complexity of O(N log n)
            Arrays.sort(afternoon);//worst case complexity of O(N log n)

            for (int i = 0; i < n; i++)
                extrahrs += (morning[i] + afternoon[n-i-1]) - d;

            extrapay = extrahrs * r;
            System.out.println(extrapay);
            n = sc.nextInt();

        }

    }
}
