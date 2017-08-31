grammar Countries;
//r: anythingButStart | startSignal | anyline | country | anyLineOrEOF | countryName | title;

r  : anythingButStart
    startSignal
    {System.out.println("Starting Country parsing");} country* {System.out.println("Finished Country parsing");}
    ENDSIGNAL
    anyLineOrEOF;
anythingButStart: ( anyline | ENDSIGNAL )* ;
startSignal: STARTSIGNAL ;
anyline : (ANYTHING|SEP)* NEWLINE ;
country: title SEP countryName NEWLINE ;
anyLineOrEOF: (ANYTHING|SEP)* (NEWLINE |EOF);
countryName: ANYTHING;
title: ANYTHING;

SEP:TAB+;
STARTSIGNAL : '==============' NL ;
ENDSIGNAL : '--------------------------------------------------------------------------------' NL ;
NEWLINE : NL ;
ANYTHING: ~[\t\r\n]+ ;

fragment NL: '\r\n' | '\n';
fragment TAB: '\t';