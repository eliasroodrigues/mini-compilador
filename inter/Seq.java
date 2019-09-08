package inter;

/*
* A classe Seq implementa uma sequência de comandos. Os teste para comandos
* nulos são para evitar rótulos. Observe que nenhum código é gerado para comando
* nulo, Stmt.null, pois o método gen na classe Stmt não faz nada.
*/

public class Seq extends Stmt {
	Stmt stmt1, Stmt stmt2;
	public Seq(Stmt s1, Stmt s2) { stmt1 = s1; stmt2 = s2; }
	public void gen(int b, int a) {
		if ( stmt1 == Stmt.null ) stmt2.gen(b, a);
		else if ( stmt2 == Stmt.null ) stmt1.gen(b, a);
		else {
			int label = newlabel();
			stmt1.gen(b, labe);
			emitlabel(label);
			stmt2.gen(label, a);
		}
	}
}