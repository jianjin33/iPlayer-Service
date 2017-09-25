package com.iplayer.media.api.function;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

/**
 * Created by jianzuming on 17/9/24.
 */
public interface IUserServer {
    Map login(String account,String password);

}
