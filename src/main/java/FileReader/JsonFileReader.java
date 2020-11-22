package FileReader;

import Models.InitialStateModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonFileReader implements IFileReader {

    public JsonFileReader() {};

    public InitialStateModel ReadRules(String fileName) throws IOException, ParseException
    {
        JSONObject jsonFile = ReadJsonFile(fileName);

        String headPosition = (String) jsonFile.get("head-start-position");
        String tape = (String) jsonFile.get("tape");

        JSONArray rulesList = (JSONArray) jsonFile.get("rules");
        String[][] rules = GetRules(rulesList);

        return new InitialStateModel(rulesList.size(), rules, tape.toCharArray(), Integer.parseInt(headPosition), "0");
    }

    private JSONObject ReadJsonFile(String fileName) throws IOException, ParseException
    {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(fileName);

        Object obj = jsonParser.parse(reader);
        reader.close();

        return (JSONObject) obj;
    }

    private String[][] GetRules(JSONArray rulesList)
    {
        String[][] rules = new String[100][5];
        for (int ruleCount = 0; ruleCount < rulesList.size(); ruleCount++) {
            JSONObject rule = (JSONObject) rulesList.get(ruleCount);

            rules[ruleCount][0] = (String) rule.get("state");
            rules[ruleCount][1] = (String) rule.get("read");
            rules[ruleCount][2] = (String) rule.get("write");
            rules[ruleCount][3] = (String) rule.get("move");
            rules[ruleCount][4] = (String) rule.get("next-state");
        }

        return rules;
    }
}
