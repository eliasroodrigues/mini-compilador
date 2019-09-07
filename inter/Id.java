package inter;

import lexer.*; import symbols.*;

/*
 * A classe id herda implementações default de gen e reduce na classe
 * Expr, porque um identificador é um endereço.
 */

public class Id extends Expr {
	public int offset; // endereço relativo
	public Id(Word id, Type p, int b) { super(id, p); offset = b; }
}
