package org.mobile.common.bean;

/**
 * 登录用户检查bean
 * @author Administrator
 *
 */
public class LoginBean {

	private String id;
	private String workNo;
	private String password;
	private Integer paycur;		//用户剩余的付费竞拍币
	private Integer freecur;	//用户剩余的免费竞拍币
	private Integer amount;		
	
	private String winGoods;	//用户竞拍成功的产品信息

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWorkNo() {
		return workNo;
	}

	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPaycur() {
		return paycur;
	}

	public void setPaycur(Integer paycur) {
		this.paycur = paycur;
	}

	public Integer getFreecur() {
		return freecur;
	}

	public void setFreecur(Integer freecur) {
		this.freecur = freecur;
	}
	
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("[LoginBean]  ");
		buffer.append("\n\tid      ="+id      );
		buffer.append("\n\tworkNo  ="+workNo  );
		buffer.append("\n\tpassword="+password);
		buffer.append("\n\tpaycur  ="+paycur  );
		buffer.append("\n\tfreecur ="+freecur );
		buffer.append("\n\tamount  ="+amount  );
		return buffer.toString();
	}

	public String getWinGoods() {
		return winGoods;
	}

	public void setWinGoods(String winGoods) {
		this.winGoods = winGoods;
	}
}
