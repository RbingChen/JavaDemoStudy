package jsontest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

import java.io.IOException;

public class JacksonTest1 {
    public static void main(String args[]){
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"name\":\"cimon\",\"age\":27}";
        try{
            Student student = mapper.readValue(jsonString,Student.class);
            System.out.println(student);
            System.out.println(mapper.writeValueAsString(student));

            //JsonNode jsonNode = mapper.readTree(jsonString);
            //ObjectNode objectNode = mapper.createObjectNode();
            ObjectNode objectNode = mapper.readValue("{}",ObjectNode.class);

            System.out.println(objectNode.get("name"));

        }catch (JsonParseException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Student {
    private String name;
    private int age;

}