package syntactic.grammar;

import java.util.ArrayList;

import lexical.TokenCategory;

public class Grammar {
	
	private static Grammar grammarSingleton;
	private ArrayList<Derivation> grammarMap;
	private Derivation derivationAux;
	
	public static final int EXPRESSION = 75;
	
	private Grammar() { 
		
		grammarMap = new ArrayList<Derivation>();
		loadGrammar();
		
	}

    public static Grammar getInstance() {
        if (grammarSingleton == null ) {
        	grammarSingleton = new Grammar();
        }
        return grammarSingleton;
    }
	

	public ArrayList<Derivation> getGrammarMap() {
		return grammarMap;
	}
	
	private void loadGrammar() {
		
		// (1)FUNCTIONS MAIN
		derivationAux = new Derivation();
		derivationAux.addDerivationSymbols(
				new NonTerminal(NonTerminalName.FUNCTIONS),
				new NonTerminal(NonTerminalName.MAIN));	
		grammarAddDerivation(derivationAux);

		// (2)'tID' PARAMS RETURNTYPE ESCOPE FUNCTIONS
		derivationAux.addDerivationSymbols(
				new Terminal(TokenCategory.tID),
				new NonTerminal(NonTerminalName.PARAMS),
				new NonTerminal(NonTerminalName.RETURNTYPE),
				new NonTerminal(NonTerminalName.ESCOPE),
				new NonTerminal(NonTerminalName.FUNCTIONS));
		grammarAddDerivation(derivationAux);

		// (3)Epsilon
		grammarAddDerivation(null);

		// (4)'tMAIN' 'tOP' 'tCP' 'tEmpty' ESCOPE
		derivationAux.addDerivationSymbols(
				new Terminal(TokenCategory.tMAIN), 
				new Terminal(TokenCategory.tOP),
				new Terminal(TokenCategory.tCP),
				new Terminal(TokenCategory.tEMPTY),
				new NonTerminal(NonTerminalName.ESCOPE));
		grammarAddDerivation(derivationAux);

		// (5)'tOP' PARAMSEXT
		derivationAux.addDerivationSymbols(
				new Terminal(TokenCategory.tOP),
				new NonTerminal(NonTerminalName.PARAMSEXT));
		grammarAddDerivation(derivationAux);

		// (6)'tCP'
		derivationAux.addSymbol(new Terminal(TokenCategory.tCP));		
		grammarAddDerivation(derivationAux);

		// (7)LISTPARAMS 'tCP'
		derivationAux.addDerivationSymbols(
				new NonTerminal(NonTerminalName.LISTPARAMS),
				new Terminal(TokenCategory.tCP));
		grammarAddDerivation(derivationAux);

		// (8)TYPE NAME LISTPARAMSEXT
		derivationAux.addDerivationSymbols(
				new NonTerminal(NonTerminalName.TYPE),
				new NonTerminal(NonTerminalName.NAME),
				new NonTerminal(NonTerminalName.LISTPARAMSEXT));
		grammarAddDerivation(derivationAux);
		
		// (9)'tSPTR' LISTPARAMS 
		derivationAux.addDerivationSymbols(
				new Terminal(TokenCategory.tSPTR),
				new NonTerminal(NonTerminalName.LISTPARAMS));
		grammarAddDerivation(derivationAux);
		
		// (10)Epsilon
		grammarAddDerivation(null);
		
		// (11)'tINT'
		derivationAux.addSymbol(new Terminal(TokenCategory.tINT));		
		grammarAddDerivation(derivationAux);
		
		// (13)'tBOOL'
		derivationAux.addSymbol(new Terminal(TokenCategory.tBOOL));		
		grammarAddDerivation(derivationAux);
		
		// (14)'tCHAR'
		derivationAux.addSymbol(new Terminal(TokenCategory.tCHAR));		
		grammarAddDerivation(derivationAux);

		// (15)'tSTRING'
		derivationAux.addSymbol(new Terminal(TokenCategory.tSTRING));		
		grammarAddDerivation(derivationAux);

		// (16)'tFLOAT'
		derivationAux.addSymbol(new Terminal(TokenCategory.tFLOAT));		
		grammarAddDerivation(derivationAux);

		// (17)'tEMPTY'
		derivationAux.addSymbol(new Terminal(TokenCategory.tEMPTY));		
		grammarAddDerivation(derivationAux);

		// (18)TYPE RETURNTYPEEXT
		derivationAux.addDerivationSymbols(
				new NonTerminal(NonTerminalName.TYPE),
				new NonTerminal(NonTerminalName.RETURNTYPEEXT));
		grammarAddDerivation(derivationAux);

		// (19)'tOB' 'tCB'
		derivationAux.addDerivationSymbols(
				new Terminal(TokenCategory.tOB),
				new Terminal(TokenCategory.tCB));
		grammarAddDerivation(derivationAux);

		// (20)Epsilon
		grammarAddDerivation(null);
				
		// (21)'tID' NAMEEXT 
		derivationAux.addDerivationSymbols(
				new Terminal(TokenCategory.tID),
				new NonTerminal(NonTerminalName.NAMEEXT));
		grammarAddDerivation(derivationAux);
		
		// (22)'tOB' 'tCTEINT' 'tCB'
		derivationAux.addDerivationSymbols(
				new Terminal(TokenCategory.tOB),
				new Terminal(TokenCategory.tCTEINT),
				new Terminal(TokenCategory.tCB));
		grammarAddDerivation(derivationAux);
		
		// (23)Epsilon
		grammarAddDerivation(null);
		
		// (24)'tOK' COMMANDS 'tCK'
		derivationAux.addDerivationSymbols(
				new Terminal(TokenCategory.tOK),
				new NonTerminal(NonTerminalName.COMMANDS),
				new Terminal(TokenCategory.tCK));
		grammarAddDerivation(derivationAux);
		
		// (25)CMD COMMANDS 
		derivationAux.addDerivationSymbols(
				new NonTerminal(NonTerminalName.CMD),
				new NonTerminal(NonTerminalName.COMMANDS));
		grammarAddDerivation(derivationAux);
		
		// (26)Epsilon
		grammarAddDerivation(null);
		
		// (27)DECLARATION
		derivationAux.addSymbol(new NonTerminal(NonTerminalName.DECLARATION));
		grammarAddDerivation(derivationAux);
		
		// (28)'tID' CMDEXT
		derivationAux.addDerivationSymbols(
				new Terminal(TokenCategory.tID),
				new NonTerminal(NonTerminalName.CMDEXT));
		grammarAddDerivation(derivationAux);
		
		// (29)SHOW
		derivationAux.addSymbol(new NonTerminal(NonTerminalName.SHOW));
		grammarAddDerivation(derivationAux);
		
		// (30)READ
		derivationAux.addSymbol(new NonTerminal(NonTerminalName.READ));
		grammarAddDerivation(derivationAux);
		
		// (31)IFELSE
		derivationAux.addSymbol(new NonTerminal(NonTerminalName.IFELSE));
		grammarAddDerivation(derivationAux);
		
		// (32)WHEN
		derivationAux.addSymbol(new NonTerminal(NonTerminalName.WHEN));
		grammarAddDerivation(derivationAux);
		
		// (34)REPEATER
		derivationAux.addSymbol(new NonTerminal(NonTerminalName.REPEATER));
		grammarAddDerivation(derivationAux);

		// (35)RETURN
		derivationAux.addSymbol(new NonTerminal(NonTerminalName.RETURN));
		grammarAddDerivation(derivationAux);
		
		// (36)TYPE NAME
		derivationAux.addDerivationSymbols(
				new NonTerminal(NonTerminalName.TYPE),
				new NonTerminal(NonTerminalName.NAME));
		grammarAddDerivation(derivationAux);
		
		// (37)ATTRIBUTION
		derivationAux.addSymbol(new NonTerminal(NonTerminalName.ATTRIBUTION));
		grammarAddDerivation(derivationAux);
		
		// (38)FUNCCALL
		derivationAux.addSymbol(new NonTerminal(NonTerminalName.FUNCCALL));
		grammarAddDerivation(derivationAux);
		
		// (39)NAMEEXT 'tATR' VALUE 
		derivationAux.addDerivationSymbols(
				new NonTerminal(NonTerminalName.NAMEEXT),
				new Terminal(TokenCategory.tATR),
				new NonTerminal(NonTerminalName.VALUE));
		grammarAddDerivation(derivationAux);
		
		// (40)ATTRIBUTION
		derivationAux.addSymbol(new NonTerminal(NonTerminalName.ARRAY));
		grammarAddDerivation(derivationAux);
		
		// (41)'tOB' ARRAYEXT
		derivationAux.addDerivationSymbols(
				new Terminal(TokenCategory.tOB),
				new NonTerminal(NonTerminalName.ARRAYEXT));
		grammarAddDerivation(derivationAux);
		
		// (42)ELEMENTS 'tCB' 
		derivationAux.addDerivationSymbols(
				new NonTerminal(NonTerminalName.ELEMENTS),
				new Terminal(TokenCategory.tCB));
		grammarAddDerivation(derivationAux);		
		
		// (43)'tCB'
		derivationAux.addSymbol(new Terminal(TokenCategory.tCB));		
		grammarAddDerivation(derivationAux);
		
		// (44)CONSTANT ELEMENTSEXT 
		derivationAux.addDerivationSymbols(
				new NonTerminal(NonTerminalName.CONSTANT),
				new NonTerminal(NonTerminalName.ELEMENTSEXT));
		grammarAddDerivation(derivationAux);
		
		// (45)'tSPTR' ELEMENTS  
		derivationAux.addDerivationSymbols(
				new Terminal(TokenCategory.tSPTR),
				new NonTerminal(NonTerminalName.ELEMENTS));
		grammarAddDerivation(derivationAux);
		
		// (46)Epsilon
		grammarAddDerivation(null);
		
		// (47)'tCTEINT'
		derivationAux.addSymbol(new Terminal(TokenCategory.tCTEINT));		
		grammarAddDerivation(derivationAux);
		
		// (48)'tCTEFLOAT'
		derivationAux.addSymbol(new Terminal(TokenCategory.tCTEFLOAT));		
		grammarAddDerivation(derivationAux);
		
		// (49)'tCTECHAR'
		derivationAux.addSymbol(new Terminal(TokenCategory.tCTECHAR));		
		grammarAddDerivation(derivationAux);
		
		// (50)'tCTESTRING'
		derivationAux.addSymbol(new Terminal(TokenCategory.tCTESTRING));		
		grammarAddDerivation(derivationAux);
		
		// (51)'tTRUE'
		derivationAux.addSymbol(new Terminal(TokenCategory.tTRUE));		
		grammarAddDerivation(derivationAux);
		
		// (52)'tFALSE'
		derivationAux.addSymbol(new Terminal(TokenCategory.tFALSE));		
		grammarAddDerivation(derivationAux);
		
		// (53)'tOP' LISTPARAMSCALL 'tCP'
		derivationAux.addDerivationSymbols(
				new Terminal(TokenCategory.tOP),
				new NonTerminal(NonTerminalName.LISTPARAMSCALL),
				new Terminal(TokenCategory.tCP));
		grammarAddDerivation(derivationAux);
		
		// (54)PARAMITEM LISTPARAMSCALLEXt  
		derivationAux.addDerivationSymbols(
				new NonTerminal(NonTerminalName.PARAMITEM),
				new NonTerminal(NonTerminalName.LISTPARAMSCALLEXT));
		grammarAddDerivation(derivationAux);
		
		// (55)'tSPTR' LISTPARAMSCALL
		derivationAux.addDerivationSymbols(
				new Terminal(TokenCategory.tSPTR),
				new NonTerminal(NonTerminalName.LISTPARAMSCALL));
		grammarAddDerivation(derivationAux);
		
		// (56)Epsilon
		grammarAddDerivation(null);
		
		// (57)CONSTANT
		derivationAux.addSymbol(new NonTerminal(NonTerminalName.CONSTANT));
		grammarAddDerivation(derivationAux);
		
		// (58)NAME
		derivationAux.addSymbol(new NonTerminal(NonTerminalName.NAME));
		grammarAddDerivation(derivationAux);
		
		// (59)'tSHOW' 'tOP' MESSAGE 'tCP'
		derivationAux.addDerivationSymbols(
				new Terminal(TokenCategory.tSHOW),
				new Terminal(TokenCategory.tOP),
				new NonTerminal(NonTerminalName.MESSAGE),
				new Terminal(TokenCategory.tCP));
		grammarAddDerivation(derivationAux);
		
		// (60)'tCTESTRING' MESSAGEEXT
		derivationAux.addDerivationSymbols(
				new Terminal(TokenCategory.tCTESTRING),
				new NonTerminal(NonTerminalName.MESSAGEEXT));
		grammarAddDerivation(derivationAux);
		
		// (61)NAME MESSAGEEXT
		derivationAux.addDerivationSymbols(
				new NonTerminal(NonTerminalName.NAME),
				new NonTerminal(NonTerminalName.MESSAGEEXT));
		grammarAddDerivation(derivationAux);

		// (62)'tCONCAT' MESSAGE
		derivationAux.addDerivationSymbols(
				new Terminal(TokenCategory.tCONCAT),
				new NonTerminal(NonTerminalName.MESSAGE));
		grammarAddDerivation(derivationAux);
		
		// (63)Epsilon
		grammarAddDerivation(null);
		
		// (64)'tREAD' 'tOP' TYPE 'tSPTR' NAME 'tCP'
		derivationAux.addDerivationSymbols(
				new Terminal(TokenCategory.tREAD),
				new Terminal(TokenCategory.tOP),
				new NonTerminal(NonTerminalName.TYPE),
				new Terminal(TokenCategory.tSPTR),
				new NonTerminal(NonTerminalName.NAME),
				new Terminal(TokenCategory.tCP));
		grammarAddDerivation(derivationAux);
		
		// (65)IF ELIF ELSE
		derivationAux.addDerivationSymbols(
				new NonTerminal(NonTerminalName.IF),
				new NonTerminal(NonTerminalName.ELIF),
				new NonTerminal(NonTerminalName.ELSE));
		grammarAddDerivation(derivationAux);
		
		// (66)�'tIF' 'tOP' EXPRESSION 'tCP' 'tOK' COMMANDS 'tCK'
		derivationAux.addDerivationSymbols(
				new Terminal(TokenCategory.tIF),
				new Terminal(TokenCategory.tOP),
				new NonTerminal(NonTerminalName.EXPRESSION),
				new Terminal(TokenCategory.tCP),
				new Terminal(TokenCategory.tOK),
				new NonTerminal(NonTerminalName.COMMANDS),
				new Terminal(TokenCategory.tCK));
		grammarAddDerivation(derivationAux);
		
		// (67)'tELIF' 'tOP' EXPRESSION 'tCP' 'tOK' COMMANDS 'tCK' ELIF
		derivationAux.addDerivationSymbols(
				new Terminal(TokenCategory.tELIF), 
				new Terminal(TokenCategory.tOP), 
				new NonTerminal(NonTerminalName.EXPRESSION), 
				new Terminal(TokenCategory.tCP), 
				new Terminal(TokenCategory.tOK), 
				new NonTerminal(NonTerminalName.COMMANDS), 
				new Terminal(TokenCategory.tCK), 
				new NonTerminal(NonTerminalName.ELIF));
		grammarAddDerivation(derivationAux);
		
		// (68) Epsilon
		grammarAddDerivation(null);
		
		// (69)'tELSE' 'tOK' COMMANDS 'tCK'
		derivationAux.addDerivationSymbols(
				new Terminal(TokenCategory.tELSE), 
				new Terminal(TokenCategory.tOK), 
				new NonTerminal(NonTerminalName.COMMANDS), 
				new Terminal(TokenCategory.tCK));
		grammarAddDerivation(derivationAux);
		
		// (70) Epsilon
		grammarAddDerivation(null);
		
		// (71)'tWHEN' 'tOP' EXPRESSION 'tCP' 'tOK' COMMANDS 'tCK'
		derivationAux.addDerivationSymbols(
				new Terminal(TokenCategory.tWHEN), 
				new Terminal(TokenCategory.tOP), 
				new NonTerminal(NonTerminalName.EXPRESSION), 
				new Terminal(TokenCategory.tCP), 
				new Terminal(TokenCategory.tOK), 
				new NonTerminal(NonTerminalName.COMMANDS), 
				new Terminal(TokenCategory.tCK));
		grammarAddDerivation(derivationAux);
		
		// (72)'tREPEATER' 'tOP' 'tID' ATTRIBUTION 'tSCO' EXPRESSION 'tSCO' 'tID' ATTRIBUTION 'tCP'
	    // 'tOK' COMMANDS 'tCK
		derivationAux.addDerivationSymbols(
				new Terminal(TokenCategory.tREPEATER), 
				new Terminal(TokenCategory.tOP),
				new Terminal(TokenCategory.tID),
				new NonTerminal(NonTerminalName.ATTRIBUTION), 
				new Terminal(TokenCategory.tSCO), 
				new NonTerminal(NonTerminalName.EXPRESSION), 
				new Terminal(TokenCategory.tSCO),
				new Terminal(TokenCategory.tID),
				new NonTerminal(NonTerminalName.ATTRIBUTION), 
				new Terminal(TokenCategory.tCP), 
				new Terminal(TokenCategory.tOK), 
				new NonTerminal(NonTerminalName.COMMANDS), 
				new Terminal(TokenCategory.tCK));
		grammarAddDerivation(derivationAux);
		
		// (73)'tRETURN' RETURNEXt
		derivationAux.addDerivationSymbols(
				new Terminal(TokenCategory.tRETURN), 
				new NonTerminal(NonTerminalName.RETURNEXT));
		grammarAddDerivation(derivationAux);
		
		// (74)CONSTANT
		derivationAux.addSymbol(new NonTerminal(NonTerminalName.CONSTANT));
		grammarAddDerivation(derivationAux);
		
		// (75)NAME
		derivationAux.addSymbol(new NonTerminal(NonTerminalName.NAME));
		grammarAddDerivation(derivationAux);
		
		// (76)EXPRESSION
		derivationAux.addSymbol(new NonTerminal(NonTerminalName.EXPRESSION));
		grammarAddDerivation(derivationAux);
	}

	private void grammarAddDerivation(Derivation derivation) {		
		grammarMap.add(derivation);		
		if(derivation != null) {			
			derivationAux = new Derivation();
		}
	}	
	
}
