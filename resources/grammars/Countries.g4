// Define a grammar called Hello
grammar Countries;
r  : anythingButStart
    startSignal
    {System.out.println("Starting Country parsing");} country* {System.out.println("Finished Country parsing");}
    ENDSIGNAL
    anyLineOrEOF
;
anythingButStart: ( anyline | ENDSIGNAL )* {System.out.println("Matched Anything but start");};
startSignal: STARTSIGNAL {System.out.println("Matched Startsignal");};
anyline : (ANYTHING|SEP)* NEWLINE {System.out.println("Matched Anyline");};
country: title SEP countryName NEWLINE;
anyLineOrEOF: (ANYTHING|SEP)* (NEWLINE |EOF);
countryName: ANYTHING;
title: ANYTHING;

SEP : TAB+;
STARTSIGNAL : '============ ==' NL {System.out.println("Matched STARTSIGNAL");};
ENDSIGNAL : '--------------------------------------------------------------------------------' NL {System.out.println("Matched ENDSIGNAL");};
NEWLINE : NL {System.out.println("Matched Newline");};
ANYTHING: ~[\t\r\n]+ {System.out.println("Matched Anything");};

fragment NL: '\r\n';
fragment TAB: '\t';