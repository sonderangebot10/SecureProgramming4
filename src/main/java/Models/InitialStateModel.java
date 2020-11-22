package Models;

public class InitialStateModel {
    private int ruleCount;
    private String[][] rules;
    private char[] tape;
    private int headPosition;
    private String state;

    public InitialStateModel(int _ruleCount, String[][] _rules, char[] _tape, int _headPosition, String _state)
    {
        ruleCount = _ruleCount;
        rules = _rules;
        tape = _tape;
        headPosition = _headPosition;
        state = _state;
    };

    public int getHeadPosition() {
        return headPosition;
    }

    public int getRuleCount() {
        return ruleCount;
    }

    public String getState() {
        return state;
    }

    public char[] getTape() {
        return tape;
    }

    public String[][] getRules() {
        return rules;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setTape(int i, char value)
    {
        this.tape[i] = value;
    }

    public void IncreaseHeadPosition()
    {
        headPosition++;
    }

    public void DecreaseHeadPosition()
    {
        headPosition--;
    }
}
