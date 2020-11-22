package Models;

public class RulesModel {
    private int _ruleCount = 0;
    private String[][] _rules = new String[100][5];

    public RulesModel(int ruleCount, String[][] rules)
    {
        _ruleCount = ruleCount;
        _rules = rules;
    }

    public int getRuleCount() {
        return _ruleCount;
    }

    public String[][] getRules() {
        return _rules;
    }
}
