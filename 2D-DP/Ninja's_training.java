/*
A ninja has planned a n-day training schedule. Each day he has to perform one of three activities - running, stealth training, or fighting practice. The same activity cannot be done on two consecutive days and the ninja earns a specific number of merit points, based on the activity and the given day.



Given a n x 3-sized matrix, where matrix[i][0], matrix[i][1], and matrix[i][2], represent the merit points associated with running, stealth and fighting practice, on the (i+1)th day respectively. Return the maximum possible merit points that the ninja can earn.
*/


class Solution {
    public int ninjaTraining(int[][] matrix) {
        int length=matrix.length;
        int[][]dp = new int[length][3];
        dp[0][0] = matrix[0][0];
        dp[0][1] = matrix[0][1];
        dp[0][2] = matrix[0][2];
        for(int i=1;i<length;i++){
             dp[i][0] = Math.max(dp[i-1][1], dp[i-1][2]) + matrix[i][0];
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2]) + matrix[i][1];
            dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1]) + matrix[i][2];
        }
        return Math.max(dp[length-1][0],Math.max(dp[length-1][1],dp[length-1][2]));
    }
}