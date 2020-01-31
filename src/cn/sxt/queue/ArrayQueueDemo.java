package cn.sxt.queue;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.Arrays;

import java.util.Scanner;
/**
 * @author NiuQun
 * @2019/9/13
 * 从队列中取数据或者打印数据时，在返回值不为空的情况下，当队列为空，此时没有数据可取，无法返回值时，就需要抛出运行时异常
 */

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        // choice 用于接受用户输入
        char choice;
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while(flag) {
            System.out.println("s(save):存入数据");
            System.out.println("d(delete):删除数据");
            System.out.println("l(list):显示队列中所有数据");
            System.out.println("g(get):显示队列中第一个数据");
            System.out.println("e(exit):退出程序");

            choice = scanner.next().charAt(0);
            switch (choice) {
                case 's':
                    System.out.println("请输入一个整数:");
                    int value = scanner.nextInt();
                    arrayQueue.saveQueue(value);
                    break;
                case 'd':
                    try {
                        int result = arrayQueue.deleteQueue();
                        System.out.printf("删除的数据是：%d\n", result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'l':
                    arrayQueue.listQueue();
                    break;
                case 'g':
                    try {
                       int result = arrayQueue.getHeadQueue();
                        System.out.printf("队列头的数据是%d\n", result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    flag = false;
                    break;
                default:
                    System.out.println("输入错误，请重新输入：");
                    break;
            }
        }
        System.out.println("程序退出");
    }
}



/**
 * 使用数组模拟队列-编写一个ArrayQueue类
 */
class ArrayQueue {
    /**
     * front指向队列头的前一个位置，因此front指向的元素一定为空
     * rear指向队列尾的数据(即就是队列的最后一个数据)
     */
    private int arrMaxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int arrMaxSize) {
        this.arrMaxSize = arrMaxSize;
        arr = new int[arrMaxSize];
        front = -1;
        rear = -1;
    }


    /**
     * 判断队列是否为空
     * @return
     */

    public boolean isFull() {
        return rear == arrMaxSize - 1;
    }

    /**
     * 添加数据到队列
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    public void saveQueue(int data) {
        // 判断对列是否已满
        if(isFull()) {
            System.out.println("队列满,不能加入数据");
            return;
        }
        // 如果队列未满
        rear++;
        arr[rear] = data;
    }

    /**
     * 从队列中删除数据
     * @return
     */
    public int deleteQueue() {
        if(isEmpty()) {
            // 如果队列为空，则抛出异常
            throw new RuntimeException("队列为空,无数据可删除");
        }
        front++;
        int result = arr[front];
        arr[front] = 0;
        return result;
    }
    /**
     * 显示队列的所有数据
     */
    public void listQueue() {
        if(isEmpty()) {
            System.out.println("队列为空, 没有数据");
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    /**
     * 打印队列首数据
     * @return
     */
    public int getHeadQueue() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空, 没有数据");
        }
        return arr[front+1];
    }
}