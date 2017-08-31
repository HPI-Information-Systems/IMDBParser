// Works for both actors and actresses
grammar Actors;

r  : anythingButStart
    STARTSIGNAL {System.out.println("Matched Start Signal");}
    {System.out.println("Starting actor/actress List parsing");} actorList {System.out.println("Finished actor/actress List parsing");}
    ENDSIGNAL
    anyLineOrEOF
;
anythingButStart: ( anyline | ENDSIGNAL )* {System.out.println("Matched Anything but start");};
anyline : (ANYTHING|SEP)* NEWLINE ;
anyLineOrEOF: (ANYTHING|SEP)* (NEWLINE |EOF);
actorList : (actorAndWork ) *;
actorAndWork: actorName SEP workList NEWLINE;
actorName : ANYTHING;
workList: workElement+;
workElement: SEP? ANYTHING NEWLINE ;

NEWLINE : NL;
STARTSIGNAL : '----' TAB '\u0000'? TAB '\u0000'? TAB '------' NL;
SEP : TAB+ ;
ENDSIGNAL : '-----------------------------------------------------------------------------' NL;
//ANYTHING: (.)+? ;
//ANYTHING: ('\u0000'..'\u0008' | '\u000B'..'\u000C' | '\u000E'..'\uFFFF')+ {System.out.println("Matched  Anything");};
ANYTHING: ~[\t\r\n]+ ;

//fragment NL: '\r\n';
fragment NL: '\r' '\u0000'? '\n' | '\n';
fragment TAB: '\t';