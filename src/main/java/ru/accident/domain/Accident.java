package ru.accident.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Accident {
    private int id;
    private String name;
    private String text;
    private String address;
}
