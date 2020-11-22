package Services;

import Models.InitialStateModel;

public class RuleReaderService {
    public static void RunRules(InitialStateModel ims)
    {
        while( true ) {
            for( int i = 0; i < ims.getRuleCount(); i++ ) {
                if(CheckInitialConditions(i, ims)) {
                    ims.setTape(ims.getHeadPosition(), ims.getRules()[i][2].charAt(0));
                    if(ims.getRules()[i][3].charAt(0) == 'L')
                        ims.DecreaseHeadPosition();
                    else
                        ims.IncreaseHeadPosition();
                    ims.setState(ims.getRules()[i][4]);
                    PrintTape(ims.getTape());
                }
            }
        }
    }

    private static Boolean CheckInitialConditions(int i, InitialStateModel ims)
    {
        return ims.getRules()[i][0].equals(ims.getState())
                && ims.getRules()[i][1].charAt(0) == ims.getTape()[ims.getHeadPosition()];
    }

    private static void PrintTape(char[] tape)
    {
        System.out.println("");
        for(int j = 0; j < tape.length; j++) {
            System.out.print(tape[j]);
        }
    }
}
