package com.github.peacetrue.serialize;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author xiayx
 */
public class JavaSerializeServiceTest {

    @Test
    public void deserialize() {
        byte[] bytes = JavaSerializeService.DEFAULT.serialize(Question.DEFAULT);
        Assert.assertEquals(Question.DEFAULT, JavaSerializeService.DEFAULT.deserialize(bytes));
    }

}