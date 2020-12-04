package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int length;
    static int ver=0;
    static int diam=0;
    static int counter=0;
    static int maxCounter=0;
    static ArrayList<ArrayList<Integer>> sides;
    static ArrayList<Integer> sol = new ArrayList<>();
    public static void main(String[] args) {

        //Task A2
        Scanner s=new Scanner(System.in);
        length = s.nextInt();
        sides = new ArrayList<>();
        for (int i = 0; i < length; ++i) {
            sides.add(new ArrayList<>());
        }
        for (int i = 0; i < length - 1; ++i) {
                int u=s.nextInt();
                sides.get(i+1).add(u-1);
                sides.get(u-1).add(i+1);
            }

        dfs(0, -1);
        //System.out.println(ver);
        diam=dfs(ver,-1);
        //System.out.println(diam);
        sol = new ArrayList<>();
        dfs(ver,-1);
        Collections.sort(sol);
        for(int so : sol) {
            System.out.print(so + " ");
        }
    }
    private static int dfs(int v, int p) {
        int result = 0;
        boolean is_centroid = true;
        for (int to : sides.get(v)) {
            if (to != p) {
                counter++;
                if(maxCounter<counter){
                    maxCounter=counter;
                    ver=to;
                }
                int cnt = dfs(to, v);
                result =Math.max(result,cnt+1);
                if (cnt > (diam-1) / 2) {
                    is_centroid = false;
                }
            }
        }
        counter--;

        if(diam%2==0){
            if (result<(diam)/2) {
                is_centroid = false;
            }
        } else {
            if (result<(diam-1)/2) {
                is_centroid = false;
            }
        }

        if (is_centroid || diam<2) {
            sol.add(v + 1);
        }

        return result;
    }
}