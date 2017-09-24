package com.iplayer.media.common;

import org.apache.ibatis.annotations.Param;

/**
 * Created by jianzuming on 17/9/24.
 */
public interface AbstractDao<T> {
    void insert(T t) throws Exception;

    void update(T t) throws Exception;

    void delete(@Param("key")String field,@Param("value")Object value) throws Exception;

    T select(@Param("key") String field ,@Param("value")Object value)throws Exception;

    boolean exists(@Param("key") String field,@Param("value")Object value)throws Exception;

}
