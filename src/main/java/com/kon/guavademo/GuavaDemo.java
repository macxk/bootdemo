package com.kon.guavademo;

import com.google.common.base.*;
import com.google.common.base.Optional;
import com.google.common.collect.*;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;

/**
 * 用例来自guava工具类学习
 */
public class GuavaDemo {

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

    public static void FluentIterableFilterDemo(){

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

    public static void FluentIterableTransDemo(){

        Person p1 = new Person("xk","m",26);
        Person p2 = new Person("zmy","w",25);
        Person p3 = new Person("db","m",26);

        List<Person> personList = Lists.newArrayList(p1,p2,p3);

        List<String> list =  FluentIterable.from(personList).transform(new Function<Person, String>() {
            @Nullable
            @Override
            public String apply(@Nullable Person person) {
                return Joiner.on(",").join(person.getName(),person.getSex(),person.getAge());
            }
        }).toList();

        for(String str:list){
            System.out.println(str);
        }
    }

    public static void setsDemo(){

        Set<String> s1 = Sets.newHashSet("1","2","3","4");
        Set<String> s2 = Sets.newHashSet("2","3","4","5");
        // s1 - s2
        Sets.SetView setView = Sets.difference(s1,s2);
        for(Iterator iterator = setView.iterator();iterator.hasNext();){
            System.out.println("s1 - s2 "+iterator.next());
        }

        // 集合对称差
        Sets.SetView setView1 = Sets.symmetricDifference(s1,s2);
        for(Iterator iterator = setView1.iterator();iterator.hasNext();){
            System.out.println("集合对称差 "+iterator.next());
        }

        // s1和s2的交集
        Sets.SetView setView2 = Sets.intersection(s1,s2);
        for(Iterator iterator = setView2.iterator();iterator.hasNext();){
            System.out.println("s1和s2的交集 "+iterator.next());
        }

        // 合并s1和s2
        Sets.SetView setView3 = Sets.union(s1,s2);
        for(Iterator iterator = setView3.iterator();iterator.hasNext();){
            System.out.println("合并s1和s2 "+iterator.next());
        }
    }

    // 利用Functions将Map转化为Function
    public static void MapToFuncation(){

        Map<String,Person> mp = Maps.newHashMap();
        Person person = new Person("xk","m",26);
        mp.put(person.getName(),person);
        Function<String,Person> function = Functions.forMap(mp);
        Person tm = function.apply(person.getName());
        System.out.println(tm == person);

    }

    // 将List<Person> 转化为Map<String, Person>，其中键值对是person.name -> Person
    public static void ListToMap(){

        Person p1 = new Person("xk","m",26);
        Person p2 = new Person("zmy","w",25);
        Person p3 = new Person("db","m",26);

        List<Person> personList = Lists.newArrayList(p1,p2,p3);

        Map<String,Person> mp = Maps.uniqueIndex(personList, new Function<Person, String>() {
            @Nullable
            @Override
            public String apply(@Nullable Person person) {
                return person.getName();
            }
        });

        for(String name:mp.keySet()){
            System.out.println(mp.get(name));
        }
    }

    // 一键多值类Multimap
    public static void MultimapDemo(){

        ArrayListMultimap<String,String> multimap = ArrayListMultimap.create();
        multimap.put("foo","1");
        multimap.put("foo","2");
        multimap.put("foo","3");
        multimap.put("bar","a");
        multimap.put("bar","b");
        multimap.put("bar","c");

        for(String key:multimap.keySet()){
            System.out.println(multimap.get(key));
        }
    }

    // 多键类Table
    public static void HashBasedTableDemo(){

        HashBasedTable<Integer,Integer,String> table = HashBasedTable.create();
        table.put(1,1,"xk");
        table.put(1,2,"zmy");
        table.put(1,3,"db");

        System.out.println(table.get(1,1));
        System.out.println(table.get(1,2));
        System.out.println(table.get(1,3));
        table.remove(1,2);
        System.out.println(table.get(1,2));

        Map<Integer,String> row = table.row(1);
        Map<Integer,String> column = table.column(1);

        System.out.println(row);
        System.out.print(column);
    }

    public static void OptionalDemo(){
        Person p =null;
        System.out.println(Optional.fromNullable(p).or(new Person()).getName());
    }

    public static void main(String[] args){

        MapToString();

        StringToMap();

        CharMatcherDemo();

        FluentIterableFilterDemo();

        FluentIterableTransDemo();

        setsDemo();

        ListToMap();

        MultimapDemo();

        HashBasedTableDemo();

        OptionalDemo();

    }
}
