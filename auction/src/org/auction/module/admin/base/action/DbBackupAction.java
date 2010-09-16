package org.auction.module.admin.base.action;

import org.auction.module.admin.base.data.DbBackupData;
import org.auction.module.admin.base.service.DbBackupService;
import org.mobile.common.action.GeneralAction;
import org.mobile.common.exception.GeneralException;

public class DbBackupAction extends GeneralAction<DbBackupData> {

	private static final long serialVersionUID = 1L;

	private DbBackupData model = new DbBackupData();

	private DbBackupService service;

	public DbBackupData getModel() {
		return model;
	}

	public void setService(DbBackupService service) {
		this.service = service;
	}

	public String backup() throws GeneralException {
		if (service.backup(model)) {
			return "OK";
		} else {
			return "ERROR";
		}
	}
}
