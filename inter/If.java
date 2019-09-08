package inter;

import symbols.*;

/*
* O construtor da classe If constrói um nó para um comando if (E) S.
* Os campos expr e stmt contêm os nós para E e S, respectivamente. Observe
* que expr em letras minúsculas nomeia um campo de classe Expr; de modo semelhante,
* stmt nomeia um campo da classe Stmt.
*/

public class If extends Stmt {
	Expr expr; Stmt stmt;
	public If(Expr x, Stmt s) {
		expr = x; stmt = s;
		if ( expr.type != Type.Bool ) expr.error("boolean required in if");
	}

	public void gen(int b, int a) {
		int label = newlabel();  // rótulo do código para stmt
		expr.jumping(0, a);      // segue se for true, vai para a se for false
		emitlabel(label); stmt.gen(label, a); 
	}
}