import java.util.Scanner;
public class Principal {
	public static void main(String args[]) {
		Scanner inp = new Scanner(System.in);
		String resposta;
		System.out.print("--Bem vindo ao Jogo da Velha--\n");
		System.out.print("Regras: O 1? Jogador criado ser? o 1? a jogar e sua letra ser? a X.\n");
		System.out.print("Regras: Jogue com letras mai?sculas.\n\n");
		System.out.print("Digite o nome do Jogador 1: ");
		String name1 = inp.next();
		System.out.print("Digite o nome do Jogador 2: ");
		String name2 = inp.next();
		
		Jogador player1 = new Jogador(name1,0);
		Jogador player2 = new Jogador(name2,0);
		
		
		
		do {
			System.out.print("Quanto o tamanho do tabuleiro ?: ");
			int size = inp.nextInt();
			System.out.println("\nLembre-se de jogar com letras mai?sculas!\n");
			JogoDaVelha game = new JogoDaVelha(size);
			for(int i=0;i<size*size;i++) {
				System.out.println(game.toString());
				game.diminuiJogadas();
				if(i%2 == 0)
					System.out.println("---? a vez da letra X !");
				else
					System.out.println("---E a vez da letra O !");
				System.out.print("Digite a linha desejada: ");
				int linha = inp.nextInt();
				System.out.print("Digite a coluna desejada: ");
				int coluna = inp.nextInt();
				System.out.print("Digite a letra X ou O desejada: ");
				char letra = inp.next().charAt(0);
				System.out.println("Jogada realizada? "+game.realizaJogada(linha, coluna, letra));
				game.exibeJogo();
				System.out.println("Teve um ganhador? "+game.verificaGanhador());
				if(game.verificaGanhador() == true) {
					if(letra == 'X') {
						System.out.println("O "+player1.getNome()+" Ganhou !");
						player1.aumentaPontos();;
					}else if(letra == 'O'){
						System.out.println("O "+player2.getNome()+" Ganhou !");
						player2.aumentaPontos();;
					}
					break;
				}
			}

			System.out.print("Desejam jogar novamente ?: ");
			resposta = inp.next();
		}while(resposta.equalsIgnoreCase("Sim"));
		
		if(player1.getPontos() > player2.getPontos())
			System.out.println(player1.toString());
		else if(player2.getPontos() > player1.getPontos())
			System.out.println(player2.toString());
		else
			System.out.println("Empate ambos marcaram "+player1.getPontos()+" pontos");
	}	
}
