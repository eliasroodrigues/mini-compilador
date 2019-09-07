package lexer;

/*
 * A classe TAG define constantes para tokens.
 * As constantes INDEX, MINUS e TEMP não são 
 * tokens léxicos, elas serão usadas nas árvores
 * sintáticas.
 */

public class Tag {
	public final static int 
	AND   = 256,
    EQ    = 261,
    INDEX = 266,
    OR    = 271,
    BASIC = 257,
    FALSE = 262,
    LE    = 267,
    REAL  = 272,
    BREAK = 258,
    GE    = 263,
    MINUS = 268,
    TEMP  = 273,
    DO    = 259,
    ID    = 264,
    NE    = 269,
    TRUE  = 274,
    ELSE  = 260,
    IF    = 265,
    NUM   = 270,
    WHILE = 275;
}
