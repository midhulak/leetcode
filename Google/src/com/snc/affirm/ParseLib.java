package com.snc.affirm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseLib {
	
	public static  int evaluate(String expression) {
        return helper(expression, new HashMap<>());
    }

    private static int helper(String expr, Map<String, Integer> map) {
        if (isNumber(expr)) {
            return Integer.valueOf(expr);
        }

        if (isVariable(expr)) {
            return map.get(expr);
        }

        int res = 0;
        List<String> list = parse(expr);
        if (list.get(0).equals("add")) {
            res = helper(list.get(1), map) + helper(list.get(2), map);
        } else if (list.get(0).equals("mult")) {
            res = helper(list.get(1), map) * helper(list.get(2), map);
        } else {
            Map<String, Integer> newMap = new HashMap<>(map);
            for (int i = 1; i < list.size() - 1; i += 2) {
                newMap.put(list.get(i), helper(list.get(i + 1), newMap));
            }

            res = helper(list.get(list.size() - 1), newMap);
        }

        return res;
    }

    private static boolean isNumber(String expr) {
        char c = expr.charAt(0);
        return c >= '0' && c <= '9' || c == '-';
    }

    private static boolean isVariable(String expr) {
        char c = expr.charAt(0);
        return c >= 'a' && c <= 'z';
    }

    private static List<String> parse(String expr) {
        List<String> res = new ArrayList<>();
        expr = expr.substring(1, expr.length() - 1);
        int startIndex = 0;
        while (startIndex < expr.length()) {
            int endIndex = next(expr, startIndex);
            res.add(expr.substring(startIndex, endIndex));
            startIndex = endIndex + 1;
        }

        return res;
    }

    private static  int next(String expr, int startIndex) {
        int index = startIndex;
        if (expr.charAt(index) == '(') {
            int count = 1;
            index++;
            while (index < expr.length() && count > 0) {
                if (expr.charAt(index) == '(') {
                    count++;
                } else if (expr.charAt(index) == ')') {
                    count--;
                }

                index++;
            }
        } else {
        	System.out.println("expr at index is="+index+"and expression is="+expr.charAt(index));
            while (index < expr.length() && expr.charAt(index) != ' ') {
                index++;
            }
        }

        return index;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))"));
	}

}
