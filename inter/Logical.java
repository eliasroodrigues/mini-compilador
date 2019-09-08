package inter;

import lexer.*; import symbols.*;

/*
* A classe Logical oferece alguma funcionalidade comum para as classes
* Or, And e Not. Os campos x e y correspondem aos operados de um operador
* lógico. O construor Logical(tok, a, b) constrói um nó de sintaxe com
* operador tok e operandos a e b. Ao fazer isso, ele usa a função check para 
* garantir que tanto a quanto b sejam boolianos.
*/

public class Logical extends Expr {
	public Expr expr1, expr2;
	Logical(Token tok, Expr x1, Expr x2) {
		super(tok, null); // tipo nulo para começar
		expr1 = x1; expr2 = x2;
		type = check(expr1.type, expr2.type);
		if ( type == null ) error("type error");
	}

	public Type check(Type p1, Type p2) {
		if ( p1 == Type.Bool && p2 == Type.Bool ) return Type.Bool;
		else return null;
	}

	public Expr gen() {
		int f = newlabel(); int a = newlabel();
		Temp temp = new Temp(type);
		this.jumping(0, f);
		emit(temp.toString() + " = true");
		emit("goto L" + a);
		emitlabel(f); emit(temp.toString() + " = false");
		emitlabel(a);
		return temp;
	}

	public String toString() {
		return expr1.toString() + " " + op.toString() + " " + expr2.toString();
	}
}