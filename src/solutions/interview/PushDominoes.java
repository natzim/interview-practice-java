package solutions.interview;

import java.util.Arrays;

public class PushDominoes {
    public static String pushDominoes(char[] dominoes) {
        int currentForce = 0;
        int maxForce = dominoes.length;
        int[] forces = new int[dominoes.length];

        Arrays.fill(forces, 0);

        for (int index = 0; index < dominoes.length; index++) {
            char domino = dominoes[index];
            if (domino == 'R') {
                currentForce = maxForce;
            } else if (domino == 'L') {
                currentForce = 0;
            } else {
                currentForce = Math.max(0, currentForce - 1);
            }

            forces[index] = currentForce;
        }

        for (int index = dominoes.length - 1; index > -1; index--) {
            char domino = dominoes[index];

            if (domino == 'L') {
                currentForce = maxForce;
            } else if (domino == 'R') {
                currentForce = 0;
            } else {
                currentForce = Math.max(0, currentForce - 1);
            }

            forces[index] -= currentForce;
        }

        StringBuilder result = new StringBuilder();

        for (int force : forces) {
            if (force == 0) {
                result.append(".");
            } else if (force > 0) {
                result.append("R");
            } else {
                result.append("L");
            }
        }

        return result.toString();
    }
}
