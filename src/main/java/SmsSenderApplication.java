import twilio.TwilioSender;

public class SmsSenderApplication {

    public static void main(String[] args) {
        new TwilioSender().send();
    }
}
