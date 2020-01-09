package tron;

import processing.core.PApplet;

public class Joueur {
	// TODO Auto-generated method stub
	
    // attributs
	int x; 
	int y;
	int num;
	Fenetre fenetre;
	int couleur;
	Direction dir;
	boolean percute = false;

	Joueur(Fenetre fenetre, int x, int y, int couleur) { // constructeur avec attributs
		this.fenetre = fenetre;
		this.x = x;
		this.y = y;
		this.couleur = couleur;
	}

	void dessinerJoueur(int n, int tc) { // méthode pour dessiner joueur avec des cases et verifie si occuppe ou vide
		if (fenetre.casesOccuppees[x/tc][y/tc] == 0) {
			fenetre.casesOccuppees[x/tc][y/tc] = n;
			fenetre.fill(couleur);
			fenetre.noStroke();
			fenetre.rect(x, y, tc, tc);
		} else {
			percute = true;
			fenetre.noLoop();
			return;
		}
	}
	
	boolean sortieCadre(int tailleCase) { // vérif position pour sortie fenetre
		return -15 < x && x < (100*tailleCase) && -15 < y && y < (60*tailleCase);
	}
	
	void deplacer(int tailleCase) { // méthode pour déplacer les joueurs

		if (dir == Direction.UP) {
			y -= tailleCase;
		} else if (dir == Direction.DOWN) {
			y += tailleCase;
		} else if (dir == Direction.LEFT) {
			x -= tailleCase;
		} else if (dir == Direction.RIGHT) {
			x += tailleCase;
		}
	
		}
	
	

	}


	
