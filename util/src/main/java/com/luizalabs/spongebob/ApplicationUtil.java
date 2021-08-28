package com.luizalabs.spongebob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Map;

public final class ApplicationUtil {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationUtil.class);

    private ApplicationUtil() {
    }

    public static String getVersion(ApplicationContext context) {
        try {
            Map beans =
                context == null ? null : context.getBeansWithAnnotation(SpringBootApplication.class);
            if (beans != null && !beans.isEmpty()) {
                return beans.values().toArray()[0].getClass().getPackage().getImplementationVersion();
            }
        } catch (Throwable t) {
            ApplicationUtil.logger.error("Unable to get application version: " + t);
        }

        return null;
    }
}
