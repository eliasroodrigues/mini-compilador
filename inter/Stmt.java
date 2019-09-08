package inter;

/*
* Código intermediário para comandos. 
* O construtor Stmt() não faz nada, porque o trabalho é feito nas
* subclasses. O objeto estático de Stmt.null representa uma sequência vazia de comandos.
*/

public class Stmt extends Node {
	public Stmt() { }
	public static Stmt Null = new Stmt();
	public void gen(int b, int a) {}      // chamado com rótulos begin e after
	int after = 0;                        // guarda rótulo after
	public static Stmt Enclosing = Stmt.null;    // usado para comandos break
}