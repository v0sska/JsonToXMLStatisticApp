import json.JsonParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;


public class JsonParserTest {

    @Test
    public void readJsonFileByLabelTest(){
        List<String> expectedLabels = Arrays.asList("Capitol Records", "Warner Music Group", "Island Records", "Universal Music Group", "Def Jam Recordings");

        JsonParser mockParser = mock(JsonParser.class);

        when(mockParser.readJsonFileByLabel()).thenReturn(expectedLabels);

        List<String> resultLabels = mockParser.readJsonFileByLabel();

        Assertions.assertNotNull(resultLabels);
        Assertions.assertEquals(5, resultLabels.size());
        org.assertj.core.api.Assertions.assertThat(resultLabels).containsExactly("Capitol Records", "Warner Music Group", "Island Records", "Universal Music Group", "Def Jam Recordings");

    }

    @Test
    public void readJsonFileByGenreTest(){
        List<String> expectedGenres = Arrays.asList("Rock", "Pop", "Hip-Hop", "Disco", "R&B");

        JsonParser mockParser = mock(JsonParser.class);

        when(mockParser.readJsonFileByGenre()).thenReturn(expectedGenres);

        List<String> resultGenres = mockParser.readJsonFileByGenre();

        Assertions.assertNotNull(resultGenres);
        Assertions.assertEquals(5, resultGenres.size());
        org.assertj.core.api.Assertions.assertThat(resultGenres).containsExactly("Rock", "Pop", "Hip-Hop", "Disco", "R&B");

    }

    @Test
    public void readJsonFileByYearOfFoundationTest(){
        List<String> expectedYears = Arrays.asList("1996", "2005", "1945", "2011", "2003");

        JsonParser mockParser = mock(JsonParser.class);

        when(mockParser.readJsonFileByYearOfFoundation()).thenReturn(expectedYears);

        List<String> resultYears = mockParser.readJsonFileByYearOfFoundation();

        Assertions.assertNotNull(resultYears);
        Assertions.assertEquals(5, resultYears.size());
        org.assertj.core.api.Assertions.assertThat(resultYears).containsExactly("1996", "2005", "1945", "2011", "2003");

    }
}