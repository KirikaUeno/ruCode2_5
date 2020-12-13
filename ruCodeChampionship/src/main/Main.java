package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int ans = 0;
        Scanner s=new Scanner(System.in);
        /*int x = Math.abs(s.nextInt());
        int y= Math.abs(s.nextInt());
        int r = s.nextInt();
        if (r >= Math.abs(x) || r >= Math.abs(y) || x == 0 || y == 0) {
            ans++;
        }
        if (r > Math.abs(x))
            ans++;
        if (r > Math.abs(y))
            ans++;
        if (r * r > x*x+ y*y)
            ans++;
        if ( r == 0 && (x == 0 || y == 0))
            ans--;
        System.out.println(ans+1);*/
        int n=s.nextInt();
        int m=s.nextInt();
        int min=0;
        int max=0;
        if(n*(n-1)/2<m || n<2){
            System.out.println("-1");
        } else {
            min=(Math.max(n - m, 1));
            if (Math.sqrt(8*m+1)-(int)Math.sqrt(8*m+1)==0){
                max = n-(int)(1+Math.sqrt(8*m+1))/2+1;
            } else max = n-(int)(1+Math.sqrt(8*m+1))/2;
            System.out.println(min + " " + max);
        }
    }
}
