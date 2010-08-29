package org.auction.module.admin.commodity.action;

import org.auction.module.admin.commodity.data.ImageData;
import org.auction.module.admin.commodity.service.ImageService;
import org.mobile.common.action.GeneralAction;

public class ImageAction extends GeneralAction<ImageData> {

	private static final long serialVersionUID = 1L;
	
	private ImageData model = new ImageData();
	
	private ImageService imagesService;
	
	public void showImage() throws Exception {
		imagesService.getImage(model);
	}

	public ImageData getModel() {
		return model;
	}

	public void setImagesService(ImageService imagesService) {
		this.imagesService = imagesService;
	}
}
