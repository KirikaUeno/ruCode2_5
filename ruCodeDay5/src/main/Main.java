package main;

import java.util.Scanner;

public class Main {
    private static int[][] t;
    private static int n;

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        n = s.nextInt();
        int k = s.nextInt();
        t= new int[n][n];
        for(int i = 0; i<k;i++){
            String str = s.next();
            int y1;
            int x1;
            if(str.equals("ADD")) {
                x1 = s.nextInt()-1;
                y1 = s.nextInt()-1;
                add(x1, y1);
            }
            if(str.equals("GET")) {
                x1 = s.nextInt()-1;
                y1 = s.nextInt()-1;
                int x2 = s.nextInt() - 1;
                int y2 = s.nextInt() - 1;
                System.out.println(get(x1, y1, x2, y2));
            }
        }
    }

    private static void add(int x, int y){
        for(int i=x;i<n;i=g(i)){
            for(int j=y;j<n;j=g(j)){
                t[i][j]+=1;
            }
        }
    }

    private static int get(int x1, int y1, int x2, int y2){
        if(x1>x2) {
            int xm=x2;
            x2= x1;
            x1= xm;
        }
        if(y1>y2){
            int ym=y2;
            y2= y1;
            y1= ym;
        }
        return sum(x2,y2)+sum(x1-1,y1-1)-sum(x2,y1-1)-sum(x1-1,y2);
    }

    private static int sum(int x, int y){
        if((x<0) || (y<0)) return 0;
        else{
            int sum=0;
            for(int i=x;i>=0;i=f(i)-1){
                for(int j=y;j>=0;j=f(j)-1){
                    sum+=t[i][j];
                }
            }
            return sum;
        }
    }

    private static int f(int i){
        return (i&(i+1));
    }

    private static int g(int i){
        return (i|(i+1));
    }
}