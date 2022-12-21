package jogoDaVelha;

public class Tabuleiro {
	private int[][] tabuleiro = new int[3][3];

	public void zerarTabuleiro() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				tabuleiro[i][j] = 0;
	}

	public Tabuleiro() {
		zerarTabuleiro();
	}

	public void exibeTabuleiro() {
		System.out.println();
		for (int linha = 0; linha < 3; linha++) {

			for (int coluna = 0; coluna < 3; coluna++) {

				if (tabuleiro[linha][coluna] == -1) {
					System.out.print(" X ");
				}
				if (tabuleiro[linha][coluna] == 1) {
					System.out.print(" O ");
				}
				if (tabuleiro[linha][coluna] == 0) {
					System.out.print("   ");
				}
				if (coluna == 0 || coluna == 1)
					System.out.print("|");
			}
			System.out.println();
		}
	}

	public int getPosicao(int[] coordenada) {
		return tabuleiro[coordenada[0]][coordenada[1]];
	}

	public void setPosicao(int[] coordenada, int jogador) {
		if (jogador == 1)
			tabuleiro[coordenada[0]][coordenada[1]] = -1;
		else
			tabuleiro[coordenada[0]][coordenada[1]] = 1;

		exibeTabuleiro();
	}

	public int verificaLinhas() {
		for (int linha = 0; linha < 3; linha++) {

			if ((tabuleiro[linha][0] + tabuleiro[linha][1] + tabuleiro[linha][2]) == -3)
				return -1;
			if ((tabuleiro[linha][0] + tabuleiro[linha][1] + tabuleiro[linha][2]) == 3)
				return 1;
		}

		return 0;

	}

	public int verificaColunas() {
		for (int coluna = 0; coluna < 3; coluna++) {

			if ((tabuleiro[0][coluna] + tabuleiro[1][coluna] + tabuleiro[2][coluna]) == -3)
				return -1;
			if ((tabuleiro[0][coluna] + tabuleiro[1][coluna] + tabuleiro[2][coluna]) == 3)
				return 1;
		}

		return 0;

	}

	public int verificaDiagonais() {

		int somaDiagonalPrincipal = 0;
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				if (i == j) {
					somaDiagonalPrincipal += tabuleiro[i][j];
				}
			}
		}

		int j = tabuleiro.length - 1;
		int somaDiagonalSecundaria = 0;

		for (int i = 0; i < tabuleiro.length; i++) {
			somaDiagonalSecundaria += tabuleiro[i][j];
		}

		if ((somaDiagonalPrincipal) == -3)
			return -1;
		if ((somaDiagonalPrincipal) == 3)
			return 1;
		if ((somaDiagonalSecundaria) == -3)
			return -1;
		if ((somaDiagonalSecundaria) == 3)
			return 1;

		return 0;
	}

	public boolean tabuleiroCompleto() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (tabuleiro[i][j] == 0)
					return false;
		return true;
	}

}
