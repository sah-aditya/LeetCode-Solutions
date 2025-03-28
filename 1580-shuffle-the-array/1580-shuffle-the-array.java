class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] arr= new int[n*2];
        int k=0;
        for(int i=0;i<n;i++){
            arr[k]=nums[i];
            k=k+2;
        }
        k=1;
        for(int i=n;i<n*2;i++){
            arr[k]=nums[i];
            k=k+2;
        }
        return arr;
    }
}