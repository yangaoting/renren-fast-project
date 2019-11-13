package io.renren.common.utils;

import java.time.LocalDateTime;
import java.util.Date;

public class UUIDUtils {

    public static Long uuid(){
        return Long.valueOf(DateUtils.format(new Date(),"yyyyMMddHHmmssSSS"));
    }
}
