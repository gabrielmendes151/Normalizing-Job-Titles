package feefo.normalizingjobtitles;

import feefo.normalizingjobtitles.service.Normaliser;
import feefo.normalizingjobtitles.service.NormaliserDynamicProgrammingService;

public class Main {

    public static void main(String[] args) {
        String jt = "Java engineer";
        Normaliser n = new NormaliserDynamicProgrammingService();
        String normalisedTitle = n.normalise(jt);
        System.out.println(normalisedTitle);
        jt = "C# engineer";
        normalisedTitle = n.normalise(jt);
        System.out.println(normalisedTitle);
        jt = "Chief Accountant";
        normalisedTitle = n.normalise(jt);
        System.out.println(normalisedTitle);
        jt = "";
        normalisedTitle = n.normalise(jt);
        System.out.println(normalisedTitle);
    }
}
