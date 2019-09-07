package inter;

import lexer.*; import symbols.*;

/*
 *	A classe Op oferece uma implementação de reduce() que é herdada
 * pelas subclasses Arith, Unary e Access.
 */

public class Op extends Expr {
	public Op(Token tok, Type p) { super(tok, p); }
	public Expr reduce() {
		Expr x = gen();
		Temp t = new Temp(type);
		emit( t.toString() + " = " + x.toString() );
		return t;
	}
}
