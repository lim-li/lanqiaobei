package lanqiaobei.数据结构基础;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import java.awt.*;
import java.sql.SQLOutput;

/**
 * @author limli
 * @date 2023/1/29 14:35
 */
class node {
    int val;
    node next;
    public node(int val) {
        this.val = val;
    }
}
public class 链表_约瑟夫环 {
    private static node head;
    public static void main(String[] args) {
        int m = 3;
        circleList(6);
        int count = 1;
        while(head.next != head){//只剩一个节点
            if(count == m-1){
                System.out.print(head.next.val+"->");
                head.next = head.next.next;
                count=1;
            }else count++;
            head=head.next;
        }
        System.out.println(head.val);
        //getVal(head,3);
    }

//    public static void getVal(node head,int m){//循环的大小为m依次获取循环链表的值
//        circleList(6);
//        int count = 1;
//        while(head.next != head){//只剩一个节点
//            if(count == m-1){
//                System.out.println(head.next.val+"->");
//                head.next = head.next.next;
//                count=1;
//            }else count++;
//            head=head.next;
//        }
//        System.out.println(head.val);
//    }
    public static void circleList(int n){//创建大小为n的循环链表
        //模拟约瑟夫环
        head = new node(1);
        //创建循环单链表
        node temp = head;
        for(int i = 2;i <= n;i++){
            temp.next = new node(i);
            temp = temp.next;
        }
        temp.next = head;//首尾相连
    }
}

