package com.github.peacetrue.serialize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.peacetrue.jackson.ObjectMapperWrapper;

import javax.annotation.Nullable;
import java.util.Objects;

/**
 * serialize object by {@link ObjectMapper}
 *
 * @author xiayx
 */
public class JacksonSerializer implements Serializer<String> {

    private ObjectMapperWrapper wrapper;

    public JacksonSerializer(ObjectMapperWrapper wrapper) {
        this.wrapper = Objects.requireNonNull(wrapper);
    }

    @Override
    public String serialize(@Nullable Object object) {
        return wrapper.writeAppendType(object);
    }

    @Override
    public Object deserialize(@Nullable String source) {
        return wrapper.readDetectType(source);
    }
}
