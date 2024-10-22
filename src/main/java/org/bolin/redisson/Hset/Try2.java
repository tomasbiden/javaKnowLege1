package org.bolin.redisson.Hset;

import org.bolin.redisson.Try1;
import org.redisson.api.RBucket;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;

public class Try2 {
    public static void main(String [] args){
        RedissonClient client = Try1.getClient();
        RMap<String, String> myHash5 = client.getMap("myHash5");

        myHash5.put("hh2","vv2");
        String m = myHash5.get("hh");
        System.out.println(m);
        client.shutdown();



    }
}
