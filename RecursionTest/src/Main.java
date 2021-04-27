/**
 * @author yulinsheng
 * @time 2021-04-26 20:25
 */
import java.util.Scanner;
public class Main{
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for(int i = 0;i < num;i++){
            long num_l = scanner.nextLong();
            double d = new Solution().numDay(num_l);
            System.out.println(d);
        }
    }
}
class Solution{

    public double numDay(double length_l){
        if(length_l == 1){
            return 1;
        }
        double pow = Math.ceil(Math.log(length_l)/Math.log(2));
        return pow+1;
            }
}
