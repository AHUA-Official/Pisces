

class A332Solution {
    public static int change(int amount, int[] coins) {
        int len = coins.length;
        int[][] FN = new int[len + 1][amount + 1];
        FN[0][0] = 1;

        for (int i = 1; i <= len; i++) {
            FN[i][0] = 1; // 初始化基本情况




            for (int j = 1; j <= amount; j++) {
                FN[i][j] = FN[i - 1][j];
                for (int k = 1; k * coins[i-1] <= j; k++) {
                    FN[i][j] += FN[i - 1][j - k * coins[i-1]];
                }
            }
        }
        return FN[len][amount];
    }
    public static int change2(int amount, int[] coins) {
        int len = coins.length;
        int[][] FN = new int[len + 1][amount + 1];
        // 初始化基本情况
        for (int j = 1; j <= amount; j++) {
            FN[0][0]=1;
            FN[0][j] = (j == 0) ? 1 : 0;
        }
        for (int i = 1; i <= len; i++) {
            FN[i][0] = 1; }
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= amount; j++) {
                FN[i][j] = FN[i - 1][j];
                if (j - coins[i - 1] >= 0) {
                    FN[i][j] += FN[i][j - coins[i - 1]];
                }
            }
        }
        return FN[len][amount];
    }
    public static int change3(int cnt, int[] cs) {
        int n = cs.length;
        int[][] f = new int[n + 1][cnt + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int val = cs[i - 1];
            for (int j = 0; j <= cnt; j++) {
                f[i][j] = f[i - 1][j];
                for (int k = 1; k * val <= j; k++) {
                    f[i][j] += f[i - 1][j - k * val];
                }
            }
        }
        return f[n][cnt];
    }









    public static void main(String[] args) {
        int[] mm = {1,2};
        mm[0]=1;
       // mm[1]=2;
        System.out.println(change(500,mm));
        System.out.println(change2(500,mm));
        System.out.println(change3(500,mm));

    }

}