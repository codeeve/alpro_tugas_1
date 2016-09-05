/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.pkg1.alpro;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Saya @ WASD Labs
 * yeah... we do this the fun way
 */
public class Tugas1Alpro {
    
    //lebar array maximal
    private final static int MAX = 8192;
    private final static int[] n = new int[]{512, 1024, 2048, 4096, 8192};

    public static void main(String[] args) {
        
        System.out.println("mulai beres-beres data");
        
        //buat variable array randomnya untuk di sort
        int[] arrayBubble512 = new int[n[0]];
        int[] arrayBubble1024 = new int[n[1]];
        int[] arrayBubble2048 = new int[n[2]];
        int[] arrayBubble4096 = new int[n[3]];
        int[] arrayBubble8192 = new int[n[4]];
        
        int[] arrayMerge512 = new int[n[0]];
        int[] arrayMerge1024 = new int[n[1]];
        int[] arrayMerge2048 = new int[n[2]];
        int[] arrayMerge4096 = new int[n[3]];
        int[] arrayMerge8192 = new int[n[4]];
        
        //buat array dari angka random sebanyak 8192 elemen
        arrayBubble8192 = randomizeArray(n[4]);
        arrayMerge8192 = arrayBubble8192;
        
        //split array 8192 ke 4k, 2k, 1k, 512
        arrayBubble512 = splitArray(arrayBubble8192, n[0]);
        arrayBubble1024 = splitArray(arrayBubble8192, n[1]);
        arrayBubble2048 = splitArray(arrayBubble8192, n[2]);
        arrayBubble4096 = splitArray(arrayBubble8192, n[3]);
        
        arrayMerge512 = arrayBubble512;
        arrayMerge1024 = arrayBubble1024;
        arrayMerge2048 = arrayBubble2048;
        arrayMerge4096 = arrayBubble4096;
        
        System.out.println("data generation selesai. ready for the punchline");
        System.out.println("================================================");
        
        //mulai sort sekaligus tampilkan
        bubbleSort(arrayBubble512);
        startMergeSort(arrayMerge512);
        
        bubbleSort(arrayBubble1024);
        startMergeSort(arrayMerge1024);
        
        bubbleSort(arrayBubble2048);
        startMergeSort(arrayMerge2048);
        
        bubbleSort(arrayBubble4096);
        startMergeSort(arrayMerge4096);
        
        bubbleSort(arrayBubble8192);
        startMergeSort(arrayMerge8192);
        
    }
    
    //fungsi untuk membuat array awal secara random dan nantinya akan di sort
    private static int[] randomizeArray(int max){
        //buat randomizer
        Random rand = new Random();
        //buat variablenya
        int[] randomizedArray = new int[max];
       
        for(int i=0; i<max; i++){
            //buat angka random 1-100 lalu masukkan ke dalam variable
            randomizedArray[i]= rand.nextInt(8192) + 1;
        }
        
        return randomizedArray;
    }
    
    private static int[] splitArray(int[]source, int max){
        //buat variablenya
        int[] splittedArray = new int[max];
       
        for(int i=0; i<max; i++){
            //buat angka random 1-100 lalu masukkan ke dalam variable
            splittedArray[i]= source[i];
        }
        
        return splittedArray;
    }
    
    public static void bubbleSort(int[] numArray) {

    int n = numArray.length;
    int temp = 0;

    System.out.print("bubble sort untuk n="+n);
    
    //start timer
    long startTime = System.nanoTime();
    for (int i = 0; i < n; i++) {
        for (int j = 1; j < (n - i); j++) {

            if (numArray[j - 1] > numArray[j]) {
                temp = numArray[j - 1];
                numArray[j - 1] = numArray[j];
                numArray[j] = temp;
            }

        }
    }
    //end timer
    long stopTime = System.nanoTime();
    //run time
    long elapsedTime = stopTime - startTime;


    System.out.println(" runtime "+elapsedTime+" ns");
    }
    
    
    static void startMergeSort(int[] numArray){
        int n = numArray.length;
        System.out.print("merge sort untuk n="+n);
        //start timer
        long startTime = System.nanoTime();
        
        mergeSort(numArray);
        
         //end timer
        long stopTime = System.nanoTime();
        //run time
        long elapsedTime = stopTime - startTime;


        System.out.println(" runtime "+elapsedTime+" ns");
        
    }
    
    static void mergeSort(int[] A) {
        if (A.length > 1) {
            int q = A.length/2;

            int[] leftArray = Arrays.copyOfRange(A, 0, q);
            int[] rightArray = Arrays.copyOfRange(A,q,A.length);

            mergeSort(leftArray);
            mergeSort(rightArray);

            merge(A,leftArray,rightArray);
        }
    }

    static void merge(int[] a, int[] l, int[] r) {
        int totElem = l.length + r.length;
        //int[] a = new int[totElem];
        int i,li,ri;
        i = li = ri = 0;
        while ( i < totElem) {
            if ((li < l.length) && (ri<r.length)) {
                if (l[li] < r[ri]) {
                    a[i] = l[li];
                    i++;
                    li++;
                }
                else {
                    a[i] = r[ri];
                    i++;
                    ri++;
                }
            }
            else {
                if (li >= l.length) {
                    while (ri < r.length) {
                        a[i] = r[ri];
                        i++;
                        ri++;
                    }
                }
                if (ri >= r.length) {
                    while (li < l.length) {
                        a[i] = l[li];
                        li++;
                        i++;
                    }
                }
            }
        }
        //return a;

    }

    
}
