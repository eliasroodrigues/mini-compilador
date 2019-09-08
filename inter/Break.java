package  inter;

/*
* A classe break usaoo campo stmt para guardar a construção do comando
* encolvente. O código para um objeto break é um desvio para o ŕotulo
* stmt.after, que marca a instrução imediatamente após o código para stmt.
*/

public class Break extends Stmt {
	Stmt stmt;
	public Break() {
		if ( Stmt.Enclosing == null ) error("unclosed break");
		stmt = Stmt.Enclosing;
	}

	public void gen(int b, int a) {
		emit("goto L" + stmt.after);
	}
}