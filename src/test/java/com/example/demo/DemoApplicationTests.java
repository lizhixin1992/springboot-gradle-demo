package com.example.demo;

//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;

import java.util.function.Consumer;
import java.util.function.Predicate;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class DemoApplicationTests {

//	@Test
//	public void contextLoads() {
//		System.out.println("aaaaaaaaaaaa");
//	}


    public static void main(String[] args) {
        Predicate<Integer> predicate = y -> y > 5;

        Consumer<Integer> consumer = x -> {
            int a = x + 2;
            System.out.println(a);
            System.out.println(a + "_");
        };

        System.out.println(predicate.test(1));
        if(predicate.test(1)) {
            consumer.accept(1);
        }
    }

}
