package com.epaide.base.action;

import java.io.File;

import com.devedup.ajaxfileupload.action.FileUpload;
import com.opensymphony.xwork2.Action;

public class AjaxFileUploadAction extends FileUpload {

	@Override
	public String execute() {
		File uploadedFile = this.getUpload();
		String contentType = this.getUploadContentType();
		String fileName = this.getUploadFileName();
		return Action.SUCCESS;
	}

}
