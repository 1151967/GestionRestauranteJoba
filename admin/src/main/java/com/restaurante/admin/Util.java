package com.restaurante.admin;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.stereotype.Component;

@Component
public class Util {
        public static final String ACCOUNT_SID = "AC94096991a26815b3d0e848eb4048a60b";
        public static final String AUTH_TOKEN = "1e96adc81dba33cd9e6292413b3ae15c";
    public static void EnviarMensaje(String mensaje, String numero) {
                Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
                Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("whatsapp:+573105807984"),
                        new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                                mensaje).create();
                System.out.println(message.getSid());
            }

}
