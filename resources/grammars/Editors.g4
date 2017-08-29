// Define a grammar called Hello
grammar Editors;
r  : anythingButStart
    STARTSIGNAL
    {System.out.println("Starting editor List parsing");} editorList {System.out.println("Finished editor List parsing");}
    ENDSIGNAL
    anyLineOrEOF
;
anythingButStart: ( anyline | ENDSIGNAL )* {System.out.println("Matched Anything but start");};
anyline : (ANYTHING|SEP)* NEWLINE;
anyLineOrEOF: (ANYTHING|SEP)* (NEWLINE |EOF);
editorList : (editorAndWork ) *;
editorAndWork: editorName SEP workList NEWLINE;
editorName : ANYTHING;
workList: workElement+;
workElement: SEP? ANYTHING NEWLINE ;

SEP : TAB+;
STARTSIGNAL : '----                    ------' NL {System.out.println("Matched STARTSIGNAL");};
ENDSIGNAL : '-----------------------------------------------------------------------------' NL {System.out.println("Matched ENDSIGNAL");};
NEWLINE : NL ;
ANYTHING: ~[\t\r\n]+;

fragment NL: '\n' | '\r\n';
fragment TAB: '\t';