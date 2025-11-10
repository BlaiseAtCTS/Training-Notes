package org.FInal;

public class Main {
    public static void main(String[] args) {
        String str = "t$m$$r$$$w";
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);

        }
        String res = "";
        char[] arr = str.toCharArray();
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == '$') {
                res += 'o';
            } else {
                res += arr[i];
            }
        }
        System.out.println(res);
    }
}
