package org.bolin.redisson;

import org.redisson.Redisson;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.Codec;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;

import java.nio.charset.StandardCharsets;

public class Try1 {
    public static RedissonClient getClient(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        //使用json序列化方式
        Codec codec = new JsonJacksonCodec();
        config.setCodec(codec);

        RedissonClient redissonClient = Redisson.create(config);
        return redissonClient;


    }

    public static void main(String[] args){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        //使用json序列化方式
        Codec codec = new JsonJacksonCodec();
        config.setCodec(codec);

        RedissonClient redissonClient = Redisson.create(config);
        Codec codec1 = redissonClient.getConfig().getCodec();
        System.out.println(codec1);






        redissonClient.getBucket("zi5").set("woainia");
        String object = (String)redissonClient.getBucket("zi5").get();
        System.out.println(object);





        // 获取 RMap 实例
        RMap<String, String> myMap = redissonClient.getMap("myHash5");

        // 设置哈希值
        myMap.put("field1", "value1"); // 设置 field1 的值为 value1
        myMap.put("field2", "value2"); // 设置 field2 的值为 value2

        // 可以添加更多的字段
        myMap.put("field3", "value3");
        myMap.put("m",new String("sdhfsd"));



        String field1 = myMap.get("m2");
        System.out.println(field1);




        // 关闭 Redisson 客户端
        redissonClient.shutdown();


    }
}
