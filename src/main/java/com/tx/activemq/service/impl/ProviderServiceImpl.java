package com.tx.activemq.service.impl;

import com.tx.activemq.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.Date;

public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private JmsTemplate jmsTemplate;

    //    @Resource(name = "testQueue")
    @Resource(name = "testTopic")
    private Destination destination;

    @Override
    public void sendMsg() {
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("test queue" + new Date());
            }
        });
    }
}
