package org.save1.String1.Leecode.L8myAtoi.cp;

class cp1 {
    public static  int myAtoi(String s) {
        int sign = 1, ans = 0, index = 0;
        char[] array = s.toCharArray();
        while (index < array.length && array[index] == ' ') {
            index ++;
        }
        if (index < array.length && (array[index] == '-' || array[index] == '+')) {
            sign = array[index++] == '-' ? -1 : 1;
        }
        while (index < array.length && array[index] <= '9' && array[index] >= '0') {
            int digit = array[index++] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + digit;
        }
        return ans * sign;
    }

    public static void main(String[] args){
        long x=(Integer.MAX_VALUE)*-1;
        String s=String.valueOf(x);
//        s="-42";
        System.out.println(myAtoi(s));
        System.out.println(x);
        System.out.println(Integer.MIN_VALUE);

    }
}