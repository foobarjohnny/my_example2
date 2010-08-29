package org.auction.module.admin.commodity.service;

import org.auction.module.admin.commodity.data.EcurrData;
import org.mobile.common.exception.GeneralException;

public interface EcurrService {

	public void forward(EcurrData model) throws GeneralException;

	public void save(EcurrData model) throws GeneralException;

	public void delete(EcurrData model) throws GeneralException;

	public void search(EcurrData model) throws GeneralException;
	
	public void buy(EcurrData model) throws GeneralException;
}
