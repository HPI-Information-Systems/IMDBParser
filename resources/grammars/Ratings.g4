// Define a grammar called Hello
grammar Ratings;
r  : anythingButStart
    STARTSIGNAL
    {System.out.println("Starting Rating parsing");} rating* {System.out.println("Finished Rating parsing");}
    ENDSIGNAL
    anyLineOrEOF
;
anythingButStart: ( anyline | ENDSIGNAL )* {System.out.println("Matched Anything but start");};
anyline : (ANYTHING|SEP)* NEWLINE;
//rating: SEP? new_? SEP distribution SEP votes SEP rank SEP title NEWLINE;
rating: SEP distribution SEP votes SEP rank SEP title NEWLINE;

anyLineOrEOF: (ANYTHING|SEP)* (NEWLINE |EOF);
new_: ANYTHING;
distribution: ANYTHING;
votes: ANYTHING;
rank: ANYTHING;
title: (ANYTHING|SEP)*;

SEP : SPACE+;
STARTSIGNAL : 'MOVIE RATINGS REPORT' NL NL? 'New  Distribution  Votes  Rank  Title' NL{System.out.println("Matched STARTSIGNAL");};
ENDSIGNAL : NL '------------------------------------------------------------------------------' NL {System.out.println("Matched ENDSIGNAL");};
NEWLINE : NL ;
ANYTHING: ~[ \r\n]+;

fragment NL: '\n' | '\r\n';
fragment SPACE: ' ';