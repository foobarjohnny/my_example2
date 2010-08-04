package org.mobile.common.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.mobile.common.exception.GeneralException;

public class FileUpload {

	public static void upload(File source, File target) throws GeneralException {
		try {
			FileUtils.copyFile(source, target);
		} catch (IOException e) {
			throw new GeneralException(e.getMessage());
		}
	}
}
