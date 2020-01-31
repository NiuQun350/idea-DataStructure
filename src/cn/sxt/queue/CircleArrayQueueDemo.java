package cn.sxt.queue;

/**
 * @author NiuQun
 * @2019/9/14
 */

public class CircleArrayQueueDemo {
    public static void main(String[] args) {

    }
}

/**
 * 环形队列类
 */
class CircleQueue {
    /**
     * front指向队列首元素
     * 从循环队列中删除数据时,对front的赋值是采用取模方式,因此front的值并不是一直在增长的,
     */
    private int front;
    /**
     * rear指向队列尾的后一个元素， 因此rear指向的元素一定为空
     * 向循环队列添加数据时，对rear的赋值是采用取模方法,因此rear值并不是在一直增长的
     */
    private int rear;
    private int arrMaxSize;
    private int[] arrCircleQueue;

    /**
     * 构造方法
     * @param arrMaxSize
     */
    public CircleQueue(int arrMaxSize) {
        this.arrMaxSize = arrMaxSize;
        front = 0;
        rear = 0;
        arrCircleQueue = new int[arrMaxSize];
    }

    /**
     * 判断队列是否已满
     */
    public boolean isFull() {
        return (rear + 1) % arrMaxSize == front;
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 向循环队列中添加数据
     */
    public void saveCircleQueue(int data) {
        if (isFull()) {
            System.out.println("环形队列已满，无法再加入数据");
            return;
        }
        arrCircleQueue[rear] = data;
        rear = (rear + 1) % arrMaxSize;
    }

    /**
     * 从循环队列中删除数据
     */
    public int deleteCircleQueue() {
        if(isEmpty()) {
            throw new RuntimeException("环形队列为空，无法取数据");
        }
        int result = arrCircleQueue[front];
        arrCircleQueue[front] = 0;
        front = (front + 1) % arrMaxSize;
        return result;
    }

    /**
     * 计算循环队列中有效数据个数
     * @return
     */
    public int validDataSize() {
        return (front - rear + arrMaxSize) % arrMaxSize;
    }
    /**
     * 显示循环队列所有数据
     */
    public void listCircleQueue() {
        if(isEmpty()) {
            System.out.println("循环队列为空");
            return;
        }
        for (int i = front; i < front + validDataSize(); i++) {
            System.out.printf("arr[%d]=%d\n", i % arrMaxSize, arrCircleQueue[i % arrMaxSize]);
        }
    }
    /**
     * 显示头元素
     */
    public int getHeadCircleQueue(){
        if(isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arrCircleQueue[front];
    }
}


