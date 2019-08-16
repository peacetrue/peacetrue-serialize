package com.github.peacetrue.serialize;

import javax.annotation.Nullable;
import java.util.Base64;
import java.util.Objects;

/**
 * base64 proxy a {@link SerializeService} with type {@code byte[]}
 *
 * @author xiayx
 */
public class Base64SerializeService implements SerializeService<String> {

    private SerializeService<byte[]> byteSerializeService;

    public Base64SerializeService(SerializeService<byte[]> byteSerializeService) {
        this.byteSerializeService = Objects.requireNonNull(byteSerializeService);
    }

    @Nullable
    @Override
    public String serialize(@Nullable Object object) {
        byte[] bytes = byteSerializeService.serialize(object);
        if (bytes == null) return null;
        return new String(Base64.getEncoder().encode(bytes));
    }

    @Nullable
    @Override
    public Object deserialize(@Nullable String source) {
        if (source == null) return null;
        return byteSerializeService.deserialize(Base64.getDecoder().decode(source));
    }
}
