/*
 * Copyright 2020 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */

package com.me.learn.algorithm.lianbiao.linkedlist.doublelinklist;


import java.security.acl.LastOwnerException;

/**
 * @author Administrator
 * @date 2020/10/7 22:46
 * Project Name: java-algorithm
 */
public class DoubleListApp {
    private static Node sentinelNode = new Node(-1, null);

    public static void main(String[] args) {

        //哨兵节点 dummy节点一直指向head节点
       Node head = new Node(0, null);
        sentinelNode.next = head;


        Node lastNode = createDoubleLinklist(head);

        Node start = sentinelNode.next;

//        backwardTraverse(lastNode);

        traverse(head);

//        head = reverse(head);
//        traverse(head);

         head = reverseBetween(head, 2, 5);
         traverse(head);
    }

    private static Node createDoubleLinklist(Node head) {

        Node node;
        Node previousNode = head;
        for (int i = 1; i <= 10; i++) {

            node = new Node(i, null);
            //double linked
            previousNode.next = node;
            node.previous = previousNode;
            previousNode = node;
        }

        return previousNode;
    }

    public static void backwardTraverse(Node lastNode) {
        Node node = lastNode;
        while (node != null) {
            System.out.println("lastNode = " + node);
            node = node.previous;
        }
    }

    public static void traverse(Node startNode) {
        Node node = startNode;
        while (node != null) {
            System.out.println("lastNode = " + node);
            node = node.next;
        }
    }

    public static Node reverse(Node startNode) {
        if (startNode == null) {
            return startNode;
        }

        Node next;
        Node previous = startNode;
        Node current =  startNode.next;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous.previous = current;

            previous = current;
            current = next;
        }
        startNode.next = null;
        //1-> 2 ->3 ->4 ->5
        //startNode 1
        //round1 previous node 1, current node = node 2
         //1 <- 2
        return previous;
    }

    /**
     * 字节跳动的面试题
     * */
    public static Node reverseBetween(Node head, int m, int n) {
        //Check
        if (head == null || m >= n) {
            return head;
        }

        // add 哨兵节点
        Node dummy = new Node(-1);
        dummy.next = head;
        head = dummy;

        for (int i = 1; i < m; i++) {
            head = head.next;
        }

        Node preM = head;
        Node mNode =  head.next;
        Node nNode = mNode;
        Node postN = nNode.next;
        for (int i = m; i< n; i++) {
            Node next = postN.next;

            postN.next = nNode;
            nNode.previous = postN;

            nNode = postN;
            postN = next;
        }

        mNode.next = postN;
        preM.next = nNode;

        return dummy.next;
    }
}
