package cn.sxt.queue;


import java.util.Stack;

/**
 * @author NiuQun
 * @2019/11/15
 */

public class SingleLinkedListDemo {
    public static void main(String[] args) {

        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        // 创建一个单链表

        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        singleLinkedList1.addByOrder(hero1);
        singleLinkedList1.addByOrder(hero2);
        singleLinkedList1.addByOrder(hero3);
        singleLinkedList1.addByOrder(hero4);
        singleLinkedList1.list();
        System.out.println();

        System.out.println("调用reverse1");
        singleLinkedList1.reverse1();
        singleLinkedList1.list();

        System.out.println("调用reverse2");
        singleLinkedList1.reverse2();
        singleLinkedList1.list();

    }
}

class SingleLinkedList {
    /**
     *  先初始化一个头结点，头结点中不存放具体数据
     */
    private HeroNode head = new HeroNode(0, "", "");
    public SingleLinkedList() {}
    public SingleLinkedList(HeroNode head) {
        this.head = head;
    }

    /**
     * 单链表反转,使用stack
     * @return
     */
    public void reverse2() {
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode temp1 = head.next;
        HeroNode reverseHead = new HeroNode();
        HeroNode newNode = null;
        HeroNode temp = reverseHead;

        Stack<HeroNode> stack = new Stack<HeroNode>();
        while (temp1 != null) {
            stack.push(temp);
            temp = temp1.next;
        }
        while (!stack.isEmpty()) {
            newNode = stack.pop();
            temp.next = newNode;
            newNode.next = null;
            temp = newNode;
        }
        head = reverseHead;
       return;
    }
    /**
     * 单向链表反转,尾插法的使用
     */
    public void reverse1() {
        HeroNode temp = head.next;
        if (temp == null) {
            return;
        }
        HeroNode reverseHead = new HeroNode();
        HeroNode nextNode = null;
        while (temp != null) {
            nextNode = temp.next;
            temp.next = reverseHead.next;
            reverseHead.next = temp;
            temp = nextNode;
        }
        head = reverseHead;
        return;
    }

    /**
     * 该添加方式在添加英雄时，根据排名将英雄插入到指定的位置
     * 如果有这个排名，则添加失败，并给出提示
     * 因为头结点不能动，因此我们仍然通过一个辅助指针变量来帮助我们找到添加的位置
     * 因为是单链表，因此我们找到的temp是位于添加位置的前一个节点，否则加入不了
     */
    public void addByOrder(HeroNode newNode) {
        HeroNode temp = head;
        // flag用于标识添加的编号是否存在,默认为false
        boolean flag = false;
        while (true) {
            // 说明temp在链表的最后
            if (temp.next == null) {
                break;
            }
            // 当位置已经找到时,说明newNode应该添加到temp和temp.next之间
            if (temp.next.number > newNode.number) {
                break;
                // 当希望添加的newNode的编号已经存在
            } else if (temp.next.number == newNode.number) {
                flag = true;
                break;
            }
            temp =temp.next;
        }

        if (flag == true) {
            System.out.println("待插入的英雄编号" + newNode.number + "存在,不能添加");
        } else {
            newNode.next = temp.next;
            temp.next = newNode;

        }

    }

    /**
     * 当不考虑编号的顺序时
     * 1.找到当前链表的最后节点
     * 2.将最后这个节点的next指向新的节点
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        // 因为head节点不能动,因此我们需要一个辅助指针遍历temp
        HeroNode temp = head;
        // 遍历链表
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;

        }
        temp.next = heroNode;
        return;
    }

    /**
     * 显示链表
     */
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            // 判断是否到链表末尾
            if (temp == null) {
                break;
            }
            // 输出节点的信息
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

}


/**
 *  定义一个HeroNode类，每个HeroNode对象就是一个节点
 */
class HeroNode {
    /**
     * number为英雄的排序号
     */
    public int number;
    /**
     * name为英雄的名字
     */
    public String name;
    /**
     * nickName为英雄的昵称
     */
    public String nickName;
    /**
     * next为HeroNode引用类型，里边存储的是一个地址，next指向下一个节点
     */
    public HeroNode next;

    public HeroNode() {}
    public HeroNode(int number, String name, String nickName) {
    this.number = number;
    this.name = name;
    this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}




