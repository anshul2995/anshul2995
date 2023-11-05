class abc08062022 {
    public static void main(String[] args) {
        
        int arr[] = {-2,-3,4,-1,-2,1,5,-3};

        int currentTrainSum = arr[0];
        int overallTrainSum = arr[0];

        for (int i = 1; i < arr.length; i++){

            if(currentTrainSum >= 0)   //agar piche se positive train aa rhi hai toh, usi train mai add ho jayo
                currentTrainSum += arr[i];
            else
                currentTrainSum = arr[i];     //agar piche se negative train aa rhi hai toh, toh apni nayi train bana lo.

            if (currentTrainSum > overallTrainSum)  //agar currentTrainSum ka sum overallbestTrainSum se better ho gya hai toh
                                                        // overallBestTrainSum ko currentTrainSum se update krdo.
                overallTrainSum = currentTrainSum;
        }
        System.out.println("Max subarray sum:"+ overallTrainSum);
    }
}