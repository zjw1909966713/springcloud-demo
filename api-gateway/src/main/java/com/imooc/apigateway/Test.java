package com.imooc.apigateway;

import java.util.Arrays;
import java.util.List;

/**
 * @author 张进文
 * @ClassName Test
 * @Description TODO
 * @Date 2019/3/29 15:03
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        System.out.println();
        numbers.stream().sorted().forEach();
    }
}
