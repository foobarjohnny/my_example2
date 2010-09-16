package org.auction.module.admin.base.service;

import org.auction.module.admin.base.data.ProblemData;
import org.mobile.common.exception.GeneralException;

public interface ProblemService {

	public void delete(ProblemData model) throws GeneralException;

	public void search(ProblemData model) throws GeneralException;

	public void forwardInfo(ProblemData model) throws GeneralException;

	public void saveInfo(ProblemData model) throws GeneralException;

	public void savePro(ProblemData model) throws GeneralException;

	public void proForward(ProblemData model) throws GeneralException;
}
