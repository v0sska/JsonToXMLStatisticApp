package interfaces;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface IXMLService {


    void createXmlStatisticByLabel() throws JAXBException, IOException;

    void createXmlStatisticByGenre() throws JAXBException, IOException;

    void createXmlStatisticByFoundationYear() throws JAXBException, IOException;

}
