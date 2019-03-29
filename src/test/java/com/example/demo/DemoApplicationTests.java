package com.example.demo;

//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import io.searchbox.strings.StringUtils;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class DemoApplicationTests {

//	@Test
//	public void contextLoads() {
//		System.out.println("aaaaaaaaaaaa");
//	}


    public static void main(String[] args) {
//        Predicate<Integer> predicate = y -> y > 5;
//
//        Consumer<Integer> consumer = x -> {
//            int a = x + 2;
//            System.out.println(a);
//            System.out.println(a + "_");
//        };
//
//        System.out.println(predicate.test(10));
//        if(predicate.test(10)) {
////            consumer.accept(1);
//            consumer.andThen(consumer);
//        }

//        Runnable res1 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("hello world");
//            }
//        };
//
//        Runnable res2 = () -> System.out.println("hello world");
//
//        res1.run();
//        res2.run();


//        List<Integer> nums = Lists.newArrayList(1,1,null,2,3,4,null,5,6,7,8,9,10);
//        System.out.println("sum is:"+nums.stream().filter(num -> num != null).distinct().mapToInt(num -> num * 2).peek(System.out::println).skip(2).limit(4).sum());

//        System.out.println(nums.stream().filter(num -> num != null).collect(Collectors.toList()));

//        String a = {"title":"疾速天使","subTitle":"基因改造引发物种杀戮","pinyin":"jsts","tags":"","contentType":"PS","videoType":"电影","videoClass":"喜剧|动作|冒险","createDate":1542346545949,"status":1,"definition":"4K|HD|SD|X","description":"\"疾速天使” 系列是当今颇具影响、广受青少年喜爱的小说，作品将科幻与奇幻元素巧妙地融为一体，充满了速度感、悬疑感和冲击力。六个孩子被送入实验室接受残酷的基因改造，变成了长有翅膀拥有超能力的鸟孩。他们逃离、反叛，在残酷的试炼中发现他们的力量正是为了这个世界而存在。\n故事极像快速推进的大片，充满悬疑的故事、环环相扣的谜团、匪夷所思的超能力。不断切换的场景，第一人称的叙述方式，带读者迅速进入故事情境。让读者与六个孩子一起遭遇挫折、触摸感动，踏上探索生命真谛与未来命运的旅程！","duration":0,"grade":6.4,"hImage":"http://i.gtimg.cn/qqlive/img/jpgcache/files/qqvideo/hori/7/7ubvbd3wlslzcsj_e.jpg","movieLevel":1,"publishDate":1522250281000,"vImage":"http://i.gtimg.cn/qqlive/img/jpgcache/files/qqvideo/7/7ubvbd3wlslzcsj_x.jpg","copyRight":"tx","copyRightId":"","actors":"","airtime":"","area":"","director":"","seriesSum":0,"language":"","recentNum":0,"isFinish":1,"vipFlag":"1","apps":[{"appId":"com.newtv.cboxtv","contentId":672574,"source":"tx"}]};

//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("1");
//        list.add("4");
//        list.add("1");
//
//        list.removeIf(test -> test.equals("1"));
//        System.out.println(JSON.toJSONString(list));


//        Map<String, Object> map = new HashMap<>();
//        map.put("1_1", "1111111111");
//        map.put("2_2", "22222222");
//
//        System.out.println(map.get("1_2"));


//        System.out.println(StringUtils.isNotBlank(""));


//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.remove(list.size()-1);
//        System.out.println(JSON.toJSONString(list));
//        list.remove(list.size()-1);

//        Random random = new Random();
//        System.out.println(random.nextInt(1000));
//        System.out.println(random.nextInt(1000));

//        int a = 1;
//        int b = 2;
//
//        try {
//
//            System.out.println("b = " + b);
//            b = 1 / 0;       //B
//            System.out.println("b = " + b);
//            System.out.println("a = " + a);
//            a = 3;           //A
//            System.out.println("a = " + a);
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("a = " + a);
////            System.out.println("b = " + b);
//        } finally {
//            System.out.print("a = " + a);
//        }

//        Object[] a = null;
//        for (Object o : a) {
//            System.out.println(o);
//        }
//        for (int i = 0; i < a.length; i++) {
//            Object o = a[i];
//            System.out.println(o);
//        }

//        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
//        queue.offer("A");
//        queue.offer("B");
//        queue.offer("C");
//
//        queue.poll();
//        queue.poll();
//        queue.poll();


//        List<Object> list = new ArrayList<>();
////        Map<String, Object> map = new HashMap<>();
////        map.put("1",null);
////        map.put("2","");
////        map.put("3",null);
////        map.put("4","");
////        map.put("5",null);
////        map.put("6","");
////        map.put("7",null);
////        list.add(map);
////        System.out.println(JSON.toJSONString(list));

        String s = "11|22|33|";
        System.out.println(s.contains(""));

    }

}
