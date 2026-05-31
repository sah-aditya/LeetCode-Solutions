class Solution {
    class PrimsPair{
            int v;
            int acq;
            int cost;
            public PrimsPair(int v,int acq,int cost){
                this.v=v;
                this.acq=acq;
                this.cost=cost;
            }
        }
    public int minCostConnectPoints(int[][] points) {
        HashMap<Integer,HashMap<Integer,Integer>> map=new HashMap<>();
        for(int i=0;i<points.length;i++){
            map.put(i,new HashMap<>());
        }
        for(int i=0;i<points.length;i++){
            for(int j=0;j<points.length;j++){
                if(i==j){
                    continue;
                }
                int cost=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                map.get(i).put(j,cost);
                map.get(j).put(i,cost);
            }
        }
        PriorityQueue<PrimsPair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        pq.add(new PrimsPair(0,0,0));
        HashSet<Integer> set=new HashSet<>();
        int sum=0;
        while(!pq.isEmpty()){
            PrimsPair pp=pq.poll();
            if(set.contains(pp.v)){
                continue;
            }
            set.add(pp.v);
            sum+=pp.cost;
            for(int nbrs:map.get(pp.v).keySet()){
                if(!set.contains(nbrs)){
                    int c=map.get(pp.v).get(nbrs);
                    pq.add(new PrimsPair(nbrs,pp.v,c));
                }
            }
        }
        return sum;
    }
}