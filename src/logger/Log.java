package logger;

import java.io.File;
import java.io.IOException;
import java.util.logging.*;

public class Log {
    private FileHandler fileH;
    private static Logger LOGGER = Logger.getLogger(Log.class.getName());

    public Log(Logger log, String path) {
        LOGGER = log;
        try {
            File dir = new File("logs");
            if (!dir.isDirectory()) {
                dir.mkdirs();
            }
            fileH = new FileHandler("logs" + File.separator + path);
            fileH.setFormatter(new SimpleFormatter());
            fileH.setLevel(Level.ALL);
            LOGGER.addHandler(fileH);
        } catch (SecurityException | IOException e) {
        }
    }

    public static Logger getLOGGER() {
        return LOGGER;
    }
}
