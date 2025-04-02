class Solution {
    public double myPow(double x, int n) {
        if(n<0){
            x=1/x;
        }
        return solve(x,n);

    }

    public double solve(double x, int n){
        if(n==0){
            return 1;
        }

        if(n%2==0){
            double y=solve(x,n/2);
            return y*y;
        }

        else{
            double y=solve(x,n/2);
            return x*y*y;
        }
    }
}