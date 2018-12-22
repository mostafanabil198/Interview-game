package eg.edu.alexu.csd.oop.cs51.logger;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 *
 * @author elshamey
 */
public class FormateWithDate extends Formatter{

    @Override
    public String format(LogRecord record) {
         return 
               record.getLevel()+": "+new Date(record.getMillis())+"::"
                +record.getMessage()+"\n";
    }
    
}
