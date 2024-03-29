package ua.ithillel.jee.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(exclude = {"status"})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Task {
    @XmlElement
    private String name;
    @XmlElement
    private boolean status;
}
