package 案例.斗地主案例;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DouDiZhu {
    /*
    斗地主综合案例：
        1、准备牌
        2、洗牌
        3、发牌
        4、看牌
     */
    public static void main(String[] args) {
        //1、准备牌
        //定义一个存储54张牌的ArrayList集合，泛型采用String
        ArrayList<String> poker = new ArrayList<>();
        //定义两个数组，一个存储花色，一个存序号
        String[] colors = {"黑桃","红桃","梅花","方片"};
        String[] numbers = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
        //先把大小王存储到poker中
        poker.add("大王");
        poker.add("小王");
        //循环嵌套遍历连个数组，组装52张牌
        for (String number: numbers
             ) {
            for (String color : colors) {
//                System.out.println(color+number);
                //把组装好的牌存到poker中
                poker.add(color+number);
            }
        }
        System.out.println(poker);
        /*
        洗牌：使用集合工具类 collections 中的public static void shuffle(List<?> list) 使用默认随机源对指定列表进行置换。
         */
        Collections.shuffle(poker);
        System.out.println(poker);

        /*
        发牌
         */
        //定义四个集合，存储玩家的牌和底牌
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> diPai = new ArrayList<>();

        /*
        遍历poker集合，获取每一张牌
        使用poker集合的索引%3给三个玩家轮流发牌
        剩余三张牌为底牌
        注意：
        先判断底牌（i>=51）,否则牌就发没了
         */
        for (int i = 0; i < poker.size(); i++) {
            //获取每一张牌
            String p = poker.get(i);
            //轮流发牌
            if (i>=51){
                //改底牌发牌
                diPai.add(p);
            }else if (i%3==0){
                player1.add(p);//给玩家1发牌
            }else if (i%3==1){
                player2.add(p);//给玩家2发牌
            }else if (i%3==2){
                player3.add(p);//给玩家3发牌
            }
        }

        //看牌
        System.out.println("张三-->"+player1);
        System.out.println("李四-->"+player2);
        System.out.println("王五-->"+player3);
        System.out.println("底牌-->"+diPai);

    }
}
