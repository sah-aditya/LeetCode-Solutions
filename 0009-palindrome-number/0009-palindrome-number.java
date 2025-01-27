class Solution {
    public boolean isPalindrome(int x) { 
        int num=x;
        int num1=x;
        if(num1<0){return false;}
        int rev=0;
        int digit;
        while(num!=0){
            digit=num%10;
            rev=rev*10+digit;
            num=num/10;
        }
        if(num1==rev){return true;}
        else {return false;}
        
    }
}