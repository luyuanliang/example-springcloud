package org.web.example.springcloud.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DogDO {

    private String studentName;
    private String dogName;
    private Integer dogAge;
    private StudentDO studentDO;
}
