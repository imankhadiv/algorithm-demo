package com.elrast;

public class Fibonacci {

    static long[] fibCache = new long[2000];

    public static int fibonacci(int n) {
        if (n <= 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static long cacheFibonacci(int n) {
        if (n <= 1) {
            fibCache[n] = 1;
        }
        if (fibCache[n] == 0) {
            fibCache[n] = fibonacci(n - 1) + fibonacci(n - 2);
        }
        return fibCache[n];
    }

    public static void main(String[] args) {

        System.out.println(cacheFibonacci(50));
    }
}
