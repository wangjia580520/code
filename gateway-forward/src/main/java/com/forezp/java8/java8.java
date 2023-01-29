package com.forezp.java8;

import com.alibaba.fastjson.JSONObject;
import com.forezp.entity.Apple;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class java8 {
    public static List<Apple> getApples() {
        List<Apple> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Apple a = new Apple();
            a.setId(i);
            a.setName(String.format("红色%s号", i));
            a.setSize((i + 1) * 10);
            list.add(a);
        }
        return list;
    }

    /**
     * filter 和 map使用
     */

    public static void filterMap() {
        List<Apple> apples = getApples();
        System.out.println(JSONObject.toJSON(apples));
        List<Apple> appless = apples.stream().filter(apple -> apple.getId() >= 0).skip(1)
                .map(apple -> {
                    apple.setName("苹果" + apple.getId());
                    return apple;
                }).collect(toList());


        List<Apple> appless3 =new ArrayList<>();
        Optional<Apple> applessq = apples.stream().filter(apple -> apple.getId() >= 0)
                .findFirst();
        Collections.sort(appless,Comparator.comparingInt(Apple::getId).reversed());
        System.out.println(JSONObject.toJSON(appless));
        System.out.println(JSONObject.toJSON(appless3));
        System.out.println(JSONObject.toJSON(applessq.orElse(new Apple())));
    }

    public static void main(String[] args) {
        filterMap();
        new Thread(() -> System.out.println("1122")).start();
    }
}
