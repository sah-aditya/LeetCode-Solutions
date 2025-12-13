public class Solution {
    int m, n;
    
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int orangesRotting(int[][] matrix) {
        m = matrix.length;
        if (m == 0) return 0;
        n = matrix[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                } else if (matrix[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        
        if (freshOranges == 0) return 0;
        
        int minutes = 0;
        
        while (!queue.isEmpty() && freshOranges > 0) {
            
            minutes++;
            
            int size = queue.size();
            
            for (int k = 0; k < size; k++) {
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];
                
                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && matrix[nr][nc] == 1) {
                        
                        matrix[nr][nc] = 2; 
                        
                        queue.offer(new int[] {nr, nc});
                        
                        freshOranges--;
                    }
                }
            }
        }
        
        return freshOranges == 0 ? minutes : -1;
    }
}

