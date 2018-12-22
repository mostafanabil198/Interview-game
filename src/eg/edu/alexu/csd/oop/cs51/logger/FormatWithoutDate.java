package eg.edu.alexu.csd.oop.cs51.logger;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 *
 * @author elshamey
 */
public class FormatWithoutDate extends Formatter{

    @Override
    public String format(LogRecord record) {
         return record.getLevel()+": "+record.getMessage()+"\n";
    }
    
}