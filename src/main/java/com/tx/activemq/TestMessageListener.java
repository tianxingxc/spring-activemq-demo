package com.tx.activemq;

import org.springframework.transaction.annotation.Transactional;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class TestMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        if( message instanceof TextMessage) {
            try {
                System.out.println(((TextMessage) message).getText());
                throw new RuntimeException("异常");
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

}
