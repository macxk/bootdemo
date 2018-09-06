package com.kon.guavademo;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import org.checkerframework.checker.nullness.qual.Nullable;
import java.util.Iterator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GavaDemo {

    public static void MapToString(){

        Map<String,String> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");

        // 用:分割键值对，并用#分割每个元素，返回字符串
        String returnStr = Joiner.on("#").withKeyValueSeparator(":").join(map);
        System.out.println(returnStr);
    }

    public static void StringToMap(){

        Splitter.MapSplitter splitter = Splitter.on("#").withKeyValueSeparator(":");
        String argStr = "key1:value1#key2:value2#key3:value3";
        Map<String,String> map = splitter.split(argStr);
        for(String key:map.keySet()){
            System.out.println(key+"->"+map.get(key));
        }

    }

    public static void CharMatcherDemo(){

        String argStr = "1234abcdABCD56789";
        String number = CharMatcher.digit().retainFrom(argStr);
        System.out.print(number);
    }

    public static void FluentIterableDemo(){

        Person p1 = new Person("xk","m",26);
        Person p2 = new Person("zmy","w",25);
        Person p3 = new Person("db","m",26);

        List<Person> personList = Lists.newArrayList(p1,p2,p3);

        Iterable<Person> personIterable = FluentIterable.from(personList).filter(new Predicate<Person>(){

            @Override
            public boolean apply(@Nullable Person person) {
                return person.getAge()>25;
            }
        });

        for (Iterator iterator = personIterable.iterator();iterator.hasNext();){
            System.out.println(((Person)iterator.next()).getName());
        }


    }

    public static void main(String[] args){

        MapToString();

        StringToMap();

        CharMatcherDemo();

        FluentIterableDemo();


    }
}
