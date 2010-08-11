package org.auction.module.admin.user.service;

import org.auction.module.admin.user.data.UserData;
import org.mobile.common.bean.LoginBean;
import org.mobile.common.exception.GeneralException;

public interface UserService {

	public void forward(UserData model) throws GeneralException;

	public void save(UserData model) throws GeneralException;

	public void delete(UserData model) throws GeneralException;

	public void search(UserData model) throws GeneralException;
	
	public boolean login(UserData model) throws GeneralException;
	
	public void regedit(UserData model) throws GeneralException;
	
	public void view(UserData model) throws GeneralException;
	
	public void update(UserData model) throws GeneralException;
	
	public LoginBean loginDwr(UserData model) throws GeneralException;
	
}
