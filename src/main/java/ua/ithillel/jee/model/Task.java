package ua.ithillel.jee.model;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(exclude = {"status"})
public class Task {
    private String name;
    private boolean status;
}
