package inter;

import lexer.*; import symbols.*;

/*
* Na classe Or, o método jumping gera código de desvio para uma expressão
* booliana B = B1 || B2. Por um momento, suponha que nem a saída vedadeira t
* nem a saída falsa f de B seja rótulo especial 0. [...] As saídas verdadeira
* e false de B2 são as mesmas de B.
*/

public class Or extends Logical {
	public Or(Token tok, Expr x1, Expr x2) { super(tok, x1, x2); }
	public void jumping(int t, int f) {
		int label = t != 0 ? t : newlabel();
		expr1.jumping(label, 0);
		expr2.jumping(t, f);
		if ( t == 0 ) emitlabel(label);
	}
}