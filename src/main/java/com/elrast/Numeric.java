package com.elrast;

public class Numeric {

    public boolean isPrime(int number) {
        //BigO(N)
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPrimeNumber(int number) {
        //O(N/2)
        int remainder = number % 2;
        if (remainder == 0 && number > 2) {
            return false;
        }
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPrimeNumberSqrt(int number) {

        for (int i = 2; i < number; i++) {
            for (int j = 1; j < Math.sqrt(number); j++) {
                if (j * i == number) {
                    return false;
                }
            }
        }
        return true;
    }

//    public boolean isPrimeNumber2(int number) {
//
//        if(number <= 3){
//            return true;
//        }
//        if(number % 2 == 0 || number % 3 == 0){
//            return false;
//        }
//    }
}
