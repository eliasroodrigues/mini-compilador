package inter;

import lexer.*; import symbols.*;

/*
* A super classe espera dois operadores, de modo que b aparece duas vezes
* na chamada a super. Somente y é usado nos métodos. O método jumping simplesmente
* chama y.jumping com as saídas verdadeira e falsa invertidas.
*/

public class Not extends Logical {
	public Not(Token tok, Expr x2) { super(tok, x2, x2); }
	public void jumping(int t, int f) { expr2.jumping(f, t); }
	public String toString() { return op.toString() + " " + expr.toString(); }
}