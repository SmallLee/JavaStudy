package com.lxn.test;

import com.sun.scenario.effect.impl.prism.PrImage;

import java.lang.reflect.Array;
import java.util.*;

// 利用栈实现前缀，中缀，后缀表达式转化计算
// 前缀 -*+3456  中缀 (3+4)*5-6 后缀 34+5*6-
// 要求: 中缀转后缀，并计算出后缀结果
// 中缀转后缀(数字输出，运算符进栈，括号匹配出栈，栈顶优先级高,弹出栈顶元素，)
/*
 * 中缀转后缀步骤
 * 1.中缀转char数组
 * 2.数字输出到字符串
 * 3.括号(进栈
 * 4.督导括号)，从栈中弹出元素输出到字符串直到遇到第一个(
 * 5.读到操作符+，-,如果栈不为空并且栈顶不是(,栈顶元素出栈，添加到输出字符串,否则入栈
 * 6.读到操作符*，/,如果栈不为空并且栈顶是*，/,则从栈顶弹出元素，否则入栈
 *
 * 后缀表达式求值思路
 * 1.后缀表达式转化为字符数组
 * 2.数组入栈，读到操作符取出栈中2个元素运算，用第二个元素+-* /第一个 结果入栈
 *
 * */
public class TestStack {
    private static String centerStr = "(3+4)*5-6";
    private static int result;
    private static List<String> list = new ArrayList<>(); // 后置
    private static StringBuilder sb = new StringBuilder();
    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) {
        infixToPostFix();
    }

    private static void infixToPostFix() {
        char[] charArray = centerStr.toCharArray();
        for (char c : charArray) {
            if (c >= '0' && c <= '9') {
                sb.append(c);
                continue;
            }
            if ('(' == c) {
                stack.push(c);
                continue;
            }
            // 开始弹栈直到遇到第一个(
            if (')' == c) { //(+
                while (!stack.empty() && stack.peek() != '(') {
                    char top = stack.pop();
                    sb.append(top);
                }
                stack.pop(); // 弹出(
            }
            if ('*' == c || '/' == c) {
                while (!stack.empty() && (stack.peek() == '/' || stack.peek() == '*')) {
                    sb.append(stack.pop());
                }
                stack.push(c);
                continue;
            }
            if ('+' == c || '-' == c) {
                while (!stack.empty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
        caculate(sb.toString());
    }

    // 计算后缀表达式的值
    private static void caculate(String postFix) {
        Stack<Integer> valus = new Stack<>();
        char[] chars = postFix.toCharArray();
        for (char c : chars) {
            if (isOperation(c)) {
                result = operate(valus.pop(), valus.pop(), c);
                valus.push(result);
            } else {
                int number = c - '0';
                valus.push(number);
            }
            System.out.println(valus.toString());
        }
        System.out.println(result);
    }

    private static int operate(int num1, int num2, char c) {
        String operation = String.valueOf(c);
        int result = 0;
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num2 - num1;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num2 / num1;
                break;
        }
        return result;
    }

    private static boolean isOperation(char c) {
        String str = String.valueOf(c);
        return "+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str);
    }

}
