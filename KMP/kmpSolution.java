package com.hangj.leetcode.KMP;

public class kmpSolution {

    public static void main(String[] args) {
        String text = "ababcabcacbab";
        String pattern = "abcac";

        // 调用 KMP 算法匹配字符串
        int result = KMPMatch(text, pattern);
        System.out.println("文本: " + text);
        System.out.println("模式串: " + pattern);
        System.out.println("匹配位置: " + (result == -1 ? "未找到" : result));

    }



    // 使用kmp算法匹配字符串
    public static int KMPMatch(String text, String pattern){  // 返回子串匹配的其实位置
        int n = text.length();
        int m = pattern.length();

        // 特殊情况处理
        if(m == 0){
            return 0;  // 空字符串匹配起始位置一定是位置0
        }
        if(n == 0 ||  n < m){
            return -1;  // 子串长度比文本长度大，则一定匹配不上
        }

        int[] nexts = computeNext(pattern);
        int j = 0;  // 模式串指针
        for (int i = 0; i < n; i++) {  // i是文本串指针
            while(text.charAt(i) != pattern.charAt(j)){
                j = nexts[j-1];
            }
            if(text.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if(j == m){
                return i-m+1;
            }
        }
        return -1;
    }
    // 计算next数组
    public static int[] computeNext(String s){
        int j = 0;
        int[] Next = new int[s.length()];
        Next[0] = 0;
        for(int i = 1; i < s.length(); i++){
            while(j > 0 && s.charAt(i) != s.charAt(j)){
                j = Next[j-1];
            }

            if(s.charAt(i) == s.charAt(j)){
                j++;
            }

            Next[i] = j;

        }
        return Next;
    }
}
