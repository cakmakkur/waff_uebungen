package at.technikum.LearningStuff;

abstract class Logger {
    protected Logger nextLogger;

    public void setNextLogger(Logger logger) {
        this.nextLogger = logger;
    }

    public void logMessage(int level, String message) {
        if (canHandle(level)) {
            writeLog(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    protected abstract boolean canHandle(int level);

    protected abstract void writeLog(String message);
}


class InfoLogger extends Logger {
    @Override
    protected boolean canHandle(int level) {
        return level == 1;
    }

    @Override
    protected void writeLog(String message) {
        System.out.println("[Info:] " + message);
    }
}


class DebugLogger extends Logger {
    @Override
    protected boolean canHandle(int level) {
        return level == 2;
    }

    @Override
    protected void writeLog(String message) {
        System.out.println("[Debug:] " + message);
    }
}

class ErrorLogger extends Logger {
    @Override
    protected boolean canHandle(int level) {
        return level == 3;
    }

    @Override
    protected void writeLog(String message) {
        System.out.println("[Error:] " + message);
    }
}


public class ChainOfResponsibilityLogger {
    public static void run() {
        // creating the chain
        Logger infoL = new InfoLogger();
        Logger debugL = new DebugLogger();
        Logger errorL = new ErrorLogger();

        infoL.setNextLogger(debugL);
        debugL.setNextLogger(errorL);

        infoL.logMessage(1, "Passing this message");
        infoL.logMessage(2, "Passing this message");
        infoL.logMessage(3, "Passing this message");
    }

    ;
}
