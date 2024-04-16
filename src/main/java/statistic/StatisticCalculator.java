package statistic;

import interfaces.IJsonParser;
import interfaces.IStatisticCalculator;
import json.JsonParser;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class StatisticCalculator implements IStatisticCalculator {

    private IJsonParser parser = new JsonParser();

    @Override
    public Map<String, Integer> countByLabel() {
        List<String> labels = parser.readJsonFileByLabel();

        Map<String, Integer> labelCount = new HashMap<>();

        for(String label : labels){
            labelCount.put(label, labelCount.getOrDefault(label, 0) + 1);
        }

        return sortFromBiggerToSmaller(labelCount);
    }

    @Override
    public Map<String, Integer> countByGenre() {
        List<String> genres = parser.readJsonFileByGenre();

        Map<String, Integer> genreCount = new HashMap<>();

        for(String genre : genres){
            genreCount.put(genre, genreCount.getOrDefault(genre, 0) + 1);
        }

        return sortFromBiggerToSmaller(genreCount);
    }

    @Override
    public Map<String, Integer> countByYearOfFoundation() {
        List<String> years = parser.readJsonFileByYearOfFoundation();

        Map<String, Integer> yearCount = new HashMap<>();

        for(String year : years){
            yearCount.put(year, yearCount.getOrDefault(year, 0) + 1);
        }

        return sortFromBiggerToSmaller(yearCount);
    }

    private Map<String, Integer> sortFromBiggerToSmaller(Map<String, Integer> noSortedMap){

        List<Map.Entry<String, Integer>> list = new ArrayList<>(noSortedMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}