package com.github.peacetrue.serialize;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xiayx
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JacksonSerializeAutoConfiguration.class)
public class JacksonSerializeServiceTest {

    @Autowired
    private SerializeService<String> serializeService;

    @Test
    public void deserialize() {
        String value = serializeService.serialize(Question.DEFAULT);
        Assert.assertEquals(Question.DEFAULT, serializeService.deserialize(value));
    }
}