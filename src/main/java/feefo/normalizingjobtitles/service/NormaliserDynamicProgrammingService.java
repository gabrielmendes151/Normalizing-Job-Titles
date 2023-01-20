package feefo.normalizingjobtitles.service;

import org.springframework.util.ObjectUtils;


import static feefo.normalizingjobtitles.utils.Contants.*;

public class NormaliserDynamicProgrammingService implements Normaliser {

    @Override
    public String normalise(String input) {
        float distance = MAX_DISTANCE;
        String result = DEFAULT_RESULT;
        if (!ObjectUtils.isEmpty(input)) {
            for (String job : JOBS) {
                if (job.equals(input)) {
                    result = job;
                    break;
                }
                float currentDistance = getMinimumDistance(input, job);
                currentDistance = currentDistance / job.length();

                if (currentDistance < distance) {
                    distance = currentDistance;
                    result = job;
                }
            }
        }
        return result;
    }

    private int getMinimumDistance(String word1, String word2) {
        var word1Size = word1.length();
        var word2Size = word2.length();

        int[][] matriz = new int[word1Size + 1][word2Size + 1];

        for (int i = 0; i <= word1Size; i++) {
            matriz[i][0] = i;
        }

        for (int j = 0; j <= word2Size; j++) {
            matriz[0][j] = j;
        }

        for (int i = 0; i < word1Size; i++) {
            Character c1 = word1.charAt(i);
            for (int j = 0; j < word2Size; j++) {
                Character c2 = word2.charAt(j);

                if (c1.equals(c2)) {
                    matriz[i + 1][j + 1] = matriz[i][j];
                } else {
                    int replace = matriz[i][j] + 1;
                    int insert = matriz[i][j + 1] + 1;
                    int delete = matriz[i + 1][j] + 1;

                    int min = Math.min(replace, insert);
                    min = Math.min(delete, min);
                    matriz[i + 1][j + 1] = min;
                }
            }
        }
        return matriz[word1Size][word2Size];
    }
}
