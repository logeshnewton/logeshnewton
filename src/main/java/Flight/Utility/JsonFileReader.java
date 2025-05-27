package Flight.Utility;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonFileReader {
    public String json(String key) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode =objectMapper.readTree(new File(System.getProperty("user.dir")+"//src//test//java//data//datas.json"));
        return jsonNode.get(key).asText();
    }
}
