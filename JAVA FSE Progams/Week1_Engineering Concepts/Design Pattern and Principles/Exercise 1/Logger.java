public class Logger {
    // Private static instance of the Logger class (lazy initialization)
    private static Logger instance;
    
    // Private constructor to prevent instantiation from outside
    private Logger() {
        System.out.println("Logger instance created!");
    }
    
    // Public static method to get the single instance (thread-safe)
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    
    // Logging methods
    public void log(String message) {
        System.out.println("[LOG] " + getCurrentTimestamp() + ": " + message);
    }
    
    public void logError(String errorMessage) {
        System.err.println("[ERROR] " + getCurrentTimestamp() + ": " + errorMessage);
    }
    
    public void logWarning(String warningMessage) {
        System.out.println("[WARNING] " + getCurrentTimestamp() + ": " + warningMessage);
    }
    
    // Helper method to get current timestamp
    private String getCurrentTimestamp() {
        return java.time.LocalDateTime.now().toString();
    }
    
    // Method to get instance info for testing
    public String getInstanceInfo() {
        return "Logger instance hash: " + this.hashCode();
    }
}