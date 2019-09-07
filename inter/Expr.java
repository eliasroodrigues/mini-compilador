package inter;

import lexer.*; import symbols.*;

/*
 * 	Construção de expressão são implementados pela subclasses de Expr.
 * A classe em si possui campos op e type, representando o operador
 * e tipo, respectivamente, em um nó. 
 * 	O método gen() retorna um termo que pode caber no lado direito de um
 * comando de três endereços. Dada a expressão E = E1 + E2, o método gen()
 * retorna um termo x1 = x2, onde x1 + x2 são endereços para os valores de
 * E1 e E2, respectivamente.
 */

public class Expr extends Node {
	public Token op;
	public Type type;
	Expr(Token tok, Type p) { op = tok; type = p; }
	public Expr gen() { return this; }
	public Expr reduce() { return this; }
	public void jumping(int t, int f) { emitjumps(toString(), t, f); }
	public void emitjumps(String test, int t, int f) {
		if ( t != 0 && f != 0) {
			emit("if " + test + " goto L" + t);
			emit("goto L" + f);
		}
		else if ( t != 0 ) emit("if " + test + " goto L" + t);
		else if ( f != 0 ) emit("iffalse " + test + " goto L" + f);
		else ; // nada, porque ambos t e f fall through
	}
	
	public String toString() { return op.toString(); }
}
