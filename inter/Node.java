package inter;

import lexer.*;

/*
 * 	O pacote inter contém a hierarquia da classe Node. Node possui duas
 * subclasses: Expr para nós de expressão e Stmt para nós de comando.
 * 	Os nós na árvore sintática são implementados como objetos da classe Node.
 * Para o relato de erros, o campo lexline guarda o número da linha fonte
 * da construção nesse nó. As outras linhas são usadas para emitir código
 * de três endereços. 
 */

public class Node {
	int lexline = 0;
	Node() { lexline = Lexer.line; }
	void error(String s) { throw new Error("near line " + lexline + ": " + s); }
	static int labels = 0;
	public int newlabel() { return ++labels; }
	public void emitlabel(int i) { System.out.println("L" + i + ":"); }
	public void emit(String s) { System.out.println("\t" + s); }
}
