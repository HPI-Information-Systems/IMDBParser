// Define a grammar called Hello
grammar Directors;
r  : anythingButStart
    STARTSIGNAL
    {System.out.println("Starting director List parsing");} directorList {System.out.println("Finished Director List parsing");}
    ENDSIGNAL
    anyLineOrEOF
;
anythingButStart: ( anyline | ENDSIGNAL )* {System.out.println("Matched Anything but start");};
anyline : (ANYTHING|SEP)* NEWLINE;
anyLineOrEOF: (ANYTHING|SEP)* (NEWLINE |EOF);
directorList : (directorAndWork ) *;
directorAndWork: directorName SEP workList NEWLINE;
directorName : ANYTHING;
workList: workElement+;
workElement: SEP? ANYTHING NEWLINE ;

SEP : TAB+;
STARTSIGNAL : '----			------' NL {System.out.println("Matched STARTSIGNAL");};
ENDSIGNAL : '-----------------------------------------------------------------------------' NL {System.out.println("Matched ENDSIGNAL");};
NEWLINE : NL ;
ANYTHING: ~[\t\r\n]+;

fragment NL: '\n' | '\r\n';
fragment TAB: '\t';