import org.junit.Test;

import java.sql.Time;

/**
 * @author yulinsheng
 * @time 2021-04-24 10:18
 */
public class TimeCost {

    public int timeNN(int n){
        int res = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                res += j*i;
            }
        }
        return res;
    }
    public int timeNLogN(int n1,int n2){
        int total = 0;
        int j  = 1;
        for(int i=0;i < n1;i++){
            while( j < n2){
                total += j;
                j = j*2;
            }
        }
        return total;
    }

   public int timeMaddN(int m,int n){
       int res = 0;
       for(int i = 0;i < m;i++){
           res += i;
       }
       for(int i = 0;i < n;i++){
           res += i;
       }
       return res;
   }

   public int timeLogN(int n) {
       int i = 1;
       while (i < n) {
            i = i * 2;
       }
       return i;
   }

   public int timeN(int n ){
       int total = 0;
       for(int i = 0;i < n;i++){
            total += i;
       }
       return total;
   }
    public int timeOne(int n){
        int i = n;
        int j = n * 2;
        return i+j;
    }
}
