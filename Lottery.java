package com.silencoco;

import java.util.*;

/**
 * 字符串随机点名且不重复
 *     定义一个字符串数组用来装源数据
 *     定义一个字符串用来装随机后的字符串
 *     通过随机索引随机字符串
 *     每次随机后删除随机的那个字符串
 *     最后为了防止随机数为0报异常写一个判断语句
 */
public class Lottery {
    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"你好","我好","大家好","good","better","very good");
        String list1 = new String();
        Random random = new Random();
        while (list1!=null){
            int r = random.nextInt(list.size());
            list1 = list.get(r);
            list.remove(r);
            System.out.println(list1);
            //随机数不能
            if (r==0){
                break;
            }
        }
    }
}
