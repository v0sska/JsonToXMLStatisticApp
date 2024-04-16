package json;

import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.JsonEntity;
import interfaces.IJsonParser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class JsonParser implements IJsonParser {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public List<String> readJsonFileByGenre(String fileName) {
       return readJsonFileByField("genre", fileName);
    }

    @Override
    public List<String> readJsonFileByLabel(String fileName) {
        return readJsonFileByField("label", fileName);
    }

    @Override
    public List<String> readJsonFileByYearOfFoundation(String fileName) {
        return readJsonFileByField("year", fileName);
    }


        private List<String> readJsonFileByField(String field, String fileName) {

            List<String> parameter = new ArrayList<>();

            try (com.fasterxml.jackson.core.JsonParser jsonParser = mapper.getFactory().createParser(new File("src/main/resources/files_to_read/" + fileName + ".json"))) {
                // Переміщення до початку масиву
                while (jsonParser.nextToken() != JsonToken.START_ARRAY) {
                    // Порожній цикл для переміщення парсера до початку масиву
                }

                // Зчитування об'єктів по одному
                while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                    JsonEntity entity = jsonParser.readValueAs(JsonEntity.class);
                    if(field.equals("label"))
                        parameter.add(entity.getLabel());
                    else if(field.equals("genre"))
                        parameter.add(entity.getGenre());
                    else if(field.equals("year"))
                        parameter.add(entity.getFoundedYear());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

           return parameter;

        }
}
