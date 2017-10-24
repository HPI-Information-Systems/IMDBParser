grammar Plot;
r  : anythingButStart
    STARTSIGNAL
    {System.out.println("Starting Plot parsing");} plot* {System.out.println("Finished Plot parsing");}
    EOF
;
anythingButStart: ( anyline )* {System.out.println("Matched Anything but start");};
anyline : anystring* NEWLINE;
plot: plotstartline titleline NEWLINE ( plotDescription)+;

plotstartline: PLOTSTARTLINE;
plotDescription: plotlines (NEWLINE author NEWLINE)? NEWLINE;
plotlines: (plotline )+;
plotline: PLOTSTART anystring NEWLINE;
anyLineOrEOF: (anystring)* (NEWLINE |EOF);
titleline: TITLESTART anystring NEWLINE;
author: AUTHORSTART anystring NEWLINE;
anystring: ANYSTRING;

STARTSIGNAL : '===================' NL {System.out.println("Matched STARTSIGNAL");};
PLOTSTARTLINE : '-------------------------------------------------------------------------------' NL;
NEWLINE : NL ;
TITLESTART: MV;
PLOTSTART: PL;
AUTHORSTART: BY;
ANYSTRING: ANYTHING+? | MV | PL | BY;

fragment MV: 'MV: ';
fragment PL: 'PL: ';
fragment BY: 'BY: ';
fragment ANYTHING: ~[\r\n];
fragment NL: '\n' | '\r\n';