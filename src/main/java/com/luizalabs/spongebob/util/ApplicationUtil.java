package com.luizalabs.spongebob.util;

import com.luizalabs.spongebob.SpongeBobApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ApplicationUtil {
  private static final Logger logger = LoggerFactory.getLogger(ApplicationUtil.class);

  private ApplicationUtil() {
  }

  public static String getVersion() {
    try {
      return SpongeBobApplication.class.getPackage().getImplementationVersion();
    } catch (Throwable t) {
      ApplicationUtil.logger.error("Unable to get application version: " + t);
    }

    return null;
  }
}
