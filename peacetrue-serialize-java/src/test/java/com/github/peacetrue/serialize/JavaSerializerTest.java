package com.github.peacetrue.serialize;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author xiayx
 */
public class JavaSerializerTest {

    @Test
    public void deserialize() {
        byte[] bytes = JavaSerializer.DEFAULT.serialize(Question.DEFAULT);
        Assert.assertEquals(Question.DEFAULT, JavaSerializer.DEFAULT.deserialize(bytes));
    }

    @Test
    public void throwable() throws Exception {
        try {
            throw new IllegalArgumentException("hi");
        } catch (IllegalArgumentException e) {
//            ByteArrayOutputStream stream = new ByteArrayOutputStream();
//            e.printStackTrace(new PrintStream(new FileOutputStream("/Users/xiayx/Documents/Projects/peacetrue-serialize/peacetrue-serialize-java/src/test/resources/log.txt")));
//            System.out.println(e.getLocalizedMessage());
//            System.out.println(new String(stream.toByteArray()));
            byte[] serialize = JavaSerializer.DEFAULT.serialize(e);
            System.out.println(serialize.length / Math.pow(2, 10));
            Assert.assertEquals(e, JavaSerializer.DEFAULT.deserialize(serialize));
        }
    }
}