/**
 * @author yulinsheng
 * @time 2021-04-26 19:56
 */
public class fenzhiTest {
    public static void main(String[] args) {
        System.out.println(jump(8));
    }

    public static int jump(int n){
//        定义出口，当台阶数为0时
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return jump(n-1)+jump(n-2);

    }
}
