package com.atguigu.gmall.user.controller;

import java.util.Random;

/**
 * @Author : SunJun
 * @email : sunjun0207@163.com
 * @create 2021/1/17 10:31
 */
//抽取随机同学
public class RandomPeople {

  public static void main(String[] args) {
    Random random = new Random();
    int col = random.nextInt(4) + 1;
    int row = random.nextInt(8) + 1;
    System.out.println("有请第--" + row + "--行，第--" + col + "--列的同学回答问题。。。");
  }


}
