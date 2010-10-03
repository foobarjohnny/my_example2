package org.auction.module.admin.base.service;

import org.auction.module.admin.base.data.DoohickeyData;

public interface DoohickeyService {

	public void save(DoohickeyData model) throws Exception;

	public void forward(DoohickeyData model) throws Exception;

	public void search(DoohickeyData model) throws Exception;

	public void delete(DoohickeyData model) throws Exception;
	
	public void view(DoohickeyData model) throws Exception;
}
