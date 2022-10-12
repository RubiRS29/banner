package springboot.datajpa.app.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utils {

    public Date toFormatDate(String date) throws ParseException {
        //return a simple parse date
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        return s.parse(date);
    }

}
