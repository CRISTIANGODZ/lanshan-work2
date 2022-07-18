import java.util.Scanner;

/**
 * @author 张丁野
 * @version v1.0
 * @time 2022-07-18-20:58
 * @Description
 */
public class splitNumber {
    static int n;
    static int[] a=new int[10];

    public static void main(String[] args) {
        System.out.println("请输入一个数字：（1,8）");
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        method1(0,0,0);
    }
    public static void method1(int max,int m,int n){
        if (max==n){
            for (int i = 1; i < m; i++) {
                System.out.print(a[i]+"+");
            }
            System.out.println(a[m]);
        }
        for (int i = 1; i < n; i++) {
            if ((max+i)<=n&&i>=n){
                a[m+1]=i;
                m++;
                method1(max+i,m,i);
                m--;
            }
        }
    }
}
