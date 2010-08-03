package org.auction.module.admin.base.action;

import org.auction.module.admin.base.data.ProblemData;
import org.auction.module.admin.base.service.ProblemService;
import org.mobile.common.action.GeneralAction;
import org.mobile.common.exception.GeneralException;

public class ProblemAction extends GeneralAction<ProblemData> {

	private static final long serialVersionUID = 1L;

	private ProblemData model = new ProblemData();

	private ProblemService problemService;

	public String delete() throws GeneralException {
		problemService.delete(model);
		return SUCCESS;
	}

	public String search() throws GeneralException {
		setPage(model);
		problemService.search(model);
		return SUCCESS;
	}

	public String forwardProblem() throws GeneralException {
		problemService.forwardInfo(model);
		return SUCCESS;
	}

	public String saveProblem() throws GeneralException {
		problemService.saveInfo(model);
		return SUCCESS;
	}

	public ProblemData getModel() {
		return model;
	}

	public void setProblemService(ProblemService problemService) {
		this.problemService = problemService;
	}

}
