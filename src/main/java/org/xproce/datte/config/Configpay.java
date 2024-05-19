package org.xproce.datte.config;

import com.stripe.Stripe;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configpay {
    @Value("${stripe.api.secretKey}")
    private String secretKey;

    @PostConstruct
    public void  initSecretKey(){
        Stripe.apiKey = secretKey;
    }
}
