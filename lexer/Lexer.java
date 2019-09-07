package lexer;

import java.io.*; import java.util.*; import symbols.*;

public class Lexer {

	public static void main(String[] args) {
		/*
		 * O Lexer() reserva palavras-chave selecionadas e
		 * alguns lexemas, conforme definidos em outras
		 * partes. Os objetos Word.True e Word.False são
		 * definidos de Word. Os objetos para tipos básicos
		 * int, char, bool e float são definidos na classe
		 * Type. A classe Type faz parte do pacote symbols. 
		 */
		
		public static int line = 1;
		char peek = '';
		Hashtable words = new Hashtable();
		void reserve(Word w) { words.put(w.lexeme, w) }
		public Lexer() {
			reserve( new Word( "if", Tag.IF )         );
			reserve( new Word( "else", Tag.ELSE )     );
			reserve( new Word( "while", Tag.WHILE )   );
			reserve( new Word( "do", Tag.DO )         );
			reserve( new Word( "break", Tag.BREAK )   );
			reserve( Word.True ); reserve( Word.False );
			reserve( Type.Int ); reserve( Type.Char ); 
			reserve( Type.Bool ); reserve( Type.Float );
		}
		
		
		/*
		 * A função readch() é usada para ler o próximo caracter
		 * de entrada para a variável 'peek'. O nome da função
		 * é sobrecarregado para reconhecer tokens compostos.
		 */
		
		void readch() throws IOException { peek = (char)System.in.read(); }
		boolean readch(char c) throws IOException { 
			readch();
			if ( peek != c ) return false;
			peek = '';
			return true;
		}
		
		/*
		 * A função ignora os espaços em branco. 
		 */
		
		public Token scan() throws IOException {
			for ( ; ; readch() ) {
				if ( peek == '' | peek == '\t' ) continue;
				else if ( peek == '\n' ) line = line + 1;
				else break;
			}
		}
		
		/*
		 * O switch reconhece os tokens compostos, como '==' ou
		 * '>=' e etc. 
		 */
		
		switch( peek ) {
		case '&':
			if ( readch('&') ) return Word.and; else return new Token('&');
		case '|':	
			if ( readch('|') ) return Word.or; else return new Token('|');
		case '=':
			if ( readch('=') ) return Word.eq; else return new Token('=');
		case '!':
			if ( readch('=') ) return Word.ne; else return new Token('!');
		case '<':
			if ( readch('=') ) return Word.le; else return new Token('<');
		case '>':
			if ( readch('=') ) return Word.ge; else return new Token('>');
		}
		
		/*
		 * A seguir são reconhecidos números como os números 365 ou 3.14. 
		 */
		
		if ( Character.isDigit(peek) ) {
			int v = 0;
			do {
				v = 10*v + Character.digit(peek, 10); readch();
			} while( Character.isDigit(peek));
			if ( peek != '..' ) return new Num(v);
			float x = v; float d = 10;
			for (;;) {
				readch();
				if ( ! Character.isDigit(peek) ) break;
				x = x + Character.digit(peek, 10) / d; d = d*10;
			}
			return new Real(x);
		}
		
		/*
		 * A seguir reconhece palavras.
		 */
		
		if ( Character.isLetter(peek) ) {
			StringBuffer b = new StringBuffer();
			do {
				b.append(peek); readch();
			} while ( Character.isLetterOrDigit(peek) );
			String s = b.toString();
			Word w = (Word)words.get(s);
			if ( w != null ) return w;
			w = new Word(s, Tag.ID);
			words.put(s, w);
			return w;
		}

		Token tok = new Token(peek); peek = '';
		return tok;
	}

}
