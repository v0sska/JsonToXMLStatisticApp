package entity;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "statistic")
@Getter
@Setter
public class XMLEntity {

    @XmlElement(name = "item")
    private List<Item> items;

}

@Getter
@Setter
class Item{

    @XmlElement
    private String value;

    @XmlElement
    private int count;

}
