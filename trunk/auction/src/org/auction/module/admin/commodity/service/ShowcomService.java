package org.auction.module.admin.commodity.service;

import org.auction.module.admin.commodity.data.ShowcomData;

public interface ShowcomService {

	public void notAut(ShowcomData model) throws Exception;

	public void finshedAut(ShowcomData model) throws Exception;

	public void aut(ShowcomData model) throws Exception;

	public void save(ShowcomData model) throws Exception;

	public void view(ShowcomData model) throws Exception;

	public void delete(ShowcomData model) throws Exception;

	public void forward(ShowcomData model) throws Exception;

	public void viewList(ShowcomData model) throws Exception;
	
	public void showList(ShowcomData model) throws Exception;
}
