package com.example.config;

import com.example.componet.BillSubmitMessageHandler;
import com.example.componet.EmailProperties;
import com.example.componet.EmailToBillTransformer;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.mail.dsl.Mail;

@Configuration
public class BillEmailIntegrationConfig {

    public IntegrationFlow billEmailFlow(EmailProperties emailProperties,
                                         EmailToBillTransformer transformer,
                                         BillSubmitMessageHandler handler){
               return IntegrationFlows
                       .from(Mail.imapInboundAdapter(emailProperties.getUrl()),
                               e -> e.poller(
                                       Pollers.fixedDelay(emailProperties.getPollRate())))
                       .transform(transformer)
                       .handle(handler)
                       .get();
    }
}
