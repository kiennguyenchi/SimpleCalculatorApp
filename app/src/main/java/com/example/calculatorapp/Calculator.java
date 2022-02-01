//Chi Kien Nguyen (158416180) - Assignment 1
package com.example.calculatorapp;

import java.util.ArrayList;

public class Calculator {
    public ArrayList<String> equations;

    public Calculator(){
        equations = new ArrayList<String>();
    }
    void push(String value){
        equations.add(value);
    }
    int calculate(){
        if(equations.size() % 2 == 0){
            return -1;
        }else {
            boolean valid = true;
            int result = -1;
            int currentPositionOperator = 1;
            while (valid && currentPositionOperator < equations.size() - 1) {
                if (currentPositionOperator == 1) {
                    try {
                        int number1 = Integer.parseInt(equations.get(0));
                        int number2 = Integer.parseInt(equations.get(2));
                        if (equations.get(currentPositionOperator).equals("+") || equations.get(currentPositionOperator).equals("-")  || equations.get(currentPositionOperator).equals("*")  || equations.get(currentPositionOperator).equals("/") || equations.get(currentPositionOperator).equals("%") || equations.get(currentPositionOperator).equals("pow")|| equations.get(currentPositionOperator).equals("min")|| equations.get(currentPositionOperator).equals("max")){
                            result = determine(number1, equations.get(1), number2);
                        } else {
                            valid = false;
                        }
                    } catch (NumberFormatException ex) {
                        ex.printStackTrace();
                        valid = false;
                        break;
                    }
                    currentPositionOperator += 2;
                } else {
                    try {
                        int nextNum = Integer.parseInt(equations.get(currentPositionOperator + 1));
                        if (equations.get(currentPositionOperator).equals("+") || equations.get(currentPositionOperator).equals("-")  || equations.get(currentPositionOperator).equals("*")  || equations.get(currentPositionOperator).equals("/") || equations.get(currentPositionOperator).equals("%") || equations.get(currentPositionOperator).equals("pow")|| equations.get(currentPositionOperator).equals("min")|| equations.get(currentPositionOperator).equals("max")){
                            result = determine(result, equations.get(currentPositionOperator), nextNum);
                        } else {
                            valid = false;
                        }
                    } catch (NumberFormatException ex) {
                        ex.printStackTrace();
                        valid = false;
                        break;
                    }
                    currentPositionOperator += 2;
                }
            }
            if(valid){
                return result;
            }else {
                return -1;
            }
        }
    }

    int determine(int num1, String operator, int num2){
        if(operator.equals("+")){
            return num1+num2;
        }else if(operator.equals("-")){
            return num1-num2;
        }else if(operator.equals("*")){
            return num1*num2;
        }else if(operator.equals("/")){
            return num1/num2;
        }else if(operator.equals("%")){
            return num1%num2;
        }else if(operator.equals("min")){
            return Math.min(num1,num2);
        }else if(operator.equals("max")){
            return Math.max(num1, num2);
        }else{
            return (int)Math.pow(num1, num2);
        }
    }

    String print(){
        String temp = "";
        for(int i=0; i<equations.size(); i++){
            temp = temp.concat(equations.get(i));
        }
        return temp;
    }

    void delete(){
        equations.clear();
    }
}
