package org.auction.module.admin.commodity.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.auction.module.admin.commodity.data.BidingData;
import org.auction.module.admin.commodity.service.BidingService;
import org.auction.module.manager.TradeManager;
import org.auction.module.manager.data.TradeData;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.service.GeneralService;

public class BidingServiceImpl extends GeneralService implements BidingService {

	@SuppressWarnings("unchecked")
	public List findNewPeople(BidingData model) throws GeneralException {
		List<BidingData> newList = new ArrayList<BidingData>();
		// 获得竞拍商品
		TradeData tradeData = TradeManager.get(model.getCommpityId());
		if (tradeData != null) {
			String uid = tradeData.getUid();
			if (uid != null && !uid.equals("") && !uid.equals(model.getUserId())) {
				BidingData data = new BidingData();
				data.setUserId(uid);
				data.setUsername(tradeData.getUsername());
				data.setPrice(tradeData.getMarketPrice());
				data.setTime(tradeData.getAddtimes());
				newList.add(data);
			}
		}
		return newList;
	}

	/**
	 * 返回所有的竞拍的产品
	 */
	public List<BidingData> getAll(String id) throws GeneralException {
		
		List<BidingData> list = new ArrayList<BidingData>();	//装载与竞拍产品对应的最新的竞拍信息
		
		List<TradeData> tradeList = TradeManager.getTradeData(id);//所有的竞拍产品的列表， 目前存在缓存中。
		
		for (TradeData bean : tradeList) {
			BidingData data = new BidingData();
			data.setUserId(bean.getUid());
			data.setId(bean.getId());
			data.setUsername(bean.getUsername());
			data.setPrice(bean.getMarketPrice());
			
			if(bean.isFinshed()){
				data.isFinish = "" + bean.isFinshed();
				data.setDisplayTime( "00:00:00" );
			}else{
			
				long hour = 0;
				long minute = 0;
				long second = 0;
				
				long time = bean.getOvertime().getTime() - Calendar.getInstance().getTimeInMillis();
				if(time > 0){
					long maxtime = time / 1000;
					hour = maxtime / 3600;
					minute = (maxtime - hour * 3600) / 60; 
					second = maxtime % 60;
					String displayTime = hour < 10? ("0" + hour) : "" + hour;
					displayTime = displayTime + ":" +  (minute < 10? ("0" + minute) : "" + minute);
					displayTime = displayTime + ":" +  (second < 10? ("0" + second) : "" + second);
					data.setDisplayTime( displayTime );
				}else{
					data.setDisplayTime( "00:00:00" );
				}
				data.isFinish = "" + bean.isFinshed();
			}
			list.add(data);
		}
		
		return list;
	}

	public String delete(BidingData model) throws GeneralException {
		// TODO Auto-generated method stub
		return null;
	}

	public String forward(BidingData model) throws GeneralException {
		// TODO Auto-generated method stub
		return null;
	}

	public String save(BidingData model) throws GeneralException {
		// TODO Auto-generated method stub
		return null;
	}

	public String search(BidingData model) throws GeneralException {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args){
		long a = 234238989 ;
		long b = 8889759645L;
		System.out.println(a /1000);
		System.out.println(b /1000);
		
		System.out.println(a %1000);
		System.out.println(b %1000);
		
	}
}
