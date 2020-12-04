package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static int n;
    private static int m;
    //private static ArrayList<int[]> doors;
    private static ArrayList<ArrayList<int[]>> sides;
    private static ArrayList<ArrayList<int[]>> sidesInv;
    private static boolean pathToN = false;
    private static int[] d;
    private static final int inf = 30000000;
    private static int ans=2;
    private static boolean[] wasHere;

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        n=s.nextInt();
        m=s.nextInt();
        int from;
        int to;
        int weight;
        sides=new ArrayList<>();
        sidesInv=new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sides.add(new ArrayList<>());
            sidesInv.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            from=s.nextInt()-1;
            to=s.nextInt()-1;
            weight=-s.nextInt();
            //int[] ar={from, to,weight};
            //doors.add(ar);
            int[] ar1={to, weight};
            int[] ar2={from,weight};
            sides.get(from).add(ar1);
            sidesInv.get(to).add(ar2);
        }
        wasHere = new boolean[n];
        for(int i =0;i<n;i++){
            wasHere[i]=false;
        }
        if(!dfs(0,-1)) ans = 1;
        d = new int[n];
        int[] p = new int[n];
        d[0]=0;
        p[0]=-1;
        for(int k=1;k<n;k++){
            d[k]=inf;
            p[k]=-1;
        }
        int lastV=-1;
        for(int k=0;k<n+1;k++){
            lastV=-1;
            for(int j=0;j<n;j++){
                for(int[] from1 : sidesInv.get(j)){
                    if(d[from1[0]]<inf){
                        if(d[j]>d[from1[0]]+from1[1]){
                            d[j]=d[from1[0]]+from1[1];
                            p[j]=from1[0];
                            lastV=j;
                        }
                    }
                }
            }
            if(lastV==-1) break;
        }
        //for(int i=0;i<n;i++){
            //System.out.println(p[i]+1);
            if (p[n-1] == n-1) {
                ans = 0;
                //break;
            }
        //}
        if(lastV!=-1){
            int v=lastV;
            for(int i=1;i<n;i++){
                v=p[v];
            }
            int u=v;
            //System.out.println(v+1);
            for(int i =0;i<n;i++){
                wasHere[i]=false;
            }
            pathToN = false;
            //System.out.println(dfs(u,-1));
            if(dfs(u,-1)) ans=0;
        }
        if(ans==0){
            System.out.println(":)");
        } else if(ans==1){
            System.out.println(":(");
        } else {
            System.out.println(-d[n-1]);
        }
    }

    private static boolean dfs(int v, int p) {
        wasHere[v]=true;
        for (int[] to : sides.get(v)) {
            if ((to[0] != p)&&(to[0] != v)) {
                if(to[0]==n-1) pathToN=true;
                if(!wasHere[to[0]]) dfs(to[0], v);
            }
        }
        return pathToN;
    }
}
