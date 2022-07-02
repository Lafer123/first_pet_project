package Deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.io.IOException;

public class DateDeserializer extends StdDeserializer<DateTime> {

    private static final long serialVersionUID = 1583533079322978048L;

    public DateDeserializer() {
        this(null);
    }

    public DateDeserializer(Class<?> object) {
        super(object);
    }

    @Override
    public DateTime deserialize(JsonParser parser, DeserializationContext context)
            throws IOException, JsonProcessingException {
        String date = parser.getText();
        return parseStringToDateTime(date);
    }

    public static DateTime parseStringToDateTime(String date) {
        String[] parts = date.split("\\.");
        DateTimeFormatter formatter;
        if (parts.length > 1) {
            if (parts[1].length() > 4) {
                String millis = parts[1].substring(0, 3).concat("Z");
                date = date.replace(parts[1], millis);
            }
            formatter = ISODateTimeFormat.dateTime();
        } else {
            formatter = ISODateTimeFormat.dateTimeNoMillis();
        }
        return formatter.parseDateTime(date);
    }
}