package com.lucrortek.leetcode;

import sun.print.resources.serviceui_zh_TW;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CowAndBull {

    public static void main(String args[]) {
        System.out.println("Cow And Bull");
        int[] secret = {1, 2, 3, 4};
        int[] guess = {4, 3, 2, 1};

        solution1(secret, guess);
        solution2(secret, guess);
        solution3(secret, guess);

    }

    public static void solution1(int[] secret, int[] guess) {
        System.out.println("solution 1");
        int bull = 0, cow = 0;
        //implementation 1
        for (int s = 0; s < secret.length; s++) {
            int curSecret = secret[s];
            for (int g = 0; g < guess.length; g++) {
                int curGuess = guess[g];
                if (curGuess == curSecret)
                    if (s == g)
                        bull++;
                    else
                        cow++;

            }
        }

        System.out.println("bull " + bull + " cow " + cow);

    }

    public static void solution2(int[] secret, int[] guess) {

        System.out.println("solution 2");
        int bull = 0;
        int cow = 0;

        Map secretMap = new HashMap<Integer, Integer>();

        for (int s = 0; s < secret.length; s++)
            secretMap.put(secret[s], s);

        int curGuess = 0;
        int curGuessPosition = 0;
        for (int g = 0; g < guess.length; g++) {
            curGuess = guess[g];
            curGuessPosition = g;
            if (secretMap.containsKey(curGuess))
                if (((Integer) secretMap.get(curGuess)).equals(curGuessPosition))
                    bull++;
                else
                    cow++;

        }

        System.out.println("bull " + bull + " cow " + cow);
    }

    /**
     * iterate through the secret and guess in one loop
     * if the current secret and guess match,
     * then add bull
     * else if the current secret matches with one of the visisted guess,
     * or current guess matches with one of the visisted secret,
     * then add cow
     *
     * @param secret
     * @param guess
     */
    public static void solution3(int[] secret, int[] guess) {
        System.out.println("CowAndBull.solution3");
        int bull = 0;
        int cow = 0;

        Set visitedSecret = new HashSet<Integer>();
        Set visitedGuess = new HashSet<Integer>();

        int curSecret;
        int curGuess;

        for (int i = 0; i < secret.length; i++) {
            curSecret = secret[i];
            curGuess = guess[i];

            if (curSecret == curGuess)
                bull++;
            else {
                if (visitedSecret.contains(curGuess))
                    cow++;
                if (visitedGuess.contains(curSecret))
                    cow++;
            }

            visitedGuess.add(curGuess);
            visitedSecret.add(curSecret);
        }


        System.out.println("bull " + bull + " cow " + cow);
    }


}
