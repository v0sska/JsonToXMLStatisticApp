package statistic;

import interfaces.IJsonParser;
import interfaces.IStatisticCalculator;
import json.JsonParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticCalculator implements IStatisticCalculator {

    private IJsonParser parser = new JsonParser();

    @Override
    public Map<String, Integer> countByLabel() {
        List<String> labels = parser.readJsonFileByLabel();

        Map<String, Integer> labelCount = new HashMap<>();

        for(String label : labels){
            labelCount.put(label, labelCount.getOrDefault(label, 0) + 1);
        }

        return labelCount;
    }

    @Override
    public Map<String, Integer> countByGenre() {
        List<String> genres = parser.readJsonFileByGenre();

        Map<String, Integer> genreCount = new HashMap<>();

        for(String genre : genres){
            genreCount.put(genre, genreCount.getOrDefault(genre, 0) + 1);
        }

        return genreCount;
    }

    @Override
    public Map<String, Integer> countByYearOfFoundation() {
        List<String> years = parser.readJsonFileByYearOfFoundation();

        Map<String, Integer> yearCount = new HashMap<>();

        for(String year : years){
            yearCount.put(year, yearCount.getOrDefault(year, 0) + 1);
        }

        return yearCount;
    }
}