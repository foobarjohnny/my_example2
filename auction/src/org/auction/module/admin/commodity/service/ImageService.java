package org.auction.module.admin.commodity.service;

import org.auction.module.admin.commodity.data.ImageData;

public interface ImageService {

	public void getImage(ImageData model) throws Exception;

	public void viewImage(ImageData model) throws Exception;
}
