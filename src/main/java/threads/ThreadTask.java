package threads;

import interfaces.IJsonParser;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ThreadTask extends Thread {

    private IJsonParser parser;

    private String fileName;

    @Override
    public void run() {
        parser.readJsonFileByGenre(fileName);
    }

}
