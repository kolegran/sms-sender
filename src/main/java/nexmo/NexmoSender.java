package nexmo;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.auth.AuthMethod;
import com.nexmo.client.auth.TokenAuthMethod;
import com.nexmo.client.sms.SmsSubmissionResult;
import com.nexmo.client.sms.messages.TextMessage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class NexmoSender {
    private final static Logger logger = Logger.getLogger(NexmoSender.class.getName());
    private final String API_KEY = "api_key";
    private final String API_SECRET = "api_secret";
    private final String NEXMO_NUMBER = "+000000000000";
    private final String VICTIM_NUMBER = "+000000000000";

    public void send() {
        try {
            final AuthMethod auth = new TokenAuthMethod(API_KEY, API_SECRET);
            final NexmoClient client = new NexmoClient(auth);

            final TextMessage message = new TextMessage(NEXMO_NUMBER, VICTIM_NUMBER, "Hello from kolegran");
            final SmsSubmissionResult[] responses = client.getSmsClient().submitMessage(message);
            for (SmsSubmissionResult response : responses) {
                logger.log(Level.INFO, response.toString());
            }
        } catch (Exception e) {
            logger.log(Level.WARNING, "Something went wrong");
        }
    }
}
