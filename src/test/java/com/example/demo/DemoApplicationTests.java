package com.example.demo;

//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.alibaba.fastjson.JSON;
import com.example.demo.util.JsonUtil;
import com.google.common.collect.Lists;
import com.google.gson.JsonElement;
import io.searchbox.strings.StringUtils;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

//        String s = "11|22|33|";
//        System.out.println(s.contains(""));

//        String[] retIds = new String[3];
//        String a = retIds[0];
//        System.out.println("a".contains(a));

//        Map<String, String> map = new HashMap<>();
//        System.out.println(map.get("1"));

//        JsonElement jsonElement = JsonUtil.fromJson("\"11111\"");
//        String contentId = jsonElement.getAsString();

//        for (int i = 0; i < 10; i++) {
//            try {
//                if(i == 5){
//                    System.out.println(5/0);
//                }
//                System.out.println(i);
//            } catch (Exception e) {
//                continue;
//            }
//        }

//        Set<String> a = new LinkedHashSet<>();
//        a.add("http://localhost:9201");
//        a.add("http://localhost:9202");
//        a.add("http://localhost:9203");
//        a.add("http://localhost:9200");
//
//        for (String s : a) {
//            System.out.println(s);
//        }
//
//        a.remove("http://localhost:9200");
//        System.out.println("-----------------------------------");
//        for (String s : a) {
//            System.out.println(s);
//        }

//        String a = " xwlb 1128 ";
//        System.out.println(a);
//        a.trim();
//        System.out.println(a);

//        System.out.println("wewewehmjzdewewe".indexOf("hmjz"));


//        Pattern pattern = Pattern.compile("[`~!@#$%^&*()+=|{}':;',\\[\\].?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？\\s¥《》「」_\"]");
////        String key = "<em>ewewewewewew</em>";
////        String key = "<em>（ewewewewewew</em>";
////        String key = "<em>ewewewewewew）</em>";
////        String key = "<em>（ewewewewewew）</em>";
////        String key = "wewe<em>'（ewewew!！！！！ewe!!wew）'</em>";
////        String key = "<em>（ewewe！wewewew</em>";
////        String key = "<em>ewewewe！wewew）</em>";
////        String key = "<em>ewewew！ewewew</em>";
//        String key = "1213123<em>'（ewewew！！！！ewewew#$</em>32424234<em>we!we）'</em>123123213";

//        int a = -1;
//        List<Map<Integer, String>> list = new ArrayList<>();
//        String[] strArr = key.split("</em>");
//        for (String str : strArr) {
//            Matcher m = pattern.matcher(str);
//            while (m.find()) {
//                System.out.println(str.length() + "----------------------");
//                System.out.println(m.start());
//                System.out.println(m.end());
//
//                if (m.start() == 4) {
//                    System.out.println("左边");
//                    System.out.println(str.substring(m.start(), m.end()));
//                    Map<Integer, String> map = new HashMap<>();
//                    map.put(m.start(), str.substring(m.start(), m.end()) + "<em>");
//                    list.add(map);
//                } else if (m.start() == (str.length() - 1)) {
//                    System.out.println("右边");
//                    System.out.println(str.substring(m.start(), m.end()));
//                    Map<Integer, String> map = new HashMap<>();
//                    map.put(m.start(), str.substring(m.start(), m.end()) + "</em>");
//                    list.add(map);
//                } else if (m.start() > 4 && m.start() < (str.length() - 1)) {
//                    System.out.println("中间");
//                    System.out.println(str.substring(m.start(), m.end()));
//                    Map<Integer, String> map = new HashMap<>();
//                    if (a != (m.start() - 1)) {
//                        map.put(m.start(), str.substring(m.start(), m.end()) + "</em>");
//                        list.add(map);
//                    }
//                    a = m.start();
//                }
//            }
//        }
//
//        System.out.println(list.toString());


