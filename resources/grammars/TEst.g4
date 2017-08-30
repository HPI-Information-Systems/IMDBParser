// Define a grammar called Hello
grammar TEst;
r  : anyToken* EOF;
anyToken : sep | start | end | nl | any;
sep: SEP {System.out.println("Matched SEP");};
start: STARTSIGNAL {System.out.println("Matched STARTSIGNAL");};
end: ENDSIGNAL {System.out.println("Matched ENDSIGNAL");};
nl: NEWLINE {System.out.println("Matched NEWLINE");};
any: ANYTHING {System.out.println("Matched ANYTHING");};


//anythingButStart: ( anyline | ENDSIGNAL )* {System.out.println("Matched Anything but start");};
//anyline : (ANYTHING|SEP)* NEWLINE;
//anyLineOrEOF: (ANYTHING|SEP)* (NEWLINE |EOF);
//directorList : (directorAndWork ) *;
//directorAndWork: directorName SEP workList NEWLINE;
//directorName : ANYTHING;
//workList: workElement+;
//workElement: SEP? ANYTHING NEWLINE ;

SEP : TAB+;
STARTSIGNAL : '============' NL {System.out.println("Matched STARTSIGNAL");};
ENDSIGNAL : '--------------' NL {System.out.println("Matched ENDSIGNAL");};
NEWLINE : NL ;
ANYTHING: ~[\t\r\n]+;

fragment NL: '\n' | '\r\n';
fragment TAB: '\t';