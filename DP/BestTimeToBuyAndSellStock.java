import java.util.Arrays;

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int stocks[]) {
        int n=stocks.length;
        int minPrice = stocks[0], profit=0;
        for(int i=1; i<n; i++) {
            int cost = stocks[i] - minPrice;
            profit = Math.max(profit, cost);
            minPrice = Math.min(stocks[i], minPrice);
        }
        return profit;
    }

    // Best Time To Buy And Sell Stock ||
    public static int maxProfit2(int stocks[], int idx, boolean buy) { // initial buy = true for first time need to buy and after that need to sell
        if(idx==stocks.length) return 0;
        int profit = 0;
        if(buy) {
            int pick = -stocks[idx] + maxProfit2(stocks, idx+1, false);
            int nonPick = maxProfit2(stocks, idx+1, true);
            profit = Math.max(pick, nonPick);
        } else {
            int pick = stocks[idx] + maxProfit2(stocks, idx+1, true);
            int nonPick = maxProfit2(stocks, idx+1, false);
            profit = Math.max(pick, nonPick);
        }
        return profit;
    }

    public static int maxProfit2(int stocks[], int idx, boolean buy, int dp[][]) { // initial buy = true for first time need to buy and after that need to sell
        if(idx==stocks.length) return 0;
        if(dp[idx][buy ? 1 : 0]!=-1) return dp[idx][buy ? 1 : 0];
        int profit = 0;
        if(buy) {
            int pick = -stocks[idx] + maxProfit2(stocks, idx+1, false);
            int nonPick = maxProfit2(stocks, idx+1, true);
            profit = Math.max(pick, nonPick);
        } else {
            int pick = stocks[idx] + maxProfit2(stocks, idx+1, true);
            int nonPick = maxProfit2(stocks, idx+1, false);
            profit = Math.max(pick, nonPick);
        }
        return dp[idx][buy ? 1 : 0] = profit;
    }

    public static int maxProfit2(int stocks[]) { // initial buy = true for first time need to buy and after that need to sell
        int n=stocks.length;
        int dp[][] = new int[n+1][2];
        dp[n][0] = dp[n][1] = 0;
        for(int i=n-1; i>=0; i--) {
            for(int buy=0; buy<=1; buy++) {
                int profit = 0;
                if(buy==1) {
                    int pick = -stocks[i] + dp[i+1][0];
                    int nonPick = dp[i+1][1];
                    profit = Math.max(pick, nonPick);
                } else {
                    int pick = stocks[i] + dp[i+1][1];
                    int nonPick = dp[i+1][0];
                    profit = Math.max(pick, nonPick);
                }
                dp[i][buy] = profit;
            }
        }
        return dp[0][1];
    }

    public static int maxProfit2SOpt(int stocks[]) { // initial buy = true for first time need to buy and after that need to sell
        int n=stocks.length;
        // int dp[][] = new int[n+1][2];
        int curr[] = new int[2], ahead[] = new int[2];
        ahead[0] = ahead[1] = 0;
        for(int i=n-1; i>=0; i--) {
            for(int buy=0; buy<=1; buy++) {
                int profit = 0;
                if(buy==1) {
                    int pick = -stocks[i] + ahead[0];
                    int nonPick = ahead[1];
                    profit = Math.max(pick, nonPick);
                } else {
                    int pick = stocks[i] + ahead[1];
                    int nonPick = ahead[0];
                    profit = Math.max(pick, nonPick);
                }
                curr[buy] = profit;
            }
            ahead = curr;
        }
        return ahead[1];
    }

    // Best Time To Buy And Sell Stock |||
    public static int maxProfit3(int stocks[], int ind, int buy, int cap) {
        if(ind==stocks.length || cap==0) return 0;
        int profit = 0;
        if(buy==1) {
            int pick = -stocks[ind] + maxProfit3(stocks, ind+1, 0, cap);
            int nonPick = maxProfit3(stocks, ind+1, 1, cap);
            profit = Math.max(pick, nonPick);
        } else {
            int pick = stocks[ind] + maxProfit3(stocks, ind+1, 1, cap-1);
            int nonPick = maxProfit3(stocks, ind+1, 0, cap);
            profit = Math.max(pick, nonPick);
        }
        return profit;
    }

    public static int maxProfit3(int stocks[], int ind, int buy, int cap, int dp[][][]) {
        if(ind==stocks.length || cap==0) return 0;
        if(dp[ind][buy][cap]!=-1) return dp[ind][buy][cap];
        int profit = 0;
        if(buy==1) {
            int pick = -stocks[ind] + maxProfit3(stocks, ind+1, 0, cap, dp);
            int nonPick = maxProfit3(stocks, ind+1, 1, cap, dp);
            profit = Math.max(pick, nonPick);
        } else {
            int pick = stocks[ind] + maxProfit3(stocks, ind+1, 1, cap-1, dp);
            int nonPick = maxProfit3(stocks, ind+1, 0, cap, dp);
            profit = Math.max(pick, nonPick);
        }
        return dp[ind][buy][cap] = profit;
    }

    public static int maxProfit3(int stocks[], int cap) {
        int dp[][][] = new int[stocks.length+1][2][cap+1];
        for(int i=0; i<stocks.length; i++) {
            for(int j=0; j<=1; j++) {
                dp[i][j][0]=0;
            }
        }
        for(int i=0; i<=1; i++) {
            for(int j=0; j<=cap; j++) {
                dp[stocks.length][i][j] = 0;
            }
        }
        for(int i=stocks.length-1; i>=0; i--) {
            for(int j=0; j<=1; j++) {
                for(int k=1; k<=cap; k++) {
                    int profit = 0;
                    if(j==1) {
                        int pick = -stocks[i] + dp[i+1][0][k];
                        int nonPick = dp[i+1][1][k];
                        profit = Math.max(pick, nonPick);
                    } else {
                        int pick = stocks[i] + dp[i+1][1][k-1];
                        int nonPick = dp[i+1][0][k];
                        profit = Math.max(pick, nonPick);
                    }
                    dp[i][j][k] = profit;
                }
            }
        }
        return dp[0][1][cap];
    }

    public static int maxProfit3SP(int stocks[], int cap) {
        int[][] curr = new int[2][cap+1], after = new int[2][cap+1];
        for(int i=0; i<stocks.length; i++) { // just for understanding
            for(int j=0; j<=1; j++) {
                after[j][0]=0;
            }
        }
        for(int i=0; i<=1; i++) {
            for(int j=0; j<=cap; j++) {
                after[i][j] = 0;
            }
        }
        for(int i=stocks.length-1; i>=0; i--) {
            for(int j=0; j<=1; j++) {
                for(int k=1; k<=cap; k++) {
                    int profit = 0;
                    if(j==1) {
                        int pick = -stocks[i] + after[0][k];
                        int nonPick = after[1][k];
                        profit = Math.max(pick, nonPick);
                    } else {
                        int pick = stocks[i] + after[1][k-1];
                        int nonPick = after[0][k];
                        profit = Math.max(pick, nonPick);
                    }
                    curr[j][k] = profit;
                }
            }
            after = curr;
        }
        return curr[1][cap];
    }

    // Best Time To Buy And Sell Stock V
    public static int maxProfit5(int stocks[], int idx, boolean buy) { // initial buy = true for first time need to buy and after that need to sell
        if(idx>=stocks.length) return 0;
        int profit = 0;
        if(buy) {
            int pick = -stocks[idx] + maxProfit5(stocks, idx+1, false);
            int nonPick = maxProfit5(stocks, idx+1, true);
            profit = Math.max(pick, nonPick);
        } else {
            int pick = stocks[idx] + maxProfit5(stocks, idx+2, true);
            int nonPick = maxProfit5(stocks, idx+1, false);
            profit = Math.max(pick, nonPick);
        }
        return profit;
    }

    public static int maxProfit5(int stocks[], int idx, boolean buy, int[][] dp) { // initial buy = true for first time need to buy and after that need to sell
        if(idx>=stocks.length) return 0;
        if(dp[idx][buy ? 1 : 0] != -1) return dp[idx][buy ? 1 : 0];
        int profit = 0;
        if(buy) {
            int pick = -stocks[idx] + maxProfit5(stocks, idx+1, false, dp);
            int nonPick = maxProfit5(stocks, idx+1, true, dp);
            profit = Math.max(pick, nonPick);
        } else {
            int pick = stocks[idx] + maxProfit5(stocks, idx+2, true, dp);
            int nonPick = maxProfit5(stocks, idx+1, false, dp);
            profit = Math.max(pick, nonPick);
        }
        return dp[idx][buy ? 1 : 0] = profit;
    }

    public static int maxProfit5(int stocks[]) { // initial buy = true for first time need to buy and after that need to sell
        int n=stocks.length;
        int dp[][] = new int[n+2][2];
        dp[n][0] = dp[n][1] = 0;
        for(int i=n-1; i>=0; i--) {
            for(int buy=0; buy<=1; buy++) {
                int profit = 0;
                if(buy==1) {
                    int pick = -stocks[i] + dp[i+1][0];
                    int nonPick = dp[i+1][1];
                    profit = Math.max(pick, nonPick);
                } else {
                    int pick = stocks[i] + dp[i+2][1];
                    int nonPick = dp[i+1][0];
                    profit = Math.max(pick, nonPick);
                }
                dp[i][buy] = profit;
            }
        }
        return dp[0][1];
    }

    public static int maxProfit5SOpt(int stocks[]) { // initial buy = true for first time need to buy and after that need to sell
        int n=stocks.length;
        // int dp[][] = new int[n+1][2];
        int ahead[] = new int[2], aheadsAhead[] = new int[2];
        ahead[0] = ahead[1] = 0;
        for(int i=n-1; i>=0; i--) {
            int curr[] = new int[2];
            for(int buy=0; buy<=1; buy++) {
                int profit = 0;
                if(buy==1) {
                    int pick = -stocks[i] + ahead[0];
                    int nonPick = ahead[1];
                    profit = Math.max(pick, nonPick);
                } else {
                    int pick = stocks[i] + aheadsAhead[1];
                    int nonPick = ahead[0];
                    profit = Math.max(pick, nonPick);
                }
                curr[buy] = profit;
            }
            aheadsAhead = ahead;
            ahead = curr;
        }
        return ahead[1];
    }

    // Best Time To Buy And Sell Stock V|
    public static int maxProfit6(int stocks[], int idx, boolean buy, int fee) { // initial buy = true for first time need to buy and after that need to sell
        if(idx==stocks.length) return 0;
        int profit = 0;
        if(buy) {
            int pick = -stocks[idx] - fee + maxProfit6(stocks, idx+1, false, fee);
            int nonPick = maxProfit6(stocks, idx+1, true, fee);
            profit = Math.max(pick, nonPick);
        } else {
            int pick = stocks[idx] + maxProfit6(stocks, idx+1, true, fee);
            int nonPick = maxProfit6(stocks, idx+1, false, fee);
            profit = Math.max(pick, nonPick);
        }
        return profit;
    }

    public static void main(String[] args) {
        // int stacks[] = {7, 1, 4, 5, 3, 6};
        int stacks[] = {1, 3, 2, 8, 4, 9};
        // System.out.println(maxProfit(stacks));
        // System.out.println(maxProfit2(stacks, 0, true)); // recusrion
        int[][] dp = new int[stacks.length][2];
        for(int i[]: dp) Arrays.fill(i, -1);
        // System.out.println(maxProfit2(stacks, 0, true, dp)); // memoization
        // System.out.println(maxProfit2(stacks)); // tabulation
        // System.out.println(maxProfit2SOpt(stacks)); // space optimization
        // System.out.println(maxProfit3(stacks, 0, 1, 2));
        // int dp2[][][] = new int[stacks.length][2][3];
        // for(int i[][]: dp2) {
        //     for(int j[]: i) {
        //         Arrays.fill(j, -1);
        //     }
        // }
        // System.out.println(maxProfit3(stacks, 0, 1, 2, dp2));
        // System.out.println(maxProfit3(stacks, 1));
        // System.out.println(maxProfit3SP(stacks, 0));

        // System.out.println(maxProfit5(stacks, 0, true));
        // for(int i[]: dp) Arrays.fill(i, -1);
        // System.out.println(maxProfit5(stacks, 0, true, dp));
        // System.out.println(maxProfit5(stacks));
        // System.out.println(maxProfit5SOpt(stacks));
        System.out.println(maxProfit6(stacks, 0, true, 2));
    }  
}
