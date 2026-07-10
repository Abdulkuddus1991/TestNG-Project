package UtilityResource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UtilityFile {


    public static void saveEmployeeInfo(String firstName,String lastName,String username,String password) throws IOException, ParseException {
        String filepath="./src/test/resources/employee.json";

        JSONParser parser =new JSONParser();
        JSONArray nameArray =(JSONArray) parser.parse(new FileReader(filepath));
        JSONObject nameObject=new JSONObject();

        nameObject.put("Firstname",firstName);
        nameObject.put("Lastname",lastName);
        nameObject.put("UserName",username);
        nameObject.put("Password",password);

        nameArray.add(nameObject);

        FileWriter writer=new FileWriter(filepath);
        writer.write(nameArray.toJSONString());
        writer.flush();
        writer.close();
    }

    public static JSONObject getUserInfo() throws IOException, ParseException {
        // Correct file path (works in Maven/Gradle standard structure)
        String filepath = "src/test/resources/employee.json";

        JSONParser parser = new JSONParser();
        // Read file properly — fixed your original FileReader.toString() mistake
        JSONArray usersArray = (JSONArray) parser.parse(new FileReader(filepath));

        // Return the last entry from the JSON array
        return (JSONObject) usersArray.get(usersArray.size() - 1);

    }


}
