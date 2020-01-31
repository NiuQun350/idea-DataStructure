package cn.sxt.sparsearray;

/**
 * Arrays类的应用： Arrays.sort(一维数组);  Arrays.binarySearch(一维数组， key)
 * @author NiuQun
 */
public class Test {
    public static void main(String[] args) {
        byte[][] arr = new byte[10][10];
        for(byte i = 0; i < 10; i++) {
            for(byte j = 0; j < 10; j++) {
                if(i == j) {
                    arr[i][j] = 1;
                }
            }
        }

        for(byte[] row:arr) {
            for(byte data:row) {
                System.out.printf("%s\t", data);
            }
            System.out.println();
        }




    }

}


/*
1	0	0	0	0	0	0	0	0	1
0	1	0	0	0	0	0	0	1	0
0	0	1	0	0	0	0	1	0	0
0	0	0	1	0	0	0	0	1	0
0	0	0	0	1	0	0	0	0	1
0	0	0	0	0	1	0	0	0	0
2	2	0	0	0	0	1	0	0	0
0	0	2	0	0	0	0	1	0	0
2	2	0	0	0	0	0	0	1	0
0	0	0	0	0	0	0	0	0	1
 */