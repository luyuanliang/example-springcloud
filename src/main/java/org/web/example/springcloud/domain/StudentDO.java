package org.web.example.springcloud.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class StudentDO {

    // 驼峰
    private String studentName;
    // 驼峰
    private String homeaddress;
    // 测试类型
    private Integer age;
    // 测试List
    private List<String> teacherList;
    // 测试List
    private List<Integer> scores;

}
