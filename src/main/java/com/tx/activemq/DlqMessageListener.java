package com.tx.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class DlqMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        System.out.println("dlq message listening...");
        if( message instanceof TextMessage) {
            try {
                System.out.println(((TextMessage) message).getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

}
