package FileReader;

import Models.InitialStateModel;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface IFileReader {
    public InitialStateModel ReadRules(String fileName) throws NumberFormatException, IOException, ParseException;
}
