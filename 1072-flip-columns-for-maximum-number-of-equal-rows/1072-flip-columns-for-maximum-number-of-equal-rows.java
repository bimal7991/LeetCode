class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
         Map<String, Integer> map = new HashMap<String, Integer>();
        int max = 0;
        for(int i=0; i<matrix.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=1; j<matrix[0].length; j++) {
                if(matrix[i][j] == matrix[i][0]) {
                    sb.append('a');
                } else {
                    sb.append('b');
                }
            }
            String s = sb.toString();
            map.put(s, map.getOrDefault(s, 0) + 1);
            max = Math.max(max, map.get(s));
        }
        
        return max;
    }
}