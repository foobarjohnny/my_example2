package org.auction.module.admin.commodity.service;

import org.auction.module.admin.commodity.data.ConsumeData;
import org.mobile.common.exception.GeneralException;

public interface ConsumeService {

	public void forward(ConsumeData model) throws GeneralException;

	public void save(ConsumeData model) throws GeneralException;

	public void delete(ConsumeData model) throws GeneralException;

	public void search(ConsumeData model) throws GeneralException;
}
