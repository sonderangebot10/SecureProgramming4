import FileReader.IFileReader;
import FileReader.JsonFileReader;
import FileReader.TxtFileReader;
import Models.InitialStateModel;
import Services.RuleReaderService;

public class Main {
    private static IFileReader _fileReader;

    public static void main(String[] args) throws Exception {
        if(args.length == 0)
            throw new Exception("No file given\n\n");
        SetReader(args[0]);

        InitialStateModel tmRules = _fileReader.ReadRules(args[0]);
        RuleReaderService.RunRules(tmRules);
    }

    private static void SetReader(String fileName) throws Exception {
        if(fileName.endsWith(".json"))
            _fileReader = new JsonFileReader();
        else if(fileName.endsWith(".txt"))
            _fileReader = new TxtFileReader();
        else
            throw new Exception("Incorrect file format\n\n");
    }
}
