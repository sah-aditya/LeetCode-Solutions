class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldcolor= image[sr][sc];

        if(oldcolor==color){
            return image;
        }

        dfs(image, sr, sc, oldcolor, color);
        
        return image;
    }

    void dfs(int[][] image, int r, int c, int oldcolor, int newcolor){

        if(r<0 || r>= image.length || c<0 || c>= image[0].length || image[r][c] != oldcolor ){
            return;
        }

        image[r][c]= newcolor;

        dfs(image, r+1, c, oldcolor, newcolor);
        dfs(image, r, c+1, oldcolor, newcolor);
        dfs(image, r-1, c, oldcolor, newcolor);
        dfs(image, r, c-1, oldcolor, newcolor);
    }
}