package com.github.peacetrue.serialize;

import javax.annotation.Nullable;

/**
 * serialize Object to String, byte[] or anything else, and then deserialize back
 *
 * @author xiayx
 */
public interface Serializer<T> {

    /** serialize object to anything else */
    @Nullable
    T serialize(@Nullable Object object);

    /** deserialize anything else to object */
    @Nullable
    Object deserialize(@Nullable T source);

}
