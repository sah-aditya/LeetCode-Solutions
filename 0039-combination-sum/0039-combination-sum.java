class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int B) {
        Arrays.sort(arr);

        List<List< Integer>> res = new ArrayList<>();


        helper(0, arr, new ArrayList<>(), res, B);
        return res;
    }

    public static void helper(int index, int[] arr, List<Integer> curr,List<List< Integer>> res, int B ){
        if(B<0) return;

        if(B==0){
            res.add(new ArrayList<>(curr));
            return;
        }
        

        for(int i=index; i< arr.length; i++){
            curr.add(arr[i]);
            
            helper(i, arr, curr, res, B- arr[i]);

            curr.remove(curr.size()-1);
        }
    }
    
}