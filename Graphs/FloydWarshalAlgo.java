public class FloydWarshalAlgo {
    public void shortestDistance(int[][] matrix){
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]==-1) matrix[i][j] = (int)(1e9);
                if(i==j) matrix[i][j] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = Math.min(matrix[j][k],matrix[j][i]+matrix[i][k]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]==(int)(1e9)){
                    matrix[i][j]=-1;
                }
            }
        }
    }
}
