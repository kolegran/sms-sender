package twilio;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class TwilioSender {
    private final String ACCOUNT_SID = "account_sid";
    private final String AUTH_TOKEN = "auth_token";
    private final String TWILIO_NUMBER = "+000000000000";
    private final String VICTIM_NUMBER = "+000000000000";

    public void send() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message.creator(
            new PhoneNumber(VICTIM_NUMBER),
            new PhoneNumber(TWILIO_NUMBER),
            "Hello from kolegran")
            .create();
    }
}
