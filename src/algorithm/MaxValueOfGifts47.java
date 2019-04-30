package algorithm;
//在一个m×n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于0）。
// 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格直到到达棋盘的右下角。
// 给定一个棋盘及其上面的礼物，请计算你最多能拿到多少价值的礼物？
public class MaxValueOfGifts47 {
    //使用动态规划，f(i,j)表示到达坐标[i,j]时能拿到的最大礼物总和。
    // 则当前格子f(i,j)可由左边格子f(i-1,j)或上面格子f(i,j-1)到达。因此，递归式子为：
    //f(i,j)=max(f(i−1,j),f(i,j−1))+gift[i,j]，
    //其中，gift[i,j]=坐标[i,j]格子里的礼物
    private static int getMaxPathValue(int[][] values){
        if (values == null)
            return 0;
        int rows = values.length;
        if (rows <= 0)
            return 0;
        int cols = values[0].length;
        if (cols <= 0)
            return 0;

        int[][] maxValues = new int[rows][cols];
        for (int i = 0; i < rows; ++i)
        {
            for (int j = 0; j < cols; ++j)
            {
                int fromLeft = 0; //左边
                int fromUp = 0; //上面

                if (i > 0)
                    fromUp = maxValues[i - 1][j];
                if (j > 0)
                    fromLeft = maxValues[i][j - 1];

                maxValues[i][j] = Math.max(fromLeft, fromUp) + values[i][j];
            }
        }
        return maxValues[rows - 1][cols - 1];
    }
    public static void main(String[] args) {
        int[][] values = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println(getMaxPathValue(values));  //29
    }
}
