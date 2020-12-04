package main;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static double[][] part= new double[3][3];
    private static double[] min = new double[3];
    private static double[] max = new double[3];
    private static double prec=0.001;

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                part[i][j]=(double)s.nextLong();
            }
        }
        for(int i=0;i<3;i++){
            min[i]=Math.min(Math.min(part[0][i],part[1][i]),part[2][i]);
            max[i]=Math.max(Math.max(part[0][i],part[1][i]),part[2][i]);
        }
        System.out.println(k());
    }
    private static double f(double[] t){
        double sum = 0;
        double square;
        for(int i=0;i<3;i++) {
            square=0;
            for (int j = 0; j < 3;j++) {
                square += (t[j] - part[i][j])*(t[j] - part[i][j]);
            }
            sum+=Math.sqrt(square);
        }
        return sum;
    }
    private static double g(double x, double y){
        double[] l = new double[3];
        double[] r = new double[3];
        double[] ml = new double[3];
        double[] mr = new double[3];
        r[0]=x;
        l[0]=x;
        r[1]=y;
        l[1]=y;
        r[2]=max[2];
        l[2]=min[2];
        for (int i = 0; i < 3; i++) {
            mr[i] = r[i];
            ml[i] = l[i];
        }
        while (Math.abs(r[2] -l[2]) > prec) {
            ml[2] = l[2] + (r[2] - l[2]) / 3;
            mr[2] = r[2] - (r[2] - l[2]) / 3;
            if (f(ml) > f(mr)) {
                l[2] = ml[2];
            } else if (f(ml) < f(mr)) {
                r[2] = mr[2];
            } else {
                r[2] = mr[2];
                l[2] = ml[2];
            }
        }

        return f(r);
    }
    private static double h(double x){
        double[] l = new double[2];
        double[] r = new double[2];
        double[] ml = new double[2];
        double[] mr = new double[2];
        r[0]=x;
        l[0]=x;
        r[1]=max[1];
        l[1]=min[1];
        for (int i = 0; i < 2; i++) {
            mr[i] = r[i];
            ml[i] = l[i];
        }
        while (Math.abs(r[1] - l[1]) > prec) {
            ml[1] = l[1] + (r[1] - l[1]) / 3;
            mr[1] = r[1] - (r[1] - l[1]) / 3;
            if (g(ml[0],ml[1]) > g(mr[0],mr[1])) {
                l[1] = ml[1];
            } else if (g(ml[0],ml[1]) < g(mr[0],mr[1])) {
                r[1] = mr[1];
            } else {
                r[1] = mr[1];
                l[1] = ml[1];
            }
        }
        //System.out.println(r[1]);
        return g(r[0],r[1]);
    }
    private static double k(){
        double l;
        double r;
        double ml;
        double mr;
        r=max[0];
        l=min[0];
        mr = r;
        ml = l;
        while (Math.abs(r - l) > prec) {
            ml = l+ (r- l) / 3;
            mr = r - (r - l) / 3;
            if (h(ml) > h(mr)) {
                l = ml;
            } else if (h(ml) < h(mr)) {
                r= mr;
            } else {
                r = mr;
                l = ml;
            }
        }
        return h(r);
    }
}
