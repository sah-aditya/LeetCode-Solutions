class Solution {
    public int search(int[] arr, int target) {
        int beg=0;
        int end=arr.length-1;
        while(beg<=end){
            int mid =(end+beg)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]>target){
                end=mid-1;
            }
            else{
                beg=mid+1;
            }
        }
        return -1;

        
    }
}