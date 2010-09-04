package org.auction.module.admin.commodity.dwr;

import org.auction.module.admin.commodity.data.PublisData;
import org.auction.module.admin.commodity.service.PublisService;

public class PublisHandler {

	private PublisService publisService;
	
	public String vote(String id) throws Exception {
		PublisData data = new PublisData();
		data.setId(id);
		if (publisService.vote(data)) {
			return id + "," + String.valueOf(data.getAmount());
		} else {
			return "error";
		}
	}

	public void setPublisService(PublisService publisService) {
		this.publisService = publisService;
	}

}
