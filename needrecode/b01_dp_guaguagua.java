import java.util.ArrayList;
import java.util.Scanner;

public class b01_dp_guaguagua {
    public static void main(String[] args) {
       Scanner Sc = new  Scanner(System.in);
        int n = new Scanner(System.in).nextInt();
        if (n <= 1) {
            System.out.println(1);
        }

        ArrayList<Integer> dp = new ArrayList<Integer>();
        dp.add(1);
        dp.add(1);

        for (int i = 2; i <= n; i++) {
            dp.add(dp.get(i - 1) + dp.get(i - 2));
        }

        System.out.println(dp);
    }
}
