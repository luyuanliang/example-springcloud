package org.web.example.springcloud.query;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
import org.web.domain.QueryBase;

@Setter
@Getter
public class QueryAccount extends QueryBase {


    private Long accountId;

    private List<Long> accountIdList;

    private String accountName;

    private List<String> accountNameList;

    private Long accountNo;
}

