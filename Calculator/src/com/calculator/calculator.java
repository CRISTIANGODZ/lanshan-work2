package com.calculator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author 张丁野
 * @version v1.0
 * @time 2022-07-18-9:56
 * @Description
 */
public class calculator {

    private ScriptEngine js = new ScriptEngineManager().getEngineByName("JavaScript");

    private calculator() {
    }
    private static calculator instance =null;
    public static calculator getInstance(){
        if (instance == null){
            instance = new calculator();
        }
        return instance;
    }

    //计算表达式
    private Object calculateExpression(String str){
        Object res = 0;
        try {
            res = js.eval(str);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return res;
    }

    //去括号
    private String removeBrackets(String oldPurposeStr){
        String purposeStr = oldPurposeStr;
        if (!purposeStr.contains("(")){
            return purposeStr;
        }else {
            int a = purposeStr.lastIndexOf("(");//寻找最后一个括号
            String rightString = purposeStr.substring(a, purposeStr.length());
            int b = rightString.indexOf(")");
            String objString = rightString.substring(1, b);//截取到最后一个括号
            Object resString1 = calculateExpression(objString);

            //对计算出的括号部分结果进行格式转换
            if (resString1 instanceof Integer){
                resString1 = (Integer)resString1;
            }
            if (resString1 instanceof Double){
                resString1 = (Double)resString1;
            }

            //将算出的结果进行组合
            purposeStr = purposeStr.substring(0,a) + resString1 + rightString.substring(b+1,rightString.length());
            return removeBrackets(purposeStr);//递归调用去括号
        }
    }

    //得出最终结果
    public Object getResult(String str){
        return calculateExpression(removeBrackets(str));
    }

}
