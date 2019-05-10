package nj.sample.json.jackson.tojson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import nj.sample.json.Main;

import java.io.IOException;

/**
 * Created by nsrinivasulu on 10-May-19.
 */
public class MyCustomSerializer extends StdSerializer<Main>
{
    public MyCustomSerializer()
    {
        this(Main.class);
    }

    public MyCustomSerializer(Class<Main> t)
    {
        super(t);
    }

    @Override
    public void serialize(Main main, JsonGenerator jgen, SerializerProvider serializerProvider) throws IOException
    {
        jgen.writeStartObject();
        jgen.writeStringField("a1", main.getA1());
        jgen.writeNumberField("a2", main.getA2());
        jgen.writeObjectField("a4", main.getA4());
        jgen.writeEndObject();
    }
}
