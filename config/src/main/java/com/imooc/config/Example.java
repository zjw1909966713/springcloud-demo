package com.imooc.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 张进文
 * @ClassName Example
 * @Description TODO
 * @Date 2019/3/21 12:06
 * @Version 1.0
 */
public class Example {

    public static void main(String[] args) {

        List<Student> studentList=new ArrayList<>();
        studentList.add(new Student("zhangsan",12));
        studentList.add(new Student("zhangsan1",16));
        studentList.add(new Student("zhangsan3",18));
        studentList.add(new Student("zhangsan2",17));
        studentList.add(new Student("zhangsan4",19));

        List<Integer>   ageList= studentList.stream().map(e->e.getAge()).collect(Collectors.toList());
        for (Integer integer:ageList
             ) {
            System.out.println(integer);
        }


    }

}

class  Student{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
