import interfaces.IJsonParser;
import json.JsonParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import statistic.StatisticCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class StatisticCalculatorTest {

    @Test
   public void countByLabelTest(){

        List<String> labels = Arrays.asList("Label1", "Label2", "Label1", "Label3", "Label2", "Label1");

        IJsonParser parserMock = mock(JsonParser.class);
        when(parserMock.readJsonFileByLabel()).thenReturn(labels);

        StatisticCalculator calculator = new StatisticCalculator();
        calculator.setParser(parserMock);

        Map<String, Integer> result = calculator.countByLabel();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(3, result.size());
        org.assertj.core.api.Assertions.assertThat(result.get("Label1")).isEqualTo(3);
        org.assertj.core.api.Assertions.assertThat(result.get("Label2")).isEqualTo(2);
        org.assertj.core.api.Assertions.assertThat(result.get("Label3")).isEqualTo(1);

    }

    @Test
    public void countByGenresTest(){

        List<String> genres = Arrays.asList("Pop", "Rock", "Hip-Hop", "Rock", "Hip-Hop", "Pop");

        IJsonParser parserMock = mock(JsonParser.class);
        when(parserMock.readJsonFileByGenre()).thenReturn(genres);

        StatisticCalculator calculator = new StatisticCalculator();
        calculator.setParser(parserMock);

        Map<String, Integer> result = calculator.countByGenre();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(3, result.size());
        org.assertj.core.api.Assertions.assertThat(result.get("Pop")).isEqualTo(2);
        org.assertj.core.api.Assertions.assertThat(result.get("Rock")).isEqualTo(2);
        org.assertj.core.api.Assertions.assertThat(result.get("Hip-Hop")).isEqualTo(2);
    }

    @Test
    public void countByYearOfFoundationTest(){

        List<String> years = Arrays.asList("2001", "2003", "2006", "2001", "2001", "2001");

        IJsonParser parserMock = mock(JsonParser.class);
        when(parserMock.readJsonFileByYearOfFoundation()).thenReturn(years);

        StatisticCalculator calculator = new StatisticCalculator();
        calculator.setParser(parserMock);

        Map<String, Integer> result = calculator.countByYearOfFoundation();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(3, result.size());
        org.assertj.core.api.Assertions.assertThat(result.get("2001")).isEqualTo(4);
        org.assertj.core.api.Assertions.assertThat(result.get("2003")).isEqualTo(1);
        org.assertj.core.api.Assertions.assertThat(result.get("2006")).isEqualTo(1);
    }

}
