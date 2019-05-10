package nj.sample.json.jackson.tojson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import nj.sample.json.Main;
import nj.sample.json.Other;

import java.io.IOException;

/**
 * Created by nsrinivasulu on 10-May-19.
 */
public class JsonConverterUsingCustomSerializer {
    public static void main(String []args)
    {
        Main obj = new Main();
        String jsonOutput = null;
        ObjectMapper obMapper = new ObjectMapper();
        try {
            if (obMapper != null) {
                SimpleModule module = new SimpleModule();
                module.addSerializer(new MyCustomSerializer(Main.class));
                module.addSerializer(new StdSerializer<Other>(Other.class) {
                    @Override
                    public void serialize(Other s, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
                        jsonGenerator.writeStartObject();
                        jsonGenerator.writeStringField("o1", "sai");
                        jsonGenerator.writeEndObject();
                    }
                });
                obMapper.registerModule(module);
                jsonOutput = obMapper.writeValueAsString(obj);

                System.out.println(jsonOutput);
                ObjectMapper readMapper = new ObjectMapper();
                Main readObj = readMapper.readValue(jsonOutput, Main.class);

                readObj.setA2(5);
                ObjectMapper writeMapper = new ObjectMapper();
                System.out.println(writeMapper.writeValueAsString(readObj));
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
