package org.auction.module.admin.commodity.service;

import org.auction.module.admin.commodity.data.PublisData;

public interface PublisService {

	public void edit(PublisData model) throws Exception;

	public void forward(PublisData model) throws Exception;

	public void search(PublisData model) throws Exception;

	public void delete(PublisData model) throws Exception;

	public boolean vote(PublisData model) throws Exception;
}
