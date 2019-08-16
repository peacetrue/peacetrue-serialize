package com.github.peacetrue.serialize;

import javax.annotation.Nullable;

/**
 * serialize service
 *
 * @author xiayx
 */
public interface SerializeService<T> {

    /** serialize object to anything else */
    @Nullable
    T serialize(@Nullable Object object);

    /** deserialize anything else to object */
    @Nullable
    Object deserialize(@Nullable T source);

}
