/*
 * Copyright 2020 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.me.learn.algorithm.lianbiao.linkedlist.singedirection;

/**
 * @author Administrator
 * @date 2020/10/7 20:59
 * Project Name: java-algorithm
 */
public class SingWayLinkListApp {

    private static Node sentinelNode = new Node(-1, null);

    public static void main(String[] args) {

        //哨兵节点 dummy节点一直指向head节点
        Node head = new Node(0, null);
        sentinelNode.next = head;

        Node node;
        Node previousNode = head;
        for (int i = 1; i <= 10; i++) {
            node = new Node(i, null);
            previousNode.next = node;
            previousNode = node;
        }

        Node start = sentinelNode.next;
        while (start != null) {
            System.out.println("start = " + start);
            start = start.next;
        }

    }
}

