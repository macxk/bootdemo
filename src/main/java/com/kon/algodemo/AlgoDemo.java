package com.kon.algodemo;


import com.google.gson.Gson;

public class AlgoDemo {

    public static void sortBubble(){
        Integer[] nums = new Integer[]{1,2,4,6,3,5};
        Integer temp = new Integer(0);

        for(int j=0;j<nums.length;j++){
            for(int i=0;i<nums.length-1;i++){
                if(nums[i]>nums[i+1]){
                    temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                }
            }
        }

        System.out.print(new Gson().toJson(nums));
    }

    public static void main(String[] args) {
        sortBubble();
    }
}
