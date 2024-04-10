package interfaces;

import java.util.Map;

public interface IStatisticCalculator {
    Map<String, Integer> countByLabel();

    Map<String, Integer> countByGenre();

    Map<String, Integer> countByYearOfFoundation();
}
