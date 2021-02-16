/**
 * @Description AccountService is generated by the auto build Tools.
 * @author LUYL
 * @time 2020-12-22 14:41:32
 */

package org.web.example.springcloud.service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import org.web.example.springcloud.query.QueryAccount;
import org.web.example.springcloud.domain.AccountDO;
import org.web.example.springcloud.dao.AccountDAO;
import org.web.exception.ServiceException;

@Service("accountService")
public class AccountService {

	private static Logger logger = Logger.getLogger(AccountService.class);

	@Resource
	private AccountDAO accountDAO;

	/**
	 * @Decription 根据主键查询记录
	 * @param accountId
	 * @author LUYL
	 * @date 2020-12-22 14:41:32
	 * @return 返回唯一记录Account.
	 */
	public AccountDO selectAccountByAccountId ( Long accountId) throws ServiceException {
		if(accountId == null){
			throw new ServiceException("PARAM_IS_EMPTY","Query is null.");
		}
		return accountDAO.selectAccountByAccountId(accountId);
	}

	/**
	 * @Decription 根据查询条件,返回List.
	 * @param queryAccount 封装了查询条件对象.
	 * @author LUYL
	 * @date 2020-12-22 14:41:32
	 * @return 返回一组记录.
	 */
	public List< AccountDO > selectAccountList(QueryAccount queryAccount) throws ServiceException {

		if (queryAccount == null) {
			throw new ServiceException("PARAM_IS_EMPTY","Query is null.");
		}
		//TODO
		setDefaultQuery(queryAccount);
		return accountDAO.selectAccountList( queryAccount );
	}

	/**
	 * @Decription 根据查询条件,返回map,map中的KEY是表的主键accountId.
	 * @param queryAccount 封装了查询条件对象.
	 * @author LUYL
	 * @date 2020-12-22 14:41:32
	 * @return 返回一组记录，以主键做为KEY的MAP.
	 */
	public Map< Long, AccountDO > selectAccountMapForAccountId(QueryAccount queryAccount) throws ServiceException {

		if (queryAccount == null) {
			throw new ServiceException("PARAM_IS_EMPTY","Query is null.");
		}
		//TODO
		setDefaultQuery(queryAccount);
		List< AccountDO >  list = accountDAO.selectAccountList( queryAccount );
		Map<  Long, AccountDO > map = new HashMap<>();
		for ( AccountDO accountDO : list) {
			map.put(accountDO.getAccountId(), accountDO);
		}
		return map;
	}


	/**
	 * @Decription 根据查询条件,查询满足条件的记录数.
	 * @param queryAccount 封装了查询条件对象.
	 * @author LUYL
	 * @date 2020-12-22 14:41:32
	 * @return 返回查询条件返回的记录总数.
	 */
	public Integer countAccountList(QueryAccount queryAccount) throws ServiceException {
		if (queryAccount == null) {
			throw new ServiceException("PARAM_IS_EMPTY","Query is null.");
		}
		setDefaultQuery(queryAccount);
		return accountDAO.countAccountList( queryAccount );
	}

	/**
	 * 默认不查询逻辑删除的数据
	 */
	private void setDefaultQuery(QueryAccount queryAccount){
		if (StringUtils.isEmpty(queryAccount.getIsDelete())) {
			queryAccount.setIsDelete("NO");
		}
		if (StringUtils.isEmpty(queryAccount.getOrderByClause())) {
			//queryAccount.setOrderByClause("  updateDate DESC ");
		}
	}

