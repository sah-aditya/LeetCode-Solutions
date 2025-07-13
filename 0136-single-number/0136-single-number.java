class Solution {
    public int singleNumber(int[] nums) {
        int ele=nums[0];
        for(int i=0;i<nums.length;i++){
             ele= nums[i];
            int count=0;
            for(int j=0;j<nums.length;j++){
                if(nums[j]==ele){
                    count++;
                }
            }

            if(count==1){
                return ele;
            }
            

        }
        return ele;
    }
}