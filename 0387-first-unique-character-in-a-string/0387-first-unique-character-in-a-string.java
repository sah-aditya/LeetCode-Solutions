class Solution {
    public int firstUniqChar(String s) {
        int len=s.length();
        
        for(int i=0;i<len;i++){
            boolean flag=false; //informs it is repeating or not
            
            for(int j=0;j<len;j++){
                if(i!=j && s.charAt(i)==s.charAt(j)){
                    flag=true;
                    break;
                }
            }
            if(flag==false){
                return i;
            }
            
            
        }
        return -1;
        
    }
}