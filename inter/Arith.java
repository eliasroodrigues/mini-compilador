package inter;

import lexer.*; import symbols.*;

/*
 *	A classe Arith implementa operadores binários como + e *. O 
 * construtor Arith começa chamando super(tok, null), onde tok é
 * um token representando o perador e null é um marcador de lugar
 * para o tipo.
 */

public class Arith extends Op {
	public Expr expr1, expr2;
	public Arith(Token tok, Expr x1, Expr x2) {
		super(tok, null); expr1 = x1; expr2 = x2;
		type = Type.max(expr1.type, expr2.type);
		if (type == null) error("type error");	
	}

	/*
	*  O método gen() constrói o lado direito de uma instrução de três
	* endereços, reduzindo as subexpressões para endereços e aplicando o
	* operador aos endereços.
 	*/

	public Expr gen() {
		return new Arith(op, expr1.reduce(), expr2.reduce());
	}

	public String toString() {
		return expr1.toString() + " " + op.toString() + " " + 
		expr2.toString();
	}
}
