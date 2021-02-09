package 案例.斗地主案例;

import java.util.*;

public class DouDiZhuPro {
    public static void main(String[] args) {
        Map<Integer,String> poker = new HashMap<>();
        //创建一个List集合，存储牌的索引
        ArrayList<Integer> pokerIndex = new ArrayList<>();
        //定义两个集合，存储花色和牌的序号
        ArrayList<String> colors= new ArrayList<>();
        ArrayList<String> numbers= new ArrayList<>();
        Collections.addAll(colors,"♠","♣","♥","♦");
        Collections.addAll(numbers,"2","A","K","Q","J","10","9","8","7","6","5","4","3");
        int index=0;
        poker.put(index,"大王");
        pokerIndex.add(index);
        index++;

        poker.put(index,"小王");
        pokerIndex.add(index);
        index++;//key相同的时候值会被覆盖，所以得用++;

        //组装牌
        for (String number:numbers
             ) {
            for (String color:colors
                 ) {
                poker.put(index,color+number);
                pokerIndex.add(index);
                index++;
            }
        }
        System.out.println(poker);
        Collections.shuffle(pokerIndex);

        ArrayList<Integer> player1 = new ArrayList<>();
        ArrayList<Integer> player2 = new ArrayList<>();
        ArrayList<Integer> player3 = new ArrayList<>();
        ArrayList<Integer> dp = new ArrayList<>();

        for (int i = 0; i < pokerIndex.size(); i++) {
            Integer in = pokerIndex.get(i);
            //先判断底牌
            if ((i>=51)){
                dp.add(in);
            }else if (i%3==0){
                player1.add(in);
            }else if (i%3==1){
                player2.add(in);
            }else if (i%3==2){
                player3.add(in);
            }
        }

        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);
        Collections.sort(dp);
        System.out.println(player1);
        System.out.println(player2);
        System.out.println(player3);
        System.out.println(dp);

        lookPoker("刘德华", (HashMap<Integer, String>) poker,player1);
        lookPoker("周润发", (HashMap<Integer, String>) poker,player2);
        lookPoker("周星驰", (HashMap<Integer, String>) poker,player3);
        lookPoker("底牌", (HashMap<Integer, String>) poker,dp);
    }

    private static void lookPoker(String name,HashMap<Integer,String> poker,ArrayList<Integer> list) {
        System.out.print(name+": ");

        for (Integer key:list
             ) {
            String value = poker.get(key);
            System.out.print(value+" ");
        }
        System.out.println();
    }
}
