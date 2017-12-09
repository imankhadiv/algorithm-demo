package com.elrast.dp;

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
            fibCache[n] = cacheFibonacci(n - 1) + cacheFibonacci(n - 2);
        }
        return fibCache[n];
    }
}
