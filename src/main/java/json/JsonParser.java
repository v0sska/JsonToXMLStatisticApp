package json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.JsonEntity;
import interfaces.IJsonParser;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


public class JsonParser implements IJsonParser {

    private final ObjectMapper mapper = new ObjectMapper();


    @Override
    public List<String> readJsonAndAddToList(){
        return null;
    }

    @Override
    public List<String> readJsonFileByGenre() {
        List<JsonEntity> entityList = null;

        try {
            entityList = mapper.readValue(new File("src/main/resources/files_to_read/statistic1.json"), new TypeReference<List<JsonEntity>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<String> genres = entityList.stream()
                .map(JsonEntity::getGenre)
                .collect(Collectors.toList());

        return genres;
    }

    @Override
    public List<String> readJsonFileByLabel() {
        List<JsonEntity> entityList = null;

        try {
            entityList = mapper.readValue(new File("src/main/resources/files_to_read/statistic1.json"), new TypeReference<List<JsonEntity>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<String> labels = entityList.stream()
                .map(JsonEntity::getLabel)
                .collect(Collectors.toList());

        return labels;
    }

    @Override
    public List<String> readJsonFileByYearOfFoundation() {
        List<JsonEntity> entityList = null;

        try {
            entityList = mapper.readValue(new File("src/main/resources/files_to_read/statistic1.json"), new TypeReference<List<JsonEntity>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<String> foundationYears = entityList.stream()
                .map(JsonEntity::getFoundedYear)
                .collect(Collectors.toList());

        return foundationYears;
    }
}
