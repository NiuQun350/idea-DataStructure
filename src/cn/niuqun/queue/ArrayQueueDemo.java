package cn.niuqun.queue;

/**
 * @author NiuQun
 * @2019/10/21
 */

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue(5);
        for (int i = 0; i < 3; i++) {
            aq.addQueue(i);
        }
        aq.showQueue();

    }
}

/**
 * 顺序栈类
 */
class ArrayQueue {
    /**
     * maxSize 队列长度
     * front 指向队列头的前一个位置
     * rear  指向队列尾
     * arr  数组用于存放数据
     */
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize) {
        super();
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int value) {
        if (isFull()) {
            System.out.println("队列满，不能加入数据！");
            return;
        }
        rear++;
        arr[rear] = value;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取出数据！");
        }
        front++;
        return arr[front];
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据！");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }








}