package inter;

import lexer.*; import symbols.*;

/*
* A classe Unary é o correspondente de um operador da classe Arith.
*/

public class Unary extends Op {
	public Expr expr;
	public Unary(Token tok, Expr x) { // trata operador menos, para !
		super(tok, null); expr = x;
		type = Type.max(Type.Int, expr.type);
		if (type == null) error("type error");
	}

	public Expr gen() { return new Unary(op, expr.reduce()); }
	public String toString() { return op.toString() + " " + expr.toString(); }
}