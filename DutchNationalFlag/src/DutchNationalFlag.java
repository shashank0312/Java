/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dutchnationalflag;

import java.util.Scanner;

/**
 *
 * @author kumarshashank
 */
public class DutchNationalFlag {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int size;
        Scanner scan = new Scanner(System.in);
        
        size = scan.nextInt();
        int arr[] = new int[size];
        
        int curr = 0;
        while ( curr < size && scan.hasNextInt()  ){
            arr[curr++] = scan.nextInt();
        }
        
        int random_index = (int)(Math.random() * size);
        System.out.println("Random index : " + random_index);
        partition(arr,random_index, size-1);
        
        for ( int i : arr){
            System.out.println(i + " ");
        }
    }
    
    static void partition(int[] arr, int index, int end){
        
        int small = 0;
        int equal = 0;
        int unknown = 0;
        int big = end;
        int num = arr[index];
        while( unknown <= big){
            if (arr[unknown] < num ){
                swap(arr,small, unknown);                
                ++small;
                if ( unknown < small)
                    unknown = small;
                else ++unknown;
            }
            else if (arr[unknown] > num){
                swap(arr,unknown,big);
                --big;
            }
            else if (arr[unknown] == num){
                ++unknown;
            }
        }
    }
    
    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = arr[first];
    }
}
