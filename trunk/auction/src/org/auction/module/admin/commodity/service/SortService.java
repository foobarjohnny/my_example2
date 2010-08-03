package org.auction.module.admin.commodity.service;

import org.auction.module.admin.commodity.data.SortData;
import org.mobile.common.exception.GeneralException;

public interface SortService {

	public void forward(SortData model) throws GeneralException;

	public void save(SortData model) throws GeneralException;

	public void delete(SortData model) throws GeneralException;

	public void search(SortData model) throws GeneralException;
}
