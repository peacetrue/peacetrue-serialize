package com.github.peacetrue.serialize;

import javax.annotation.Nullable;
import java.util.Base64;
import java.util.Objects;

/**
 * base64 proxy a {@link Serializer} with type {@code byte[]}
 *
 * @author xiayx
 */
public class Base64Serializer implements Serializer<String> {

    private Serializer<byte[]> serializer;

    public Base64Serializer(Serializer<byte[]> serializer) {
        this.serializer = Objects.requireNonNull(serializer);
    }

    @Nullable
    @Override
    public String serialize(@Nullable Object object) {
        byte[] bytes = serializer.serialize(object);
        if (bytes == null) return null;
        return new String(Base64.getEncoder().encode(bytes));
    }

    @Nullable
    @Override
    public Object deserialize(@Nullable String source) {
        if (source == null) return null;
        return serializer.deserialize(Base64.getDecoder().decode(source));
    }
}
