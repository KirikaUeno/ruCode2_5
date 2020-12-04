package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        // Task A1
        /*Scanner s=new Scanner(System.in);
        int length = s.nextInt();
        long[] a = new long[length];
        for(int i=0;i<length;i++){
            a[i]=s.nextInt();
        }

        long bil=1000000000;
        long[][] dp=new long[length][length];
        dp[length-1][length-1]=1;
        for(int i=0;i<length-1;i++){
            dp[i][i]=1;
            dp[i][i+1]=2;
            if(a[i]==a[i+1]) dp[i][i+1]+=1;
        }
        for(int len=3;len<=length;len++){
            for(int l=0;l<(length-len+1);l++){
                if((dp[l][l+len-2]+dp[l+1][l+len-1]-dp[l+1][l+len-2])<0){
                    dp[l][l+len-1]=((dp[l][l+len-2]+dp[l+1][l+len-1]-dp[l+1][l+len-2])%bil+bil)%bil;
                }
                dp[l][l+len-1]=(dp[l][l+len-2]+dp[l+1][l+len-1]-dp[l+1][l+len-2]);
                if(a[l]==a[l+len-1]) dp[l][l+len-1]+=dp[l+1][l+len-2]%bil+1;
            }
        }
        System.out.println(dp[0][length-1]%1000000000);*/

        // Task B1
        /*Scanner s=new Scanner(System.in);
        int length = s.nextInt();
        long[] a = new long[length];
        for(int i=0;i<length;i++){
            a[i]=s.nextInt();
        }

        double[][] dp=new double[length][length];
        for(int i=0;i<length;i++){
            dp[i][i]=a[i];
        }
        for(int len=2;len<=length;len++){
            for(int l=0;l<(length-len+1);l++){
                int r = l+len-1;
                dp[l][r]=(dp[l][l]+dp[l+1][r])/2;
                for(int i = l;i<r;i++){
                    dp[l][r]=Math.max(dp[l][r],(dp[l][i]+dp[i+1][r])/2);
                }
            }
        }
        System.out.println(dp[0][length-1]);*/

        // Task C1
        /*Main test = new Main();
        Scanner s=new Scanner(System.in);
        int length = s.nextInt();
        String a;
        a=s.next();

        double[][][] dp=new double[length][length][26];
        //String[][][] sol = new String[length][length][26];
        for(int i=0;i<length;i++){
            for(int k=0;k<26;k++){
                if(a.charAt(i)==k) dp[i][i][k]=1;
                else dp[i][i][k]=0;
            }
            dp[i][i]=0;
            //sol[i][i]="";
            if((a.charAt(i)==test.inv(a.charAt(i+1)))&&(test.isOpen(a.charAt(i)))){
                dp[i][i+1]=2;
                //sol[i][i+1]=a.charAt(i)+""+a.charAt(i+1);
            } else {
                dp[i][i+1]=0;
                //sol[i][i+1]="";
            }
        }
        for(int len=3;len<=length;len++){
            for(int l=0;l<(length-len+1);l++){
                int r = l+len-1;
                if((a.charAt(l)==test.inv(a.charAt(r)))&&(test.isOpen(a.charAt(l)))){
                    dp[l][r]=dp[l+1][r-1]+2;
                    sol[l][r]=a.charAt(l)+sol[l+1][r-1]+a.charAt(r);
                }
                else{
                    for(int i = l;i<r;i++){
                        if(dp[l][r]<(dp[l][i]+dp[i+1][r])){
                            dp[l][r]=dp[l][i]+dp[i+1][r];
                            sol[l][r]=sol[l][i]+sol[i+1][r];
                        }
                    }
                }
            }
        }
        if(sol[0][length-1]!=null) System.out.println(sol[0][length-1]);
        else System.out.println("");*/

        // Task D1
        Main test = new Main();
        Scanner s=new Scanner(System.in);
        String a;
        a=s.next();
        int length=a.length();

        double[][] dp=new double[length][length];
        double[][][] mp=new double[length][length][length];
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                for(int k=0;k<length;k++){
                    mp[i][j][k]=1000;
                }
            }
        }
        for(int i=0;i<length;i++){
            dp[i][i]=1;
        }
        for(int len=2;len<=length;len++){
            for(int l=0;l<(length-len+1);l++){
                int r = l+len-1;
                dp[l][r]=1000;
                if()
                for(int i = l;i<r;i++){
                    dp[l][r]=Math.min(dp[l][r],(dp[l][i]+dp[i+1][r]));
                }
            }
        }
        System.out.println(dp[0][length-1]);

        // Task E1
        /*Main test = new Main();
        Scanner s=new Scanner(System.in);
        String a;
        a=s.next();
        int length=a.length();

        double[][] dp=new double[length][length];
        String[][] sol = new String[length][length];
        dp[length-1][length-1]=0;
        sol[length-1][length-1]="";

        for(int i=0;i<length-1;i++){
            dp[i][i]=0;
            sol[i][i]="";
            if((a.charAt(i)==test.inv(a.charAt(i+1)))&&(test.isOpen(a.charAt(i)))){
                dp[i][i+1]=2;
                sol[i][i+1]=a.charAt(i)+""+a.charAt(i+1);
            } else {
                dp[i][i+1]=0;
                sol[i][i+1]="";
            }
        }
        for(int len=3;len<=length;len++){
            for(int l=0;l<(length-len+1);l++){
                int r = l+len-1;
                if((a.charAt(l)==test.inv(a.charAt(r)))&&(test.isOpen(a.charAt(l)))){
                    dp[l][r]=dp[l+1][r-1]+2;
                    sol[l][r]=a.charAt(l)+sol[l+1][r-1]+a.charAt(r);
                }
                else{
                    int count=0;
                    for(int i = l;i<r;i++){
                        if(dp[l][r]<(dp[l][i]+dp[i+1][r])) {
                            dp[l][r] = dp[l][i] + dp[i + 1][r];
                            sol[l][r] = sol[l][i] + sol[i + 1][r];
                            count++;
                        }
                    }
                    if(count==0) sol[l][r]=sol[l+1][r-1];
                }
            }
        }
        if(sol[0][length-1]!=null) System.out.println(sol[0][length-1]);
        else System.out.println("");*/

        // Task F1
        /*Main test = new Main();
        Scanner s=new Scanner(System.in);
        String a;
        a=s.next();
        int length=a.length();

        double[][] dp=new double[length][length];
        String[][] sol = new String[length][length];
        dp[length-1][length-1]=0;
        sol[length-1][length-1]="";
        for(int i=0;i<length-1;i++){
            dp[i][i]=0;
            sol[i][i]="";
            if((a.charAt(i)==test.inv(a.charAt(i+1)))&&(test.isOpen(a.charAt(i)))){
                dp[i][i+1]=2;
                sol[i][i+1]=a.charAt(i)+""+a.charAt(i+1);
            } else {
                dp[i][i+1]=0;
                sol[i][i+1]="";
            }
        }
        for(int len=3;len<=length;len++){
            for(int l=0;l<(length-len+1);l++){
                int r = l+len-1;
                if((a.charAt(l)==test.inv(a.charAt(r)))&&(test.isOpen(a.charAt(l)))){
                    dp[l][r]=dp[l+1][r-1]+2;
                    sol[l][r]=a.charAt(l)+sol[l+1][r-1]+a.charAt(r);
                }
                else{
                    for(int i = l;i<r;i++){
                        if(dp[l][r]<(dp[l][i]+dp[i+1][r])){
                            dp[l][r]=dp[l][i]+dp[i+1][r];
                            sol[l][r]=sol[l][i]+sol[i+1][r];
                        }
                    }
                }
            }
        }
        if(sol[0][length-1]!=null) System.out.println(sol[0][length-1]);
        else System.out.println("");*/
    }

    private char inv(char a){
        char b;
        switch(a){
            case '(':
                b=')';
                break;
            case ')':
                b='(';
                break;
            case '[':
                b=']';
                break;
            case ']':
                b='[';
                break;
            case '{':
                b='}';
                break;
            case '}':
                b='{';
                break;
            default:
                return 0;
        }
        return b;
    }

    private boolean isOpen(char a){
        return (a == '(') || (a == '[') || (a == '{');
    }
}