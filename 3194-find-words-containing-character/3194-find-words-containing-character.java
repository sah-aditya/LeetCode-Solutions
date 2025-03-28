class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list= new ArrayList<>();
        for(int i=0;i<words.length;i++){
            String a=words[i];
            int l=a.length();
            for(int j=0;j<l;j++){
                if(a.charAt(j)==x){
                    list.add(i);
                    break;
                }
            }
        }
        return list;
    }
}