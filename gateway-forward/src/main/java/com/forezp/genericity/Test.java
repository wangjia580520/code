package com.forezp.genericity;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用泛型 接收水果可以全部遍历任一水果，但是无法添加新数据
 */
public class Test {
    public static void print(List<? extends Fruits> list) {
        for (Fruits fruits : list) {
            System.out.println(JSONObject.toJSONString(fruits));
        }
        // 但是不能添加数据  因为占位符号  list.add();
    }

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple("黄元帅"));
        apples.add(new Apple("红富士"));

        print(apples);

        List<Banana> bananas = new ArrayList<>();
        bananas.add(new Banana("美人蕉"));
        bananas.add(new Banana("大黄鱼"));

        print(bananas);
    }
}
