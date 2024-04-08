package interfaces;

import java.util.List;

public interface IJsonParser {

    List<String> readJsonAndAddToList();

    List<String> readJsonFileByGenre();

    List<String> readJsonFileByLabel();

    List<String> readJsonFileByYearOfFoundation();
}
