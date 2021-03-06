
public class JogoDaVelha {
	private char[][] tabuleiro;
	private int numeroJogadas;
	
	public JogoDaVelha(int tamanho) {
		tabuleiro = new char[tamanho][tamanho];
		numeroJogadas = tabuleiro.length*tabuleiro.length;
	}
	
	public boolean verificaDiagonal(char letra){
		int cont = 0;
		int cont2 = 0;
		int cont3 = 1;
		for(int i=0;i<tabuleiro.length;i++) {
			if(tabuleiro[i][i] == letra)
				cont++;
		}
		
		for(int i=0;i<tabuleiro.length;i++) {
			if(tabuleiro[i][tabuleiro.length-cont3] == letra)
				cont2++;
			cont3++;
		}
		
		if(cont == tabuleiro.length || cont2 == tabuleiro.length)
			return true;
		return false;
	}
	
	public boolean verificaColuna(char letra) {
		int cont = 0;
		for(int coluna =0;coluna<tabuleiro.length;coluna++) {
			if(cont == tabuleiro.length)
				return true;
			else
				cont = 0;
			for(int linha=0;linha<tabuleiro[coluna].length;linha++) {
				if(tabuleiro[linha][coluna] == letra)
					cont++;
			}
		}
		if(cont == tabuleiro.length)
			return true;
		return false;
	
	}
	
	public boolean verificaLinha(char letra) {
		int cont = 0;
		for(int linha=0;linha<tabuleiro.length;linha++) {
			if(cont == tabuleiro.length)
				return true;
			else
				cont = 0;
			for(int coluna=0;coluna<tabuleiro[linha].length;coluna++) {
				if(tabuleiro[linha][coluna] == letra)
					cont++;
			}
		}
		if(cont == tabuleiro.length)
			return true;
		return false;
	}
	
	public boolean realizaJogada(int linha,int coluna,char letra){
		if(tabuleiro[linha][coluna] == 0 && letra == 'X' || tabuleiro[linha][coluna] == 0 && letra == 'O') {
			tabuleiro[linha][coluna] = letra;
			return true;
		}
		return false;
	}
	
	public boolean verificaGanhador() {
		if(verificaDiagonal('X') == true || verificaDiagonal('O') == true)
			return true;
		else if(verificaLinha('X') == true || verificaLinha('O') == true)
			return true;
		else if(verificaColuna('X')== true || verificaColuna('O') == true)
			return true;
		return false;
	}
	
	public void exibeJogo() {
		for(int linha =0;linha<tabuleiro.length;linha++) {
			System.out.println();
			for(int coluna=0;coluna<tabuleiro[linha].length;coluna++) {
				System.out.print(tabuleiro[linha][coluna]);
				if(coluna<tabuleiro.length-1)
				System.out.print('|');
			}
		}
		System.out.println("\n");
	}
	
	public void diminuiJogadas(){
		numeroJogadas--;
	}
	
	public String toString() {
		return "\nO tabuleiro tem "+numeroJogadas+" posi??es validas \n";
	}
}
