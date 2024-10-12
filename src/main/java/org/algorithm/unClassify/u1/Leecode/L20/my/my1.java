package org.algorithm.unClassify.u1.Leecode.L20.my;

import java.util.HashMap;
import java.util.Stack;

public class my1 {
    public boolean isValid(String s) {
        Stack<Character> Schars = new Stack<Character>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if(c=='(' || c=='{'|| c=='['){
                Schars.push(c);
                continue;
            }
            if(c==')'){
                if(!Schars.empty()&&Schars.pop().charValue()==c+1) continue;
                else return false;
            }
            if(c=='}'){
                if(!Schars.empty()&&Schars.pop().charValue()==c+2) continue;
                else return false;

            }
            if(c==']'){
                if(!Schars.empty()&&Schars.pop().charValue()==c+2) continue;
                else return false;

            }




        }
       return Schars.empty()?true:false;



    }

    public boolean isValid2(String s) {
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put(')','(');
        hashMap.put('}','{');
        hashMap.put(']','[');
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : charArray) {
            if(hashMap.containsKey(c)){
                if(!stack.empty()&&stack.pop().charValue()==hashMap.get(c)){
                    continue;
                }else {
                    return false;
                }
            }else {
                stack.push(c);
            }


        }
        return  stack.empty()?true:false;
//        stack.empty();
//        stack.isEmpty();


    }


    public static void main(String args[]){
        //char grade = args[0].charAt(0);
        char grade = 'C';

        switch(grade)
        {
            case 'A' :
                System.out.println("优秀");
                break;
            case 'B' :
            case 'C' :
                System.out.println("良好");
                break;
            case 'D' :
                System.out.println("及格");
                break;
            case 'F' :
                System.out.println("你需要再努力努力");
                break;
            default :
                System.out.println("未知等级");
        }
        System.out.println("你的等级是 " + grade);
    }
}
