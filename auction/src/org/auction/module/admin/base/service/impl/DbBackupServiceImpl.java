package org.auction.module.admin.base.service.impl;

import java.util.Date;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.auction.entity.TsDbBackup;
import org.auction.module.admin.base.data.DbBackupData;
import org.auction.module.admin.base.service.DbBackupService;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.service.GeneralService;
import org.mobile.common.util.BeanProcessUtils;
import org.mobile.common.util.Constant;

/**
 * [类说明]：具体实现数据库备份的操作
 * [注意事项]：
 * @author 郭昕
 *
 */
public class DbBackupServiceImpl extends GeneralService implements DbBackupService {

	public boolean backup(DbBackupData model) throws GeneralException {
		//TODO 注意这里只是将指定目录下面的所有文件进行拷贝， 如果有子目录的话，将不进行拷贝。
		// TODO 首先根据前台指定的路径信息，拷贝文件，然后将拷贝后的记录写入数据库表中。
		
		File srcDir = new File(model.getSrcDir());
		File destDir = new File(model.getDestDir());
		if(srcDir.isDirectory()){
			try{
				File[] list = srcDir.listFiles();
				if(!destDir.exists()){
					destDir.mkdirs();
				}
				for(File file : list){
					if(file.isFile()){
						File destFile = new File(destDir.getAbsolutePath() + File.separator + file.getName());
						FileInputStream input = new FileInputStream(file);
						FileOutputStream output = new FileOutputStream(destFile);
						byte[] b = new byte[1024 * 5];   
		                int len;   
		                while ((len = input.read(b)) != -1) {   
		                    output.write(b, 0, len);   
		                }   
						output.flush();
						output.close();
						input.close();
					}
				}
				TsDbBackup bean = new TsDbBackup();
				BeanProcessUtils.copyProperties(bean, model);
				bean.setBackupNum(list.length);
				bean.setBackupTime(new Date(System.currentTimeMillis()));
				bean.setIsValid(Constant.YES);
				generalDao.save(bean);
				
			}catch(IOException ioe){
				ioe.printStackTrace();
				throw new GeneralException("备份文件的过程出错， 请检查后重新备份！");
			}catch(Exception e){
				e.printStackTrace();
				throw new GeneralException("备份文件的过程出错， 请检查后重新备份！");
			}
						
			return true;
		}else{
			throw new GeneralException("数据库的原路径不存在！");
		}
	}
}
