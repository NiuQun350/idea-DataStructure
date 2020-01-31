package cn.sxt.test;
import java.util.Stack;
/**
 * @author NiuQun
 * @2019/11/16
 */

public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.add("aaa");
        stack.add("bbb");
        stack.add("ccc");
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
}
