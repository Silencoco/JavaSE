package 案例.斗地主案例;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class demo5统计输入的字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一串字符串:");
        String input = sc.next();


//        method1(input);//回顾，统计输入的数字、大小写字母、符号的个数
        method2(input);//统计字符串中相同字母出现的个数
    }

    private static void method2(String input) {
        //创建Map集合，key是字符串中的字符，value是字符的个数
        HashMap<Character,Integer> map = new HashMap<>();
        //遍历字符串，获取每一个字符
        for (char c:input.toCharArray()
             ) {
            if (map.containsKey(c)){
                Integer value = map.get(c);//通过key获取value
                value++;
                map.put(c,value);
            }
            else{
                //key不存在
                map.put(c,1);
            }
        }
        //输出结果
//        for (Object obj:map.entrySet()//键值对
//             ) {
//            System.out.println(obj);
//        }
        //也可以
        for (Character key:map.keySet()//获取键，通过键获取值
             ) {
            Integer value = map.get(key);
            System.out.println(key+" 有"+value+"个");
        }
    }

    private static void method1(String input) {
        char[] chars = input.toCharArray();
        int word_up = 0;
        int word_low = 0;
        int num = 0;
        int fh = 0;
        for (int i:chars
             ) {
            System.out.println(i);
            if (i>=97&&i<=122){//小写字母
                word_low++;
            }else if (i>=65&&i<=90){//大写字母
                word_up++;
            }else if(i>=48&&i<=57){//数字
                num++;
            }else{//符号
                fh++;
            }
        }
        System.out.println("数字有 "+num+"个\t ");
        System.out.println("大写字母有 "+word_up+"个\t ");
        System.out.println("小写字母有 "+word_low+"个\t ");
        System.out.println("符号有 "+fh+"个\t ");
    }
}
