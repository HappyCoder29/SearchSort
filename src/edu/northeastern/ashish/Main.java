package edu.northeastern.ashish;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] arr1 = {1,5,15,23,76};
        int[] arr2 = {2,3,33,57,68};
        int[] arr3 = {6,18,89,101};
        ArrayList<int[]> list = new ArrayList<int[]>();
        list.add(arr1);
        list.add(arr2);
        list.add(arr3);

        int[] merged =  mergeSortedArraysKWay(list);

        printArr(merged);
//        ArrayList<Interval> intervals = new ArrayList<Interval>();
//
//        intervals.add(new Interval(1,5));
//        intervals.add(new Interval(3,7));
//        intervals.add(new Interval(2,3));
//        intervals.add(new Interval(8,15));
//
//        mergeIntervals(intervals);



//        int[] arr = {0,0,0,0,1,1,1,2,2,2,2,2,2,2,2,5,5,5,5,5,7,7,8};
//        //int index = getFirstIndex(arr, 3);
//
//        int ceiling = findCeiling(arr, 2);
//
//        System.out.println(ceiling);
//        int[] arr = {6,5,3,1,8,7,2,4};
//        int[] count = {0,1,2,3,2,2,2,3,4,6,7};
//        int[] binArr = {0,1,1,0,1,1,0,0,1};
//        int[] dutchArr = {0,1,1,2,0,2,0,1,2,0,1};
//        //dutchFlag(arr, 4);
//
//        int[] sorted = {1,2,4,7,8,9,12,15,34,76};
//        System.out.println(binSearchRecursive(sorted, 10));
        //sortBinaryArray(binArr);
       // countSort(count, 9);
        //quickSort(arr);
        //printArr(arr);

    }

    // region Done in part 1
    public static  void printArr(int[] arr){
        for(int i = 0 ; i < arr.length; i ++){
            System.out.print( arr[i] + " ");
        }
        System.out.println("");
    }

    public  static void swap(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public static  void  bubbleSort(int[] arr){
        for(int i = 0; i < arr.length; i ++){
            for(int j = 0; j < arr.length - i -1; j ++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public static void selectionsort(int[] arr){
        for(int i = 0 ; i< arr.length; i ++){
            int minIndex = i;
            for(int j = i +1; j < arr.length; j ++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }

            if(minIndex != i){
                swap(arr, i ,minIndex);
            }
        }
    }

    public  static void mergeSort(int[] arr){
        mergeSort(arr, 0, arr.length-1);
    }

    private static void mergeSort(int[] arr, int low, int high){

        if(low >= high){
            return;
        }

        int mid = (low + high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, high);
    }

    private static void merge(int[] arr, int low, int high){
        int mid = (low + high)/2;

        int[] temp = new int[high -low +1];
        int i = low;
        int j = mid +1;
        int index = 0;
        // while pointers dont run out of mid and high
        while(i <= mid && j <=high){
            if(arr[i] <= arr[j]){
                temp[index] = arr[i];
                i ++;
            }else{
                temp[index] = arr[j];
                j ++;
            }
            index ++;
        }
        // copy left overs
        while(i<= mid){
            temp[index++] = arr[i++];
        }
        while(j<= high){
            temp[index++] = arr[j++];
        }

        i = low;

        for(int k = 0; k < temp.length; k ++){
            arr[i] = temp[k];
            i ++;
        }
    }



    static void quickSort(int[] arr){
        quickSort(arr, 0, arr.length -1);
    }

    static void quickSort(int[] arr, int low, int high){

        if(low < high){
            int pos = partition(arr, low, high);
            quickSort(arr, low, pos -1);
            quickSort(arr, pos +1, high);
        }

    }

    static int partition(int[] arr, int low, int high){

        int pivot = arr[high];

        int wall = low -1;

        for (int i = low; i < high; i ++){
            if(arr[i] < pivot){
                wall++;
                swap(arr, i, wall);
            }
        }

        swap(arr, high, wall +1);
        return  wall +1;
    }


    private static  void countSort(int[] arr, int RANGE){

        int[] countArr = new int[RANGE];
        for(int i = 0 ; i < arr.length; i ++){
            countArr[arr[i]] ++;
        }

        int index = 0;

        for(int i = 0 ; i < RANGE; i ++){
            while(countArr[i]  > 0){
                arr[index] = i;
                index ++;
                countArr[i] --;
            }
        }


    }

    public static void sortBinaryArray(int[] arr){
        int low = 0 ;
        int high = arr.length -1;

        while(low < high){
            if(arr[low] == 1){
                swap(arr, low, high);
                high --;
            }else{
                low++;
            }
        }
    }

    private static void  dutchFlag(int[] arr, int pivot ){

        int low = 0;
        int mid = 0;
        int high = arr.length -1;

        while(mid <= high){
            if(arr[mid] < pivot){
                swap(arr,low, mid);
                low ++;
                mid ++;

            }else if(arr[mid] == pivot){
                mid++;
            }
            else{
                swap(arr, mid, high);
                high --;
            }
        }



    }

    private static void sortArrayWaveForm(int[] arr){

        Arrays.sort(arr);
        int temp ;

        for(int i = 0 ; i < arr.length -1; i +=2){
            temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }
    }

    private static void sortArrayWaveLinear(int[] arr){

        int temp;
        for(int i = 0 ; i < arr.length ; i +=2){
            if(i > 0 && arr[i-1] >arr[i]){
                temp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = temp;
            }

            if(i < arr.length -1 && arr[i] < arr[i+1]){
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
    }


    static boolean binSearch(int[] arr, int x){

        int low = 0;
        int high = arr.length -1;

        while(low <= high){
            int mid = (low + high)/2;

            if(arr[mid] == x){
                return  true;
            }else if (arr[mid] < x){
                low = mid +1;
            }else{
                high = mid-1;
            }
        }
        return  false;
    }

    static  boolean binSearchRecursive(int[] arr, int x){
        return  binSearchRecursive(arr, x, 0, arr.length -1);
    }

    static  boolean binSearchRecursive(int[] arr, int x, int low, int high){

        if(low > high){
            return  false;
        }
        int mid = (low + high)/2;

        if(arr[mid] == x){
            return  true;
        }
        else if (arr[mid] < x){
            return  binSearchRecursive(arr,x, mid +1, high);
        }else{
            return  binSearchRecursive(arr,x, low, mid-1);
        }
    }

    // endregion


    // region Part 2
    static int getNumOccurances(int[] arr, int x){
        return  getNumOccurances(arr, x, 0, arr.length -1);
    }

    static int getNumOccurances(int[] arr, int x, int start, int end){

        if(end < start){
            return  0;
        }

        if( arr[start] > x){
            return  0;

        }

        if( arr[end] < x){
            return  0;

        }

        if(arr[start] == x  && arr[end] == x)
            return  end - start +1;

        int mid = (start + end )/2;

        if(arr[mid] == x){
            return  1 + getNumOccurances(arr, x, start, mid-1) +
                    getNumOccurances(arr, x, mid +1, end);
        } else if (arr[mid] > x) {
            // search on left
            return  getNumOccurances(arr, x, start, mid -1);
        }
        else{
            // search on left
            return  getNumOccurances(arr, x, mid +1, end);
        }
    }

    static int getFirstIndex(int[] arr, int x){
        return getFirstIndex(arr, x, 0, arr.length -1);
    }

    static int getFirstIndex(int[] arr, int x, int start, int end){

        if(end < start)
            return  -1;

        if( arr[start] > x){
            return  -1;
        }

        if( arr[end] < x){
            return  -1;
        }

        if(arr[start] == x  && arr[end] == x)
            return  start;

        int mid = (start + end )/2;

        if(arr[mid] == x){
            return  getFirstIndex(arr, x, start, mid);

        } else if (arr[mid] > x) {
            // search on left
            return  getFirstIndex(arr, x, start, mid -1);
        }
        else{
            // search on left
            return  getFirstIndex(arr, x, mid +1, end);
        }


    }

    static int findCeiling(int[] arr, int x){

        return  findCeiling(arr, x, 0, arr.length -1);

    }

    static int findCeiling(int[] arr, int x, int start, int end){

        if( arr[start] > x){
            return  arr[start];
        }

        if( arr[end] < x){
            return  Integer.MAX_VALUE;
        }


        //if(arr[start] == x  && arr[end] == x)
         //   return  x;
        int mid = (start + end )/2;

        if(arr[mid] == x){

            return  x;
        }else if(arr[mid] > x){
            return findCeiling(arr, x, start, mid);
        }else{
            return findCeiling(arr, x, mid +1, end);
        }
    }


    static int findMaxBittonic(int[] arr){

        return  findMaxBittonic(arr, 0, arr.length -1);
    }

    static int findMaxBittonic(int[] arr, int start, int end){

        int mid = (start + end)/2;

        if( (mid == 0 || arr[mid-1] <= arr[mid]) &&  mid == arr.length -1 || arr[mid +1] <= arr[mid] ){

            return mid;
        }
        else if( mid > 0  && arr[mid -1 ] > arr[mid]){
            return  findMaxBittonic(arr, start, mid -1);
        }else{
            return  findMaxBittonic(arr, mid +1, end);
        }
    }


    static boolean checkIfSumofTwoEqualsX(int[] arr, int x){

        Arrays.sort(arr);

        int start = 0 ;
        int end = arr.length -1;

        while(start < end){
            if(arr[start] + arr[end] == x){
                return  true;
            }
            else if(arr[start] + arr[end] < x){
                start++;
            }else{
                end--;
            }
        }
        return  false;
    }

    static boolean checkIfSumofTwoEqualsRest(int[] arr){

        int sum = 0;
        for(int i = 0 ; i < arr.length; i ++){
            sum += arr[i];
        }

        Arrays.sort(arr);

        int start = 0 ;
        int end = arr.length -1;

        while(start < end){
            if( (arr[start] + arr[end]) * 2 ==  sum ){
                return  true;
            }
            else if( (arr[start] + arr[end] ) * 2 < sum){
                start++;
            }else{
                end--;
            }
        }
        return  false;
    }


    static int findMajorityElement(int[] arr){
        int candidate = findCandidate(arr);
        int count = 0;

        for (int num: arr) {
            if(num == candidate){
                count ++;
            }
        }

        if(count >= arr.length/2){
            return  candidate;
        }
        return  Integer.MIN_VALUE;

    }




    static int findCandidate(int[] arr){

        int majorityElement = arr[0];
        int count = 0 ;

        for(int i = 0 ; i < arr.length; i ++){
            if(majorityElement == arr[i] ){
                count ++;
            }else{
                count --;
            }
            if(count == 0){
                majorityElement = arr[i];
                count = 1;
            }
        }
        return  majorityElement;
    }







    // endregion






    static void mergeIntervals(ArrayList<Interval> intervals){

        // sort intervals in increasing order of start



        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval x, Interval y) {
                if(x.start > y.start){
                    return  1;
                }else if (x.start < y.start){
                    return  -1;
                }
                else{
                    return  0;
                }
            }
        });

        Stack<Interval> stack = new Stack<Interval>();
        stack.push(intervals.get(0));

        for(int i = 1 ; i < intervals.size(); i ++){
            Interval top = stack.peek();

            if(top.end < intervals.get(i).start){
                stack.push(intervals.get(i));
            }
            else if (top.end  < intervals.get(i).end){
              top.end = intervals.get(i).end;
              stack.pop();
              stack.push(top);
            }

        }

        while(stack.size() >0 ){
            Interval val = stack.pop();
            System.out.println("[" + val.start + " , " + val.end + "]");
        }
        System.out.println("");
    }

    static int[] mergeSortedArrays(int[] arr1, int[] arr2){

        int[] merged = new int[arr1.length + arr2.length];

        int ptr1 = 0;
        int ptr2 = 0;
        int ptr3 = 0;

        while(ptr1 < arr1.length && ptr2 < arr2.length){
            if(arr1[ptr1] < arr2[ptr2]){
                merged[ptr3++] = arr1[ptr1++];

            }else{
                merged[ptr3++] = arr2[ptr2++];
            }
        }

        while(ptr1 < arr1.length){
            merged[ptr3++] = arr1[ptr1++];
        }
        while(ptr2 < arr2.length){
            merged[ptr3++] = arr2[ptr2++];
        }

        return  merged;

    }

    static int[] mergeSortedArraysKWay(ArrayList<int[]> listSortedArray){

        int[] merged  = {};
        for(int i = 1; i < listSortedArray.size(); i ++){
            if(i == 1){
                merged = mergeSortedArrays(listSortedArray.get(0), listSortedArray.get(i));
            }
            else{
                merged = mergeSortedArrays(merged, listSortedArray.get(i));
            }
        }

        return  merged;
    }


    static boolean subArrayWithSum(int[] arr, int sum){

        int currentSum  = 0;

        int start = 0;
        for(int i = 0 ; i < arr.length; i ++){
            while(currentSum > sum & start  < arr.length -1){
                currentSum = currentSum - arr[start];
                start++;
            }

            if(currentSum == sum){
                return  true;
            }
            currentSum += arr[i];
        }
        return  false;
    }
}
