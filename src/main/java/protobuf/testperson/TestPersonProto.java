package protobuf.testperson;
import protobuf.testperson.PersonProto.Person;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class TestPersonProto {

    public static void main(String args[]) throws IOException {
        Person peter = Person.newBuilder().setAge(12).setName("Peter").setPhone("129813").build();
        System.out.println(peter.toString());
        System.out.println(peter.toByteArray());
        String path = "/Users/bing/Desktop/IDEA/JavaDemoStudy/src/main/java/protobuf/testperson/";

        FileOutputStream output = new FileOutputStream(path+"person.pb");
        peter.writeTo(output);

        FileInputStream input = new FileInputStream(path+"person.pb");
        Person f = Person.parseFrom(input);
        System.out.format("Read from file ...\n%s",f.toString());
    }
}
