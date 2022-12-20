package jogoDaVelha;

public class JogoDaVelha {

	private static Tabuleiro tabuleiro;
	private static Jogador jogador1;
	private static Jogador jogador2;
	private static int rodada = 1, vez = 1;
	
	public static void main(String[] args) {
		
		tabuleiro = new Tabuleiro();
		
		jogador1 = new Jogador(1);
		jogador2 = new Jogador(2);

		while (Jogar()) {
			;
		}
	}

	public static boolean Jogar() {
		if (ganhou() == 0) {
			System.out.println("----------------------");
			System.out.println("\nRodada " + rodada);
			System.out.println("É a vez do jogador " + vez());

			if (vez() == 1)
				jogador1.jogar(tabuleiro);
			else
				jogador2.jogar(tabuleiro);

			if (tabuleiro.tabuleiroCompleto()) {
				System.out.println("Tabuleiro foi completado, o jogo acabou.");
				return false;
			}
			vez++;
			rodada++;

			return true;
		} else {
			if (ganhou() == -1)
				System.out.println("Jogador 1 ganhou!");
			else
				System.out.println("Jogador 2 ganhou!");

			return false;
		}

	}

	public static int vez() {
		if (vez % 2 == 1)
			return 1;
		else
			return 2;
	}

	public static int ganhou() {
		if (tabuleiro.verificaLinhas() == 1)
			return 1;
		if (tabuleiro.verificaColunas() == 1)
			return 1;
		if (tabuleiro.verificaDiagonais() == 1)
			return 1;

		if (tabuleiro.verificaLinhas() == -1)
			return -1;
		if (tabuleiro.verificaColunas() == -1)
			return -1;
		if (tabuleiro.verificaDiagonais() == -1)
			return -1;

		return 0;
	}
}
