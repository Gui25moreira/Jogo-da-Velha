package jogoDaVelha;

import java.util.Scanner;

public class Jogador {
	
	int[] coordenada = new int[2];
	int jogador;

	Scanner input = new Scanner(System.in);

	public Jogador(int jogador) {
		this.jogador = jogador;
	}
	
	public void jogar(Tabuleiro tabuleiro) {
		Coordenada(tabuleiro);
		tabuleiro.setPosicao(coordenada, jogador);
	}

	public void Coordenada(Tabuleiro tabuleiro) {
		do {
			do {
				System.out.print("Digite a linha: ");
				coordenada[0] = input.nextInt();

				if (coordenada[0] > 3 || coordenada[0] < 1)
					System.out.println("Linha inválida. Escolha 1,2 ou 3");

			} while (coordenada[0] > 3 || coordenada[0] < 1);

			do {
				System.out.print("Digite a Coluna: ");
				coordenada[1] = input.nextInt();

				if (coordenada[1] > 3 || coordenada[1] < 1)
					System.out.println("Coluna inválida. Escolha 1,2 ou 3");

			} while (coordenada[1] > 3 || coordenada[1] < 1);

			coordenada[0]--;
			coordenada[1]--;

			if (!checaCoordenada(coordenada, tabuleiro))
				System.out.println("A coordenada já está marcada, escolha outra!");
		} while (!checaCoordenada(coordenada, tabuleiro));
	}

	public boolean checaCoordenada(int[] coordenada, Tabuleiro tabuleiro) {
		if (tabuleiro.getPosicao(coordenada) == 0)
			return true;
		else
			return false;

	}
}
