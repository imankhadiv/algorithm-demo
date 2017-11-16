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

        for (int i = 2; i < Math.sqrt(number); i++) {
            for (int j = 1; j < Math.sqrt(number); j++) {
                if (j * i == number) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isPrimeNumberSqrt2(int number) {

        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        for (int i = 3; i < Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public String convertToBase(int number, int base) {
        String result = "";
        while (number >= base) {

            result = number % base + result;
            number /= base;
        }
        return number + result;
    }

    public String convertToBase2(int number, int base) {
        if (number < base) {
            return number + "";
        }
        return convertToBase(number / base, base) + number % base;
    }

    public int findTheGreatestCommonDenominator(int num1, int num2) {

        int smallerNumber = num1 >= num2 ? num2 : num1;
        int result = num1 >= num2 ? num1 % num2 : num2 % num1;
        if (result == 0) return num1 >= num2 ? num2 : num1;

        int sqrtVal = ((Double) (Math.floor(Math.sqrt(smallerNumber)))).intValue();

        for (int i = sqrtVal; i > 1; i--) {
            if (num1 % i == 0) {
                int div = num1 / i;
                if (num2 % i == 0) {
                    return i;
                } else if (num2 % div == 0) {
                    return div;
                }
            }
        }
        return 1;
    }

    public int gcd(int num1, int num2) {

        if (num2 == 0) {
            return num1;
        }
        return gcd(num2, num1 % num2);
    }

    public int factorial(int number) {

        if (number <= 1) {
            return 1;
        }
        return number * factorial(--number);
    }
}