package org.web.example.springcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.web.example.springcloud.query.QueryAccount;
import org.web.example.springcloud.domain.AccountDO;

@Mapper
public interface AccountDAO {

	public AccountDO selectAccountByAccountId(Long accountId);

	public List< AccountDO > selectAccountList(QueryAccount queryAccount);

	public Integer countAccountList(QueryAccount queryAccount);

	public int insertAccount(AccountDO accountDO);

	public int updateAccountByAccountId(AccountDO accountDO);
	
	public List<String> selectDistinctList(QueryAccount queryAccount);

}

