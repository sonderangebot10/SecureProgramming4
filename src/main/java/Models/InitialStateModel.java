package Models;

public class InitialStateModel {
    private int _ruleCount;
    private String[][] _rules;
    private char[] _tape;
    private int _headPosition;
    private String _state;

    public InitialStateModel(int ruleCount, String[][] rules, char[] tape, int headPosition, String state)
    {
        _ruleCount = ruleCount;
        _rules = rules;
        _tape = tape;
        _headPosition = headPosition;
        _state = state;
    };

    public int get_headPosition() {
        return _headPosition;
    }

    public int get_ruleCount() {
        return _ruleCount;
    }

    public String get_state() {
        return _state;
    }

    public char[] get_tape() {
        return _tape;
    }

    public String[][] get_rules() {
        return _rules;
    }

    public void set_state(String state) {
        _state = state;
    }

    public void setTape(int i, char value)
    {
        _tape[i] = value;
    }

    public void IncreaseHeadPosition()
    {
        _headPosition++;
    }

    public void DecreaseHeadPosition()
    {
        _headPosition--;
    }
}