//        int a = -1;
//        List<Integer> list = new ArrayList<>();
//        String[] strArr = key.split("</em>");
//        for (String str : strArr) {
//            System.out.println(str);
//            String[] str1 = str.split("<em>");
//            for (String s : str1) {
//                System.out.println(s);
//                Matcher m = pattern.matcher(s);
//                while (m.find()) {
//                    System.out.println(str.length() + "----------------------");
//                    System.out.println(m.start());
//                    System.out.println(m.end());
//
//                    if (m.start() == 4) {
//                        System.out.println("左边");
//                        System.out.println(str.substring(m.start(), m.end()));
//                        list.add(m.start());
//                    } else if (m.start() == (str.length() - 1)) {
//                        System.out.println("右边");
//                        System.out.println(str.substring(m.start(), m.end()));
//                        list.add(m.start());
//                    } else if (m.start() > 4 && m.start() < (str.length() - 1)) {
//                        System.out.println("中间");
//                        System.out.println(str.substring(m.start(), m.end()));
//                        list.add(m.start());
//                    }
//                }
//            }
//        }
//        System.out.println(list.toString());

//        wewe<em>'（ewewew!！！！！ewe!!wew）'</em>
//        List<Integer> list = new ArrayList<>();
//        Matcher m = pattern.matcher(key);
//        System.out.println(key.length() + "----------------------");
//        while (m.find()) {
////            System.out.println(m.start());
////            System.out.println(m.end());
////
////            System.out.println(key.substring(m.start(), m.end()));
//            list.add(m.start());
//        }
//        System.out.println("特殊符号:" + list.toString());


//        for (Integer i : list) {
//            if(i < 4){
//
//            }else if(i == 4){
//                System.out.println("最左边");
//            }else if (i == (key.length() - 6)) {
//                System.out.println("最右边");
//            }else if (i > 4 && i < (key.length() - 6)) {
//                System.out.println("中间");
//            }
//        }

//        List<Integer> list1 = new ArrayList<>();
//        Pattern pattern1 = Pattern.compile("<em>");
//        Matcher m1 = pattern1.matcher(key);
//        while (m1.find()) {
////            System.out.println(m1.start());
////            System.out.println(m1.end());
////
////            System.out.println(key.substring(m1.start(), m1.end()));
//            list1.add(m1.start());
//        }
//        System.out.println("<em>:" + list1.toString());
//
//
//        List<Integer> list2 = new ArrayList<>();
//        Pattern pattern2 = Pattern.compile("</em>");
//        Matcher m2 = pattern2.matcher(key);
//        while (m2.find()) {
////            System.out.println(m2.start());
////            System.out.println(m2.end());
////
////            System.out.println(key.substring(m2.start(), m2.end()));
//            list2.add(m2.end());
//        }
//        System.out.println("</em>" + list2.toString());
//
//
//        StringBuffer data = new StringBuffer();
//        data.append(setEM(key.substring(7, 36)));
//
//        data.append(setEM(key.substring(36, 52)));
//
//        if(list2.get(list2.size()-1) != key.length()){
//            data.append(key.substring(list2.get(list2.size()-1),key.length()));
//        }
//
//        System.out.println(data.toString());


//        String key ="<em>ss{</em>";
//        String data = "";
//        Integer offset = 6;
//        if (offset.equals(4)) {
//            data = key.replace(key.substring(0, offset + 1), key.substring(offset, offset + 1) + "<em>");
//        } else if (offset.equals(key.length() - 6)) {
//            data = key.replace(key.substring(offset, offset + 6), "</em>" + key.substring(offset, offset + 1));
//        } else if (offset > 4 && offset < (key.length() - 6)) {
//            data = key.replace(key.substring(offset, offset + 1), "</em>" + key.substring(offset, offset + 1) + "<em>");
//        }
//        System.out.println(data);


        String str = "123abcd345adsd1";
        char[] ch = str.toCharArray();
        int len = str.length();
        int i = 0;
        StringBuffer newStr = new StringBuffer();
        int type = 0;
        Pattern pattern = Pattern.compile("^[0-9]*$");
        System.out.println(pattern.matcher("1").find());
        while (true) {
            if (pattern.matcher(String.valueOf(ch[i])).find()) {
                type = 1;
            } else {
                type = 2;
            }
            if (i < len - 1) {
                if (type == 1 && !pattern.matcher(String.valueOf(ch[i + 1])).find()) {
                    newStr.append(ch[i] + " ");
                } else if (type == 1 && pattern.matcher(String.valueOf(ch[i + 1])).find()) {
                    newStr.append(ch[i]);
                }
                if (type == 2 && pattern.matcher(String.valueOf(ch[i + 1])).find()) {
                    newStr.append(ch[i] + " ");
                } else if (type == 2 && !pattern.matcher(String.valueOf(ch[i + 1])).find()) {
                    newStr.append(ch[i]);
                }
                i++;
                if (i > len) {
                    break;
                }
            } else {
                newStr.append(ch[i]);
                break;
            }

        }
        System.out.println(newStr.toString());
    }


    private static String setEM(String key) {
        Pattern pattern = Pattern.compile("[`~!@#$%^&*()+=|{}':;',\\[\\].?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？\\s¥《》「」_\"]");
        List<Integer> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        Matcher ma = pattern.matcher(key);
        while (ma.find()) {
            list.add(ma.start());
        }
        System.out.println(key);
        System.out.println("key长度:" + key.length());
        System.out.println("特殊符号:" + list.toString());

        String newKey = "";
        int m = 0;
        int n = 1;
        for (int i = 0; i < list.size(); i++) {
            m = list.size() - n + 1;
            if (n > list.size() - 1) {
                break;
            }
            for (int j = 1; j < m; j++) {
                if (list.get(i + j - 1) + 1 == list.get(n)) {
                    if (n == list.size() - 1) {
                        if (i == 0) {
                            map = rep(i, n, key, list);
                        } else {
                            map = rep(i, n, newKey, list);
                        }
                        newKey = (String) map.get("newKey");
                        list = (List<Integer>) map.get("list");
                        i = n - 1;
                        n = n + 1;
                    } else {
                        n++;
                        continue;
                    }
                } else {
                    if (i == 0) {
                        map = rep(i, n, key, list);
                    } else {
                        map = rep(i, n, newKey, list);
                    }
                    newKey = (String) map.get("newKey");
                    list = (List<Integer>) map.get("list");
                    i = n - 1;
                    n = n + 1;
                    break;
                }
            }
        }

        return newKey;
    }

    private static Map<String, Object> rep(Integer i, Integer n, String key, List<Integer> list) {
        Map<String, Object> map = new HashMap<>();
        String data = "";
        System.out.println("i:" + i + ",n:" + n);
        if (list.get(i).equals(4)) {
//            System.out.println(key.substring(0, list.get(n - 1) + 1));
//            System.out.println(key.substring(list.get(i), list.get(n - 1) + 1) + "<em>");
            data = key.replace(key.substring(0, list.get(n - 1) + 1), key.substring(list.get(i), list.get(n - 1) + 1) + "<em>");
        } else if (list.get(n).equals(key.length() - 6)) {
//            System.out.println(key.substring(list.get(i), list.get(n) + 6));
//            System.out.println("</em>" + key.substring(list.get(i), list.get(n) + 1));
            data = key.replace(key.substring(list.get(i), list.get(n) + 6), "</em>" + key.substring(list.get(i), list.get(n) + 1));
        } else if (list.get(i) > 4 && list.get(n) < (key.length() - 6)) {
//            System.out.println(key.substring(list.get(i),list.get(n-1) + 1));
//            System.out.println("</em>" + key.substring(list.get(i),list.get(n-1) + 1) + "<em>");
            data = key.replace(key.substring(list.get(i), list.get(n - 1) + 1), "</em>" + key.substring(list.get(i), list.get(n - 1) + 1) + "<em>");
            list = list.stream().map(var1 -> var1 + 9).collect(Collectors.toList());

        }
        System.out.println(data);
        map.put("newKey", data);
        map.put("list", list);
        return map;
    }

}
