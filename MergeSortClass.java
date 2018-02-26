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

class MergeSortClass{

    int[] arr; 

    void mergesort(int low,int high){
        if (low<high){
            int mid = (high + low)/2;
            mergesort(low,mid);
            mergesort(mid+1,high);
            merge(low,mid,high);
        }
        
    }

    void merge(int l,int m, int h){
        int[] helper = new int[h-l+1];
        for (int i = l; i <= h; i++) {
            helper[i-l] = this.arr[i];
            //System.out.println(helper[i-l]);
        }
        int ind_a=0;
        int ind_b=m+1-l;
        int ctr = l;
        while(ind_a<=(m-l) && ind_b<=(h-l)){
            if (helper[ind_a]>helper[ind_b]){
                this.arr[ctr]=helper[ind_b];
                ctr+=1;
                ind_b+=1;
            }
            else{
                this.arr[ctr]=helper[ind_a];
                ctr+=1;
                ind_a+=1;
            }
            //System.out.print(this.arr[ctr-1]+" ");
        }
       
            while(ind_b<=(h-l)){
                this.arr[ctr]=helper[ind_b];
                ctr+=1;
                ind_b+=1;
                //System.out.print(this.arr[ctr-1]+" ");
            }
        
        
            while(ind_a<=(m-l)){
                this.arr[ctr]=helper[ind_a];
                ctr+=1;
                ind_a+=1;
                //System.out.print(this.arr[ctr-1]+" ");
            }
        //System.out.println();
        
    }


    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        int t = Reader.nextInt();
        MergeSortClass ob = new MergeSortClass();
        for (int i=0;i<t;i++){
            int n =Reader.nextInt();
            ob.arr = new int[n];
            for (int j=0;j<n;j++){
                ob.arr[j]=Reader.nextInt();
            }
            ob.mergesort(0,ob.arr.length-1);
            for (int j=0;j<n;j++){
                System.out.println(ob.arr[j]);
            }
        }
    }
}
