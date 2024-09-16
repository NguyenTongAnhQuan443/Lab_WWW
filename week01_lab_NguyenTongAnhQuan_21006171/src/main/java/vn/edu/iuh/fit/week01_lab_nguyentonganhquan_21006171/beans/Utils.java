package vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.beans;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Utils {
    public Instant convertLocalDateTimeToInstant(LocalDateTime localDateTime){
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zoneId).toInstant();
        return instant;
    }
}
