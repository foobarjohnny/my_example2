package org.auction.entity;

import java.util.Date;

/**
 * [类说明]：用来记录数据库备份的操作的POJO
 * [注意事项]：
 * @author 郭昕
 *
 */
public class TsDbBackup  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String srcDir;
	private String destDir;
	private Date   backupTime;
	private int    backupNum;
	private String isValid;
	
	public TsDbBackup(){
		
	}
	
	public TsDbBackup(String srcDir, String destDir, Date backupTime, int backupNum, String isValid){
		this.srcDir = srcDir;
		this.destDir = destDir;
		this.backupTime = backupTime;
		this.backupNum = backupNum;
		this.isValid = isValid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSrcDir() {
		return srcDir;
	}

	public void setSrcDir(String srcDir) {
		this.srcDir = srcDir;
	}

	public String getDestDir() {
		return destDir;
	}

	public void setDestDir(String destDir) {
		this.destDir = destDir;
	}

	public Date getBackupTime() {
		return backupTime;
	}

	public void setBackupTime(Date backupTime) {
		this.backupTime = backupTime;
	}

	public int getBackupNum() {
		return backupNum;
	}

	public void setBackupNum(int backupNum) {
		this.backupNum = backupNum;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
	
	
	
	

}
