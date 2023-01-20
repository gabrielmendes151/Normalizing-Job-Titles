package feefo.normalizingjobtitles;

import feefo.normalizingjobtitles.service.Normaliser;
import feefo.normalizingjobtitles.service.NormaliserApacheCommonsService;
import feefo.normalizingjobtitles.service.NormaliserDynamicProgrammingService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


class NormalizingJobTitlesTest {

    private final Normaliser normaliser = new NormaliserDynamicProgrammingService();

    @Test
    public void shouldReturnQuantitySurveyorGivenQuantitiesSuInput() {
        String search = "quantities su";
        String expected = "Quantity surveyor";
        String actual = normaliser.normalise(search);

        assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void shouldReturnAccountantGivenACcoInput() {
        String search = "ACco";
        String expected = "Accountant";
        String actual = normaliser.normalise(search);

        assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void shouldReturnSoftwareEngineerGivenCSharpEngineerInput() {
        String search = "C# Engineer";
        String expected = "Software engineer";
        String actual = normaliser.normalise(search);

        assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void shouldReturnArchitectGivenCAcInput() {
        String search = "CAc";
        String expected = "Architect";
        String actual = normaliser.normalise(search);

        assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void shouldReturnDefaultMessageGivenEmptyInput() {
        String search = "";
        String expected = "Was not possible normaliser this input";
        String actual = normaliser.normalise(search);

        assertThat(expected).isEqualTo(actual);
    }
}
