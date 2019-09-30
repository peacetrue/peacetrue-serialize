package com.github.peacetrue.serialize;

import javax.annotation.Nullable;
import java.io.*;

/**
 * serialize object by {@link ObjectInputStream}
 *
 * @author xiayx
 */
public class JavaSerializer implements Serializer<byte[]> {

    public static final JavaSerializer DEFAULT = new JavaSerializer();

    @Override
    public byte[] serialize(@Nullable Object object) {
        if (object == null) return null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
            objectOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new IllegalArgumentException(String.format("object[%s] serialize failed", object), e);
        }
    }

    @Override
    public Object deserialize(@Nullable byte[] source) {
        if (source == null) return null;
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(source);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Object object = objectInputStream.readObject();
            objectInputStream.close();
            return object;
        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalArgumentException(String.format("bytes[%s] deserialize failed", source.length), e);
        }
    }


}
