// Works for both actors and actresses
grammar Actors;
r  : anythingButStart
    STARTSIGNAL
    {System.out.println("Starting actor/actress List parsing");} actorList {System.out.println("Finished actor/actress List parsing");}
    ENDSIGNAL
    anyLineOrEOF
;
anythingButStart: ( anyline | ENDSIGNAL )* {System.out.println("Matched Anything but start");};
anyline : (ANYTHING|SEP)* NEWLINE {System.out.println("Matched Anyline");};
anyLineOrEOF: (ANYTHING|SEP)* (NEWLINE |EOF);
actorList : (actorAndWork ) *;
actorAndWork: actorName SEP workList NEWLINE;
actorName : ANYTHING;
workList: workElement+;
workElement: SEP? ANYTHING NEWLINE ;

SEP : TAB+ {System.out.println("Matched SEP");};
STARTSIGNAL : '----			------' NL NL {System.out.println("Matched STARTSIGNAL");};
ENDSIGNAL : '-----------------------------------------------------------------------------' NL NL {System.out.println("Matched ENDSIGNAL");};
NEWLINE : NL NL? {System.out.println("Matched  Newline");};
//ANYTHING: (.)+? ;
//ANYTHING: ('\u0000'..'\u0008' | '\u000B'..'\u000C' | '\u000E'..'\uFFFF')+ {System.out.println("Matched  Anything");};
ANYTHING: ~[\t\n]+ ;

//fragment NL: '\r\n';
fragment NL: '\n' ;
fragment TAB: '\t';