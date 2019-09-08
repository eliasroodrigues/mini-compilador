package inter;

import symbols.*;

/*
* A construção de um objeto while é dividida entre o construtor While(),
* que cria um nó com filhos nulos e uma função de inicalização, que define
* o filho de expr x e o filho de stmt como s. A função gen(b, a) para gerar
* o código de três endereços está no mesmo espírito da função correspondente gen()
* na classe If.
*/

public class While extends Stmt {
	Expr expr; Stmt stmt;
	public While() { expr = null; stmt = null; }
	public void init(Expr x, Stmt s) {
		expr = x; stmt = s;
		if ( expr.type != Type.Bool ) expr.error("boolean required in while");
	}

	public void gen(int b, int a) {
		after = a;                   // guarda rótulo a
		expr.jumping(0, a);
		int label = newlabel();      // rótulo para comando
		emitlabel(label); stmt.gen(label, b);
		emit("goto L" + b);
	}
}