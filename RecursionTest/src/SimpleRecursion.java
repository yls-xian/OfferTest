/**
 * @author yulinsheng
 * @time 2021-04-26 17:21
 */
public class SimpleRecursion {
    public static void main(String[] args) {
        System.out.println(new SimpleRecursion().test(3));


        System.out.println(new SimpleRecursion().gcd(12,32));
        for(int i = 0;i < 10;i++) {
            System.out.println(new SimpleRecursion().facb(i));
        }
    }

//  斐波那契数列 0 1 1 2 3 5 8 21
    public int facb(int n){
//        定义出口
        if(n== 0){return 0;}
        if(n == 1){return 1;}
        return facb(n-1)+facb(n-2);

    }
    public int gcd(int a, int b){
        //假设a是大数，b是小数

        //定义出口，当b=0时，a的值是最大公约数
        if(b==0){
            return a;
        }
        return gcd(b,a%b);//调用递归
    }
    public int test(int n) {
//     定义出口
        if (n == 0) {
            return 1;
        }
        return n * test(n - 1);
    }
//
}
