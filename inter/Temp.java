package inter;

import lexer.*; import symbols.*;

/*
* Os nomes temporários têm tipo como todas as outras
* expressões. O construtor Temp. portanto, é chamado com
* um tipo como parâmetro.
*/

public class Temp extends Expr {
	static int count = 0;
	int number = 0;
	public Temp(Type p) { super(Word.temp, p); number = ++count; }
	public String toString() { return "t" + number; } 
}