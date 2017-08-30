grammar Composers;
r  : anythingButStart
    STARTSIGNAL
    {System.out.println("Starting composer List parsing");} composerList {System.out.println("Finished composer List parsing");}
    ENDSIGNAL
    anyLineOrEOF
;
anythingButStart: ( anyline | ENDSIGNAL )* {System.out.println("Matched Anything but start");};
anyline : (ANYTHING|SEP)* NEWLINE;
anyLineOrEOF: (ANYTHING|SEP)* (NEWLINE |EOF);
composerList : (composerAndWork ) *;
composerAndWork: composerName SEP workList NEWLINE;
composerName : ANYTHING;
workList: workElement+;
workElement: SEP? ANYTHING NEWLINE ;

SEP : TAB+;
STARTSIGNAL : '----			------' NL {System.out.println("Matched STARTSIGNAL");};
ENDSIGNAL : '-----------------------------------------------------------------------------' NL {System.out.println("Matched ENDSIGNAL");};
NEWLINE : NL ;
ANYTHING: ~[\t\r\n]+;

fragment NL: '\n' | '\r\n';
fragment TAB: '\t';