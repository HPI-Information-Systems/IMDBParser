grammar Genres;
//r: anythingButStart | startSignal | anyline | country | anyLineOrEOF | countryName | title;

r  : anythingButStart
    startSignal
    {System.out.println("Starting Genre parsing");} genre* {System.out.println("Finished Genre parsing");}
    EOF;

anythingButStart: ( anyline | ENDSIGNAL )* ;
startSignal: STARTSIGNAL ;
anyline : (ANYTHING|SEP)* NEWLINE ;
genre: title SEP genreName NEWLINE ;
genreName: ANYTHING;
title: ANYTHING;

SEP:TAB+;
STARTSIGNAL : '8: THE GENRES LIST' NL '==================' NL NL;
ENDSIGNAL : '--------------------------------------------------------------------------------' NL ;
NEWLINE : NL ;
ANYTHING: ~[\t\r\n]+ ;

fragment NL: '\r\n' | '\n';
fragment TAB: '\t';