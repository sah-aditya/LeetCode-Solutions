class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x=0;
        String p1="++X";
        String p2="X++";
        
        for(int i=0;i<operations.length;i++){
            String a=operations[i];
            if(a.equalsIgnoreCase(p1) || a.equalsIgnoreCase(p2) ){
                x=x+1;
            }
            else{x=x-1; }

        }
        return x;
    }
}