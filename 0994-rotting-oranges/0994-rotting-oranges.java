class Solution {
    public int orangesRotting(int[][] grid) {
        int row= grid.length;
        int col= grid[0].length;

        int fresh=0;
        Queue <int[]> q = new LinkedList<>();

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }

                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        if(fresh==0){ return 0;}

        int dir[][]={
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };

        int minutes=0;

        while(!q.isEmpty()){
            int size= q.size();

            boolean rottenThisMinute= false;

            for(int i=0;i<size;i++){
                int curr[]= q.poll();
                int r= curr[0];
                int c= curr[1];

                for(int d[]:dir){

                    int nr= r+d[0];
                    int nc= c+d[1];

                    if( nr>=0 &&nr<row &&nc>=0 &&nc<col&&grid[nr][nc]==1){
                            grid[nr][nc]=2;
                            fresh--;
                            q.offer(new int[]{nr,nc});

                            rottenThisMinute=true;
                        }
                }
            }

            if(rottenThisMinute){
                minutes++;
            }
        }

        if(fresh==0){
            return minutes;
        }
        else return -1;
    }
}