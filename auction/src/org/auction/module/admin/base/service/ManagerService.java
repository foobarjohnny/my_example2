package org.auction.module.admin.base.service;

import org.auction.module.admin.base.data.ManagerData;
import org.mobile.common.exception.GeneralException;

public interface ManagerService {
	
	public void delete(ManagerData model) throws GeneralException;
	
	public void search(ManagerData model) throws GeneralException;

	public void forwardInfo(ManagerData model) throws GeneralException;

	public void saveInfo(ManagerData model) throws GeneralException;
}
