grammar Locations;
r  : anythingButStart
    STARTSIGNAL
    {System.out.println("Starting Location parsing");} location* {System.out.println("Finished Location parsing");}
    ENDSIGNAL
    anyLineOrEOF
;
anythingButStart: ( anyline | ENDSIGNAL )* {System.out.println("Matched Anything but start");};
anyline : (ANYTHING|SEP)* NEWLINE;
location: title SEP locationName (SEP description)? NEWLINE;

anyLineOrEOF: (ANYTHING|SEP)* (NEWLINE |EOF);
title: ANYTHING;
locationName: ANYTHING;
description: ANYTHING;

SEP : TAB+;
STARTSIGNAL : '==============' NL {System.out.println("Matched STARTSIGNAL");};
ENDSIGNAL : '--------------------------------------------------------------------------------' NL? {System.out.println("Matched ENDSIGNAL");};
NEWLINE : NL ;
ANYTHING: ~[\t\r\n]+;

fragment NL: '\n' | '\r\n';
fragment TAB: '\t';