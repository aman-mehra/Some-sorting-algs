//Name:Aman Mehra
//Roll No:2017017
//Group:3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.HashSet;
import java.lang.String;
import java.lang.Math;

/** Class for buffered reading int and double values */
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
}

public class Quicksort{

    int[] arr;

    void quick(int low,int high){
        /*
        System.out.print(low+" ");
        System.out.print(high);
        System.out.println(Arrays.toString(arr));
        */
        if(high>low){
            int pivot = arr[low];
            int smaller = low+1;
            int bigger = high;
            int temp;
            outer:
            while (bigger>=smaller){
                while(arr[smaller]<pivot){
                    smaller++;
                    if (smaller>=high){break outer;}
                }
                while (arr[bigger]>=pivot){
                    bigger--;
                    if (bigger==low){break outer;}
                }
                if(bigger>smaller){
                    temp = arr[smaller];
                    arr[smaller]=arr[bigger];
                    arr[bigger]=temp;
                    smaller++;
                    bigger--;
                }
            }
            temp=arr[low];
            arr[low]=arr[bigger];
            arr[bigger]=temp;
            
            if (low<bigger-1){quick(low,bigger-1);}
            if (bigger+1<high){quick(bigger+1,high);}
        }
    }

    public static void main(String[] args)throws IOException {
        Reader.init(System.in);
        int t = Reader.nextInt();
        int n;
        Quicksort ob = new Quicksort();
        for (int i=0;i<t;i++){
            n = Reader.nextInt();
            ob.arr = new int[n];
            for (int j=0;j<n;j++){
                ob.arr[j]=Reader.nextInt();
            }
            ob.quick(0,n-1);
            for (int j=0;j<n;j++){
                System.out.print(ob.arr[j]+" ");
            }
            System.out.println();
        }
    } 
}