package symbols;

import java.util.*; import lexer.*; import inter.*;

/*
 * A classe Env mapeia tokens de palavra a objetos da classe Id,
 * que é definida no pacote inter com a classe para as expressões
 * e comandos. 
 */

public class Env {
	private Hashtable table;
	protected Env prev;
	public Env(Env n) { table = new Hashtable(); prev = n; }
	public void put(Token w, Id i) { table.put(w, i); }
	public Id get(Token w) {
		for ( Env e = this; e != null; e = e.prev ) {
			Id found = (Id)(e.table.get(w));
			if ( found != null ) return found;
		}
		return null;
	}
}
