class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list= new ArrayList<>();
        List<Integer> ll =new ArrayList<>();
        SubSet(nums, 0, list,ll);
        return list;
    }

    public static void SubSet(int nums[],int i, List<List<Integer>> list, List<Integer> ll){
        if(i==nums.length){
            list.add(ll);
            return;
        }
        int ele = nums[i];
        SubSet(nums,i+1,list,new ArrayList<>(ll));
        ll.add(ele);
        SubSet(nums,i+1,list,new ArrayList<>(ll));
    }

}