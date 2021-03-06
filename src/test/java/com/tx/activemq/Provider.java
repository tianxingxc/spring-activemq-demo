package com.tx.activemq;

import com.tx.activemq.service.ProviderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class Provider {

    @Autowired
    private ProviderService providerService;

    @Test
    public void provider() {
        providerService.sendMsg();
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
