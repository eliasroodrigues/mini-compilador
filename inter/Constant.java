package inter;

import lexer.*; import symbols.*;

/*
* O código de desvio de uma expressão booliana B é gerado pelo método
* jumping, que recebe dois rótulos t e f como parâmetros. O rótulo especial
* 0 significa que o controle passa por B em direção a próxima instrução
* após o código de B.
*
* O método jumping utiliza dois parâmetros, rotulados t e f. Se ess constante
* for o objeto estático True e t não for o rótulo especial 0, então um desvio
* para t é gerado, caso contrário, se esse for o objeto False e f não for 0
* um desvio para f é gerado.
*/

public class Constant extends Expr {
	public Constant(Token tok, Type p) { super(tok, p); }
	public Constant(int i) { super(new Num(i), Type.Int); }
	public static final Constant
		True  = new Constant(Word.True, Type.Bool),
		False = new Constant(Word.False, Type.Bool);

	public void jumping(int t, int f) {
		if ( this == True && t != 0 ) emit("goto L" + t);
		else if ( this == False && f != 0 ) emit("goto L" + f);
	}
}