//************************************************************************
// Title : A java programme to demonstrate Dependency Inversion Principle.
// Author : Nayon Mondol, Undergrduate student, Khulna University.
//************************************************************************

import java.util.ArrayList;
import java.util.List;

/**
 * Interface representing a notification method.
 */
interface NotificationMethod {
    /**
     * Sends a notification.
     *
     * @param message The message to be sent.
     */
    void sendNotification(String message);
}

/**
 * Class representing a notification system.
 */
class NotificationSystem {
    private final List<NotificationMethod> notificationMethods;

    /**
     * Constructs a new NotificationSystem with the given notification methods.
     *
     * @param notificationMethods The list of notification methods.
     */
    public NotificationSystem(List<NotificationMethod> notificationMethods) {
        this.notificationMethods = notificationMethods;
    }

    /**
     * Sends a notification using all the configured notification methods.
     *
     * @param message The message to be sent.
     */
    public void sendNotification(String message) {
        for (NotificationMethod method : notificationMethods) {
            method.sendNotification(message);
        }
    }
}

/**
 * Class representing an email notification method.
 */
class EmailNotification implements NotificationMethod {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending email notification: " + message);
    }
}

/**
 * Class representing a SMS notification method.
 */
class SMSNotification implements NotificationMethod {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS notification: " + message);
    }
}

/**
 * Demo class demonstrating the usage of a notification system with different notification methods.
 */
public class Dependency_Inversion_Principle {
    public static void main(String[] args) {
        // Create email and SMS notification methods
        NotificationMethod emailMethod = new EmailNotification();
        NotificationMethod smsMethod = new SMSNotification();

        // Create a notification system with email and SMS notification methods
        List<NotificationMethod> methods = new ArrayList<>();
        methods.add(emailMethod);
        methods.add(smsMethod);
        NotificationSystem notificationSystem = new NotificationSystem(methods);

        // Send a notification using all methods
        notificationSystem.sendNotification("This is a notification message.");
    }
}

/**
 * We have an interface NotificationMethod representing a method for sending notifications.
 * The EmailNotification and SMSNotification classes implement the NotificationMethod
 * interface to represent email and SMS notification methods, respectively.
 * The NotificationSystem class represents a notification system that can send notifications
 * using different methods. It depends on the abstraction provided by the NotificationMethod
 * interface, allowing it to use any notification method without being coupled to specific implementations.
 * The Dependency_Inversion_Principle class demonstrates the usage of the notification system
 * with different notification methods. It creates instances of EmailNotification and SMSNotification
 * and configures the notification system with them, adhering to the Dependency Inversion Principle
 * by depending on abstractions rather than concrete implementations.
 */