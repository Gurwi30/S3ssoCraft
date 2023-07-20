package me.gurwi.s3ssocraft.utils.customlogger;

import me.gurwi.s3ssocraft.S3ssoCraft;

import java.util.logging.Logger;

@SuppressWarnings("unused")
public class CustomLogger {

    private static final Logger logger = S3ssoCraft.getInstance().getLogger();
    public static void log(LoggerTag loggerTag, String msg) {
        logger.info(loggerTag.getTag() + msg);
    }

}
