package com.training.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.jpa.dao.UserDao;
import com.training.jpa.domain.AccountInfo;
import com.training.jpa.domain.UserInfo;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Transactional
    public AccountInfo createNewAccount(String username, String password, Integer initBalance) {
        AccountInfo accountInfo = new AccountInfo();

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setPassword(password);

        accountInfo.setBalance(initBalance);
        accountInfo.setUserInfo(userInfo);

        return userDao.save(accountInfo);
    }

    public AccountInfo findAccountInfoById(Long id)
    {
        return userDao.findOne(id);
    }

    public List<AccountInfo> findByBalanceGreaterThan(Integer balance,Pageable pageable){
        Page<AccountInfo> accounts = userDao.findByBalanceGreaterThan(balance,pageable);
        return accounts.getContent();
    }

	public void updateAccountInfo(Long accountId, UserInfo newInfo) {
		AccountInfo account = userDao.findOne(accountId);
		if (null != account){
			account.getUserInfo().setPassword(newInfo.getPassword());
			account.getUserInfo().setUsername(newInfo.getUsername());
		}
		userDao.save(account);
	}

	public void deleteAccountInfo(Long accountId) {
		userDao.delete(accountId);		
	}

	public List<AccountInfo> findAccountsByName(String name) {		
		List<AccountInfo> accounts = userDao.findAccountsByName(name + "%");
		return accounts;
	}
}
