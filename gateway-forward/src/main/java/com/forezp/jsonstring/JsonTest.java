package com.forezp.jsonstring;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

/**
 * json字符串转为泛型的对象
 */
public class JsonTest {
    public static void main(String[] args) {
        // 构建数据
        Address address = new Address();
        address.setAddressId("3");
        address.setAddressName("中华路");
        Apple apple = new Apple();
        apple.setId("1");
        apple.setColor("red");
        apple.setAddress(address);
        Request<Apple> request = new Request<>();
        request.setRequestId("2");
        request.setRequestName("request");
        request.setBody(apple);

        String json = JSONObject.toJSONString(request);
        System.out.println("字符串" + json);
        // 对于json字符串转为泛型类型的对象
        Request<Apple> request2 = JSONObject.parseObject(json, new TypeReference<Request<Apple>>() {
        });
        System.out.println("重新转为泛型" + JSONObject.toJSONString(request2));

        // 不使用TypeReference
        Request<Apple> request3 = JSONObject.parseObject(json, Request.class);
        System.out.println("不使用泛型" + request3.getBody().getAddress());

    }
}
