package FileReader;

import Models.InitialStateModel;
import Models.RulesModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TxtFileReader implements IFileReader {

    public TxtFileReader() {};

    public InitialStateModel ReadRules(String fileName) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String readLine = br.readLine();
        int headPosition = Integer.parseInt(readLine);
        readLine = br.readLine();

        char[] tape = ReadTape(readLine);

        RulesModel rulesModel = ReadRulesModel(br, readLine);

        br.close();

        return new InitialStateModel(rulesModel.getRuleCount(), rulesModel.getRules(), tape, headPosition, "0");
    }

    private char[] ReadTape(String readLine)
    {
        char[] tape = new char[readLine.length()];
        for( int i=0; i < readLine.length(); i++)
            tape[i] = readLine.charAt(i);

        return tape;
    }

    private RulesModel ReadRulesModel(BufferedReader br, String readLine) throws IOException
    {
        int ruleCount = 0;
        String[][] rules = new String[100][5];

        while ((readLine = br.readLine()) != null) {
            if(readLine.trim().isEmpty())
                continue;

            String[] tokens = readLine.split(" ");
            for(int i = 0; i < 5; i++) {
                rules[ruleCount][i] = tokens[i];
            }
            ruleCount++;
        }

        return new RulesModel(ruleCount, rules);
    }
}