	/**
	 * @Decription 根据查询条件,返回第一条记录.
	 * @param queryAccount 封装了查询条件对象.
	 * @author LUYL
	 * @date 2020-12-22 14:41:32
	 * @return 返回第一条记录.
	 */
	public AccountDO selectOneAccount (QueryAccount queryAccount) throws ServiceException {
		queryAccount.setFirstRecord();
		List<AccountDO> list = accountDAO.selectAccountList( queryAccount );
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	/**
	 * @Decription 根据查询条件,查询不重复信息.
	 * @param queryAccount 封装了查询条件对象.
	 * @author LUYL
	 * @date 2020-12-22 14:41:32
	 * @return 返回不重复信息.
	 */
	public List<String> selectDistinctList(QueryAccount queryAccount)throws ServiceException {
		if(StringUtils.isEmpty(queryAccount.getIsDelete())){
			queryAccount.setIsDelete("NO");
		}
		return accountDAO.selectDistinctList(queryAccount);
	}


	/**
	 * @Decription 插入一条新记录.
	 * @param accountDO 封装新增的对象.
	 * @author LUYL
	 * @date 2020-12-22 14:41:32
	 * @return 返回原始对象，如果用到数据库自增主键，并会自动设置新增主键.
	 */
	public AccountDO insertAccount(AccountDO accountDO)throws ServiceException {
		// check params first.
		checkInsert(accountDO);

		// TODO add default value.

		accountDAO.insertAccount(accountDO);
		return accountDO;
	}

	/**
	 * @Decription 根据主键修改记录.
	 * @param accountDO 封装修改的对象.
	 * @author LUYL
	 * @date 2020-12-22 14:41:32
	 * @return 返回修改记录数.
	 */
	public int updateAccountByAccountId(AccountDO accountDO)throws ServiceException {
		// check params first.
		checkUpdate(accountDO);

		return accountDAO.updateAccountByAccountId(accountDO);

	}

	/**
	 * According to DB info. check attribute allow empty or not, and check attribute's length is over upper limit of length or not.
	 * and this method is generate by the auto build tool.
	 */
	@SuppressWarnings({"deprecation" })
	private void checkInsert(AccountDO accountDO) throws ServiceException {
		if( accountDO == null){
			throw new ServiceException("PARAM_IS_EMPTY","Query is null.");
		}
		else if (accountDO.getAccountId()==null
				|| (accountDO.getAccountId()!=null && String.valueOf(accountDO.getAccountId()).length() > 11)) {
			throw new ServiceException("PARAM_IS_INVALID","AccountId is null or out of range, Upper limit of length is 11");
		}
		else if (StringUtils.isEmpty(accountDO.getAccountName())
				|| (StringUtils.isNotEmpty(accountDO.getAccountName()) && accountDO.getAccountName().length() > 255)) {
			throw new ServiceException("PARAM_IS_INVALID","AccountName is null or out of range, Upper limit of length is 255");
		}
		else if (accountDO.getAccountNo()==null
				|| (accountDO.getAccountNo()!=null && String.valueOf(accountDO.getAccountNo()).length() > 255)) {
			throw new ServiceException("PARAM_IS_INVALID","AccountNo is null or out of range, Upper limit of length is 255");
		}
		else if (StringUtils.isEmpty(accountDO.getIsDelete())
				|| (StringUtils.isNotEmpty(accountDO.getIsDelete()) && accountDO.getIsDelete().length() > 0)) {
			throw new ServiceException("PARAM_IS_INVALID","IsDelete is null or out of range, Upper limit of length is 0");
		}

	}

	@SuppressWarnings({"deprecation" })
	private void checkUpdate(AccountDO accountDO) throws ServiceException {
		if( accountDO == null){
			throw new ServiceException("PARAM_IS_EMPTY","Query is null.");
		}
		else if (accountDO.getAccountId()!=null && String.valueOf(accountDO.getAccountId()).length() > 11) {
			throw new ServiceException("UPDATE_ERROR","AccountId is out of range, Upper limit of length is 11");
		}
		else if (StringUtils.isNotEmpty(accountDO.getAccountName()) && accountDO.getAccountName().length() > 255) {
			throw new ServiceException("UPDATE_ERROR","AccountName is out of range, Upper limit of length is 255");
		}
		else if (accountDO.getAccountNo()!=null && String.valueOf(accountDO.getAccountNo()).length() > 255) {
			throw new ServiceException("UPDATE_ERROR","AccountNo is out of range, Upper limit of length is 255");
		}
		else if (StringUtils.isNotEmpty(accountDO.getIsDelete()) && accountDO.getIsDelete().length() > 0) {
			throw new ServiceException("UPDATE_ERROR","IsDelete is out of range, Upper limit of length is 0");
		}
	}
}



