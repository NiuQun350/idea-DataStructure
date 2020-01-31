package cn.sxt.sparsearray;

/**
 * 稀疏数组
 * 索引    row    col        val
 *  0     总行    总列    有效数据个数
 *  1      行      列     有效数据1
 *  2      行      列     有效数据2
 *  3      行      列     有效数据3
 *  4      行      列     有效数据4
 *  .......
 *  n      行      列     有效数据n
 *
 *  二维数组转稀疏数组:
 *  1.遍历二维数组，得到有效数据的个数sum
 *  2.根据sum就可以创建稀疏数组sparseArr int[sum+1][3]
 *  3.将二维数组的有效数据存入到稀疏数组
 *
 *  稀疏数组转原始的二维数组:
 *  1.先读取稀疏数组的第一行，根据第一行的数据创建原始的二维数组，
 *  2.再读取稀疏数组后几行的数据，并赋值非原始的二维数组
 *
 *
 */

import java.util.Arrays;
import java.util.Scanner;
/**
 * @author NiuQun
 */
public class SparseArray {

    private static final byte ROW = 10;
    /**
     * ROW表示二维数组行数
     */
    /**
     *COL表示二维数组列数
     */

    private static final byte COL = 10;
    public static void main(String[] args) {
        // 二维数组中 0:表示没有棋子   1:表示黑子   2:表示白子
        byte sum = 0;
        /**
         *sum记录有效数据的个数
         */

        Scanner scanner = new Scanner(System.in);
        // chessArr1为原始二维数组
        byte[][] chessArr1 = new byte[ROW][COL];
        System.out.println("请输入原始二维数组:");
        for (byte i = 0; i < ROW; i++) {
            for (byte j = 0; j < COL; j++) {
                chessArr1[i][j] = scanner.nextByte();
                if (chessArr1[i][j] == 1 | chessArr1[i][j] == 2) {
                    sum++;
                }
            }
        }
        System.out.println("**********************************");
        // 打印原始二维数组
        System.out.println("原始二维数组：");
        for (byte[] row : chessArr1) {
            System.out.println(Arrays.toString(row));
        }

        // spareArr为稀疏数组
        byte[][] sparseArr = new byte[sum + 1][3];
        sparseArr[0][0] = ROW;
        sparseArr[0][1] = COL;
        sparseArr[0][2] = sum;

        // 遍历二维数组,将非0值存入到稀疏数组中
        // count用于记录是第几个有效数字
        byte count = 1;
        for (byte i = 0; i < ROW; i++) {
            for (byte j = 0; j < COL; j++) {
                if (chessArr1[i][j] != 0) {
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                    count++;
                }
            }
        }
        System.out.println("**************************");
        // 打印稀疏数组
        System.out.println("打印稀疏数组：");
        for (byte[] row : sparseArr) {
            System.out.println(Arrays.toString(row));
        }

        // 将稀疏数组转换成二维数组
        byte row = sparseArr[0][0];
        byte col = sparseArr[0][1];
        byte[][] chessArr2 = new byte[row][col];

        for (byte i = 1; i < sparseArr.length; i++) {
            byte row1 = sparseArr[i][0];
            byte col1 = sparseArr[i][1];
            chessArr2[row1][col1] = sparseArr[i][2];
        }

        // 打印二维数组
        System.out.println("打印新的二维数组:");
        for(byte[] row2:chessArr2) {
            System.out.println(Arrays.toString(row2));
        }
    }
}
