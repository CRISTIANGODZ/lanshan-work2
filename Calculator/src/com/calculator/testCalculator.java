package com.calculator;

/**
 * @author 张丁野
 * @version v1.0
 * @time 2022-07-18-10:08
 * @Description
 */
public class testCalculator {
    public static void main(String[] args) {
        calculator cal = calculator.getInstance();

        System.out.println(cal.getResult("(1+2*(3-5))*(2-1)"));//也可利用scanner读取用户数据，这里测试就直接传入字符串
    }
}
