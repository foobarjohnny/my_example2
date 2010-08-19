package org.auction.module.admin.base.service;

import org.auction.module.admin.base.data.DbBackupData;
import org.mobile.common.exception.GeneralException;

/**
 * [类说明]： 实现数据库备份的接口
 * [注意事项]：
 * @author 郭昕
 *
 */
public interface DbBackupService {

	public boolean backup(DbBackupData model) throws GeneralException;
}
