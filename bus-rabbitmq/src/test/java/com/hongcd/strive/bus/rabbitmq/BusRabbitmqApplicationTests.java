package com.hongcd.strive.bus.rabbitmq;

import com.hongcd.strive.bus.rabbitmq.send.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BusRabbitmqApplication.class)
public class BusRabbitmqApplicationTests {
    @Autowired
    private Sender sender;

    @Test
    public void rabbitSendMsg() {
        sender.sendMsg("hello bus");
    }
}
