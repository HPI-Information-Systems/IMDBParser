// Works for both actors and actresses
grammar Actors;
r  : anythingButStart
    STARTSIGNAL
    {System.out.println("Starting actor/actress List parsing");} actorList {System.out.println("Finished actor/actress List parsing");}
    ENDSIGNAL
    anyLineOrEOF
;
anythingButStart: ( anyline | ENDSIGNAL )* {System.out.println("Matched Anything but start");};
anyline : (ANYTHING|SEP)* NEWLINE;
anyLineOrEOF: (ANYTHING|SEP)* (NEWLINE |EOF);
actorList : (actorAndWork ) *;
actorAndWork: actorName SEP workList NEWLINE;
actorName : ANYTHING;
workList: workElement+;
workElement: SEP? ANYTHING NEWLINE ;

SEP : TAB+;
STARTSIGNAL : '----			------' NL {System.out.println("Matched STARTSIGNAL");};
ENDSIGNAL : '-----------------------------------------------------------------------------' NL {System.out.println("Matched ENDSIGNAL");};
NEWLINE : NL ;
ANYTHING: ~[\t\r\n]+;

fragment NL: '\n' | '\r\n';
fragment TAB: '\t';