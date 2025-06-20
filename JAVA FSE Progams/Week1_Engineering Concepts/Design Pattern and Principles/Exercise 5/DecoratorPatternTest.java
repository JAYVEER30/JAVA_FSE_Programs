interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;
    
    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }
    
    @Override
    public void send(String message) {
        notifier.send(message);
    }
}

class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }
    
    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("SMS: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }
    
    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Slack: " + message);
    }
}

public class DecoratorPatternTest {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        
        System.out.println("Sending notification through Email:");
        emailNotifier.send("JAVA FSE");
        
        System.out.println("\nSending notification through Email and SMS:");
        Notifier emailSMSNotifier = new SMSNotifierDecorator(emailNotifier);
        emailSMSNotifier.send("JAVA FSE");
        
        System.out.println("\nSending notification through Email, SMS, and Slack:");
        Notifier allChannelsNotifier = new SlackNotifierDecorator(
            new SMSNotifierDecorator(emailNotifier)
        );
        allChannelsNotifier.send("JAVA FSE");
        
        System.out.println("\nSending notification through Email and Slack only:");
        Notifier emailSlackNotifier = new SlackNotifierDecorator(emailNotifier);
        emailSlackNotifier.send("JAVA FSE");
    }
}