package Services;

import Models.InitialStateModel;

public class RuleReaderService {
    public static void RunRules(InitialStateModel ims)
    {
        while( true ) {
            for(int i = 0; i < ims.get_ruleCount(); i++ ) {
                if(CheckInitialConditions(i, ims)) {
                    ims.setTape(ims.get_headPosition(), ims.get_rules()[i][2].charAt(0));
                    if(ims.get_rules()[i][3].charAt(0) == 'L')
                        ims.DecreaseHeadPosition();
                    else
                        ims.IncreaseHeadPosition();
                    ims.set_state(ims.get_rules()[i][4]);
                    PrintTape(ims.get_tape());
                }
            }
        }
    }

    private static Boolean CheckInitialConditions(int i, InitialStateModel ims)
    {
        return ims.get_rules()[i][0].equals(ims.get_state())
                && ims.get_rules()[i][1].charAt(0) == ims.get_tape()[ims.get_headPosition()];
    }

    private static void PrintTape(char[] tape)
    {
        System.out.println("");
        for(int j = 0; j < tape.length; j++) {
            System.out.print(tape[j]);
        }
    }
}
