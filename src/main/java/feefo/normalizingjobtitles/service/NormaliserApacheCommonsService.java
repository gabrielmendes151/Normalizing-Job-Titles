package feefo.normalizingjobtitles.service;

import org.apache.commons.text.similarity.LevenshteinDistance;

import static feefo.normalizingjobtitles.utils.Contants.*;

public class NormaliserApacheCommonsService implements Normaliser {

    @Override
    public String normalise(String input) {
        float distance = MAX_DISTANCE;
        String result = DEFAULT_RESULT;
        LevenshteinDistance levenshtein = new LevenshteinDistance();
        for (String job : JOBS) {
            float currentDistance = levenshtein.apply(job, input);
            currentDistance = currentDistance / job.length();

            if (currentDistance <= distance) {
                distance = currentDistance;
                result = job;
            }
        }
        return result;
    }
}
