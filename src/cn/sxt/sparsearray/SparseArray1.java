package cn.sxt.sparsearray;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

public class SparseArray1 {
    private static final byte ROW = 10;    // ROW表示二维数组行数,即棋盘行数
    private static final byte COL = 10;    // COL表示二维数组列数,即棋盘列数
    private static byte sum = 0;           // sum记录二维数组有效数据的个数

    public static void main(String[] args) {
        System.out.println("请输入二维数组:");
        byte[][] chessArr1 = inputTwoDimensionalArray();
        System.out.println("打印原始二维数组:");
        outputArray(chessArr1);

        byte[][] sparseArr = changeToSparseArray(chessArr1);
        System.out.println("打印稀疏数组:");
        outputArray(sparseArr);

        byte[][] chessArr2 = changeToTwoDimensionalArray(sparseArr);
        System.out.println("打印转换后的二维数组:");
        outputArray(chessArr2);
    }

    public static void storageInfo() throws IOException {
        /**
         * 将稀疏数组保存到磁盘中
         */
        File file = new File("/home/NiuQun/workstation-1/practice/map.data");
        file.createNewFile();



    }
    public static byte[][] inputTwoDimensionalArray() {
        /**
         * 输入二维数组
         */
        Scanner scanner = new Scanner(System.in);
        byte[][] chessArr1 = new byte[ROW][COL];           // chessArr1为原始二维数组
        // 二维数组中：   0:表示没有棋子   1:表示黑子   2:表示白子
        for (byte i = 0; i < ROW; i++) {
            for (byte j = 0; j < COL; j++) {
                chessArr1[i][j] = scanner.nextByte();
                if (chessArr1[i][j] == 1 | chessArr1[i][j] == 2) {
                    sum++;
                }
            }
        }
        System.out.println();
        return chessArr1;
     }

     public static void outputArray(byte[][] temp) {
         /**
          * 打印二维数组
          */
         for (byte[] temp1 : temp) {
             System.out.println(Arrays.toString(temp1));
         }
     }

     public static byte[][] changeToSparseArray(byte[][] chessArr1) {
         /**
          * 将二维数组转换成稀疏数组
          */
         byte[][] sparseArr = new byte[sum + 1][3];          // spareArr为稀疏数组
         sparseArr[0][0] = ROW;
         sparseArr[0][1] = COL;
         sparseArr[0][2] = sum;

         // 遍历二维数组,将非0值存入到稀疏数组中
         byte count = 1;  // count用于记录是第几个有效数字
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
         return sparseArr;
     }

    public static byte[][] changeToTwoDimensionalArray(byte sparseArr[][]) {
        /**
         * 将稀疏数组转换成二维数组
         */
         byte row = sparseArr[0][0];
         byte col = sparseArr[0][1];
         byte[][] chessArr2 = new byte[row][col];

         for (byte i = 1; i < sparseArr.length; i++) {
             byte row1 = sparseArr[i][0];
             byte col1 = sparseArr[i][1];
             chessArr2[row1][col1] = sparseArr[i][2];
         }
        return chessArr2;
    }
}

