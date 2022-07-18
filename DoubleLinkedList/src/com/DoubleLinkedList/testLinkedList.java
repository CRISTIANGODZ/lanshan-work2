package com.DoubleLinkedList;

import org.junit.Test;

/**
 * @author 张丁野
 * @version v1.0
 * @time 2022-07-18-19:29
 * @Description
 */
public class testLinkedList {
    @Test
    public void test(){
        DoublelLinkedList<Person> linkedList = new DoublelLinkedList<>();

        //测试增加数据
        linkedList.addFirst(new Person("Holland",21));
        linkedList.addLast(new Person("Mbappe",23));
        linkedList.addFirst(new Person("Vlahovic",24));
        linkedList.add(1,new Person("Martinez",25));

        linkedList.print();
        System.out.println();

        //测试查找数据
        System.out.println(linkedList.getData(1));
        System.out.println();

        //测试修改数据
        linkedList.changeData(1,new Person("Cristiano",37));
        System.out.println(linkedList.getData(1));
        System.out.println();

        //测试删除数据
        linkedList.remove(1);
        linkedList.print();
        linkedList.removeFirst();
        linkedList.print();
        linkedList.removeLast();
        linkedList.print();
        linkedList.clear();
        linkedList.print();

    }
}
