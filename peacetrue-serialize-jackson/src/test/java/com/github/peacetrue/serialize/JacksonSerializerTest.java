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
public class JacksonSerializerTest {

    @Autowired
    private Serializer<String> serializeService;

    @Test
    public void deserialize() {
        String value = serializeService.serialize(Question.DEFAULT);
        Assert.assertEquals(Question.DEFAULT, serializeService.deserialize(value));
    }

    @Test
    public void throwable() throws Exception {
        try {
            throw new IllegalArgumentException("hi");
        } catch (IllegalArgumentException e) {
            String serialize = serializeService.serialize(e);
            System.out.println(serialize.length());
        }
    }

}