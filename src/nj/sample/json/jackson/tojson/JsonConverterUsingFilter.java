package nj.sample.json.jackson.tojson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import nj.sample.json.Main;

import java.io.IOException;

/**
 * This uses filter provider and uses the JsonFilter annotation on the class
 */
public class JsonConverterUsingFilter {
    public static void main(String[] args)
    {
        Main obj = new Main();
        String jsonOutput = null;
        ObjectMapper obMapper = new ObjectMapper();
        SimpleFilterProvider filterProvider = new SimpleFilterProvider();
        filterProvider.addFilter("main_serializer", SimpleBeanPropertyFilter.filterOutAllExcept("a2", "a4"));
        filterProvider.addFilter("other_serializer", SimpleBeanPropertyFilter.serializeAll());
        obMapper.setFilterProvider(filterProvider);
        try {
            if (obMapper != null) {
                jsonOutput = obMapper.writeValueAsString(obj);
                System.out.println(jsonOutput);

                ObjectMapper readMapper = new ObjectMapper();
                Main readObj = readMapper.readValue(jsonOutput, Main.class);

                readObj.setA2(5);
                ObjectMapper writeMapper = new ObjectMapper();
                SimpleFilterProvider reWriteProvider = new SimpleFilterProvider();
                reWriteProvider.addFilter("main_serializer", SimpleBeanPropertyFilter.serializeAll());
                reWriteProvider.addFilter("other_serializer", SimpleBeanPropertyFilter.serializeAll());
                writeMapper.setFilterProvider(reWriteProvider);
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
