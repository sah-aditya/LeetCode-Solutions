class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int e:nums){
            map.put(e,map.getOrDefault(e,0)+1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list,(a,b)->map.get(b)-map.get(a));

        int[] arr = new int[k];
        for(int i=0;i<list.size();i++){
            if(k>0){
              arr[i]=list.get(i);
            }
            k--;
        }
        return arr;
    }
}