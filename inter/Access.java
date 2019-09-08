package inter;

import lexer.*; import symbols.*;

/*
* A linguagem fonte permite que valores boolianos sejam atribuidos a identificadores
* e a elementos de arranjo, do mode que uma expressão boolianda possa ser um acesso
* a arranjo. A classe possui o método gen para gerar código 'normal' e o método
* jumping para o código de desvio.
*/

public class Access extends Op {
	public Id array;
	public Expr index;
	public Access(Id a, Expr i, Type p) {    // p é o tipo de elemento após
		super(new Word("[]", Tag.INDEX), p); // achatar o arranjo
		array = a; index = i;
	}

	public Expr gen() { return new Access(array, index.reduce(), type); }
	public void jumping(int t, int f) { emitjumps(reduce().toString(), t, f); }
	public String toString() {
		return array.toString() + " [ " + index.toString() + " ] "; 
	}
}