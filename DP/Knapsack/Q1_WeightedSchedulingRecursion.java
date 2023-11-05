package DP.Knapsack;

import java.util.Arrays;

public class Q1_WeightedSchedulingRecursion {

    public static void main(String[] args) {
        // int m = 4;
        // Job arr[] = new Job[m];
        // arr[0] = new Job(1, 2, 50); 
        // arr[1] = new Job(3, 5, 20);
        // arr[2] = new Job(6, 19, 100);
        // arr[3] = new Job(2, 100, 200);

        int m = 6;
        Job arr[] = new Job[m];
        
        arr[0] = new Job(0,6,60);
        arr[1] = new Job(1,4,30);
        arr[2] = new Job(3,5,10);
        arr[3] = new Job(5,7,30);
        arr[4] = new Job(5,9,50);
        arr[5] = new Job(7,8,10);

        int n =arr.length;

        Arrays.sort(arr, (Job j1, Job j2) -> Integer.compare(j1.end, j2.end));

        System.out.println(maxProfitJob(arr, n-1));
    }

    public static int maxProfitJob(Job[] arr, int index) {
        if (index < 0)
            return 0;
        if (index == 0) {
            return arr[0].profit;
        }

        int lastConflictingIndex = findLastConflictingIndex(arr, index);
        int include = arr[index].profit + maxProfitJob(arr, lastConflictingIndex);

        int exclude = maxProfitJob(arr, index-1);

        return Math.max(include, exclude);
    }

    public static int findLastConflictingIndex(Job[] arr, int index){
        for (int i = index - 1; i >= 0 ; i--){
            if (arr[i].end <= arr[index].start) {
                return i;
            }
        }
        return -1;
    }
}

class Job{
    int start;
    int end;
    int profit;

    Job(int start, int end, int profit){
        this.end = end;
        this.start = start;
        this.profit = profit;
    }
}

/**
 * 
 * Sources: 
 * https://www.educative.io/answers/what-is-weighted-job-scheduling-in-dynamic-programming
 * https://www.geeksforgeeks.org/weighted-job-scheduling/
 * 
 */