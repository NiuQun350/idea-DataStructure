package cn.niuqun.queue;
import java.util.Stack;


/**
 * Stack类中的add()方法和push()方法的区别:
 * 最大的区别就是返回值不同,在作用上基本没有区别;
 * add()是实现List接口重写的方法,返回值为boolean.
 * Stack类中本身没有add()方法,但是继承的类vector中有add()方法;
 * push()方法返回值
 *    public E push(E item) {
 *         this.addElement(item);
 *         return item;
 *     }
 * 双向链表
 * @author NiuQun
 * @2019/11/17
 */

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        doubleLinkedList.list();
        System.out.println("##################");
        doubleLinkedList.listReverse1();
        System.out.println("*****************");
        doubleLinkedList.listReverse2();
    }


}

class DoubleLinkedList {
    HeroNode head;

    public DoubleLinkedList() {
        this.head = new HeroNode();
    }
    public DoubleLinkedList(HeroNode head) {
        this.head = head;
    }

    public void add(HeroNode newNode) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.pre = temp;
    }

    /**
     * 借用栈做到反向输出
     */
    public void listReverse1() {
        if (head.next == null) {
            System.out.println("双向链表为空!");
            return;
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode temp = head.next;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    /**
     * 用反向遍历的方法做到反向输出
     */
    public void listReverse2() {
        if (head.next == null) {
            System.out.println("双向链表为空!");
            return;
        }
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        while (temp.pre != null) {
            System.out.println(temp);
            temp = temp.pre;
        }
    }

    public void list() {
        HeroNode temp = head;
        if (temp.next == null) {
            System.out.println("链表为空！");
            return;
        }
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp);
        }
    }


}


class HeroNode {
    int number;
    String name;
    String nickName;
    HeroNode pre;
    HeroNode next;

    public HeroNode() {}
    public HeroNode(int number, String name, String nickName) {
        super();
        this.number = number;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode[" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ']';
    }
}