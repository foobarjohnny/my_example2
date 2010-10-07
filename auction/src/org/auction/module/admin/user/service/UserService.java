package org.auction.module.admin.user.service;

import org.auction.module.admin.user.data.UserData;
import org.mobile.common.bean.LoginBean;
import org.mobile.common.exception.GeneralException;

public interface UserService {

	public void forward(UserData model) throws GeneralException;
	
	public void forwardAdmin(UserData model) throws GeneralException;

	public void save(UserData model) throws GeneralException;

	public void delete(UserData model) throws GeneralException;

	public void search(UserData model) throws GeneralException;

	public boolean login(UserData model) throws GeneralException;

	public void regedit(UserData model) throws GeneralException;
	
	public void reg(UserData model) throws GeneralException;

	public void view(UserData model) throws GeneralException;

	public void update(UserData model) throws GeneralException;

	public LoginBean loginDwr(UserData model) throws GeneralException;
	
	public void regForward(UserData model) throws Exception;
	
	public void send(UserData model) throws Exception;
	
	public void invitePage(UserData model) throws Exception;
	
	public void invite(UserData model) throws Exception;
	
	public boolean checkedUser(UserData model) throws Exception;
	
	public String checkedECount(UserData model) throws Exception;
	
	public String deleteCount(UserData model) throws Exception;

}
