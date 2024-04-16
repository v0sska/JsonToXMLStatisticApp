package interfaces;

import java.util.List;

public interface IJsonParser {

    List<String> readJsonAndAddToList();

    List<String> readJsonFileByGenre(String fileName);

    List<String> readJsonFileByLabel(String fileName);

    List<String> readJsonFileByYearOfFoundation(String fileName);
}
