package com.elrast;

import java.util.HashMap;
import java.util.Map;

public class CircleMaker {

    public boolean judgeCircle(String moves) {

        if (moves.isEmpty())
            return true;
        if (moves.length() % 2 != 0)
            return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : moves.toCharArray()) {
            int count = map.getOrDefault(ch, 0);
            map.put(ch, ++count);
        }
        int up = map.getOrDefault('U', 0);
        int down = map.getOrDefault('D', 0);
        if (up != down) {
            return false;
        }
        int right = map.getOrDefault('R', 0);
        int left = map.getOrDefault('L', 0);
        return left == right;
    }

    public boolean judgeCircle2(String moves) {

        if (moves.isEmpty())
            return true;
        int xVal = 0, yVal = 0;
        for (char ch : moves.toCharArray()) {
            switch (ch) {
                case 'U':
                    yVal++;
                    break;
                case 'D':
                    yVal--;
                    break;
                case 'R':
                    xVal++;
                    break;
                default:
                    xVal--;
                    break;
            }

        }
        return xVal == 0 && yVal == 0;

    }

    public boolean judgeCircle3(String moves) {
        moves = " " + moves + " ";
        return moves.split("L").length == moves.split("R").length && moves.split("U").length == moves.split("D").length;
    }
}
