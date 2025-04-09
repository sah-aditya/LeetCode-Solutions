class Solution {
    public boolean isLess(int[]arr,int mid,int t){
        int sum = 0;
        for(int ele : arr){
            if(ele % mid == 0)sum += ele/mid;
            else{
               sum+= (ele/mid) + 1; 
            }
        }
        if(sum <= t)return true;
        return false;
        
    }
    public int smallestDivisor(int[] arr, int threshold) {
        int mx= Integer.MIN_VALUE;
        for(int i = 0;i < arr.length;i++){
             mx = Math.max(mx,arr[i]);
        }
        int low = 1 , high = mx,d = 1;
        while(low <= high){
            int mid = low +(high-low)/2;
            if(isLess(arr,mid,threshold)){
                d = mid;
                high = mid - 1;
            }
            else{
                low = mid +1;
            }
        }
        return d;
    }
}