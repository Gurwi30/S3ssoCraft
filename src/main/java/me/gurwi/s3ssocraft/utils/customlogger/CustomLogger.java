package me.gurwi.fadedmask.utils.customlogger;

import me.gurwi.fadedmask.FadedMask;

import java.util.logging.Logger;

@SuppressWarnings("unused")
public class CustomLogger {

    private static final Logger logger = FadedMask.getInstance().getLogger();
    public static void log(LoggerTag loggerTag, String msg) {
        logger.info(loggerTag.getTag() + msg);
    }

}
