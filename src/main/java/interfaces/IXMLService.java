package interfaces;

import javax.xml.bind.JAXBException;

public interface IXMLService {


    void createXmlStatisticByLabel() throws JAXBException;

    void createXmlStatisticByGenre() throws JAXBException;

    void createXmlStatisticByFoundationYear() throws JAXBException;

}
