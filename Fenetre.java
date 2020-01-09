package tron;

import processing.core.PApplet;
import processing.core.PImage;

public class Fenetre extends PApplet {

	PImage bg;
	static final String auteurs = "Frederic et Thomas"; // les auteurs
	int bleu = color(0, 0, 255);
	int rouge = color(255, 0, 0);

	boolean depPossible = true;
	boolean depPossible1 = true;
	boolean depPossible2 = true;


	static final int tailleCase = 15; // nombre de pixels pour la largeur/hauteur d'une case

	int[][] casesOccuppees = new int [100][60];

	Joueur joueur1 = new Joueur(this, 100, 450, bleu);
	Joueur joueur2 = new Joueur(this, 1400, 450, rouge);

	public void settings() {
		size(100 * tailleCase, 60 * tailleCase, P2D); // mode 2d

	}

	public void setup() {
		frameRate(30); // 30 images par seconde
		surface.setTitle("Mini-projet : Tron par " + auteurs); // titre de la fenêtre
		bg = this.loadImage("tron.jpg"); // on charge l'image


		bg.resize(100 * tailleCase, 60 * tailleCase);

		//this.image(bg, 0, 0); // fond

		background(0);

		joueur1.dir = Direction.RIGHT; // direction de départ pour joueur 1
		joueur2.dir = Direction.LEFT; // direction de départ pour joueur 2

	}

	public void draw() {

		joueur1.dessinerJoueur(1, tailleCase); 
		joueur2.dessinerJoueur(2, tailleCase);
		joueur1.deplacer(tailleCase);
		joueur2.deplacer(tailleCase);	
		joueurSortieFenetre();
		joueurPercussion();

	}

	//méthode pour la gestion des collisions
	public void joueurPercussion () {
		if(joueur1.percute == true && joueur2.percute == true) { 

			partieTerminee(3);

		} else if(joueur1.percute == true) {

			partieTerminee(2);

		} else if(joueur2.percute == true) {

			partieTerminee(1);
		}

	}

	// méthode pour la gestion des sorties de fenetre
	public void joueurSortieFenetre() {
		depPossible1 = joueur1.sortieCadre(tailleCase); // vérif position pour joueur1 si sortie fenetre perdu
		depPossible2 = joueur2.sortieCadre(tailleCase); // vérif position pour joueur2 si sortie fenetre perdu

		if(depPossible1 == false && depPossible2 == false) { 

			partieTerminee(3);
			

		} else if(depPossible1 == false) {

			partieTerminee(2);
			
		} else if(depPossible2 == false) {

			partieTerminee(1);
			
		}



	}

	// méthode pour diriger joueur 1 (clavier) et 2 (fleche)
	public void keyPressed() {

		switch (key) {
		case 'q' :
			joueur1.dir = Direction.LEFT;
			break;
		case 'd' :
			joueur1.dir = Direction.RIGHT;
			break;
		case 'z' :
			joueur1.dir = Direction.UP;
			break;
		case 's' :
			joueur1.dir = Direction.DOWN;
			break;
		default:
			break;
		}

		switch (keyCode) { // 
		case LEFT :
			joueur2.dir = Direction.LEFT;
			break;
		case RIGHT :
			joueur2.dir = Direction.RIGHT;
			break;
		case UP :
			joueur2.dir = Direction.UP;
			break;
		case DOWN :
			joueur2.dir = Direction.DOWN;
			break;
		default:
			break;
		}

	}

	// méthode  qui stop la partie avec affichage de texte
	public void partieTerminee(int i) { 
		if (i == 1) {
			noLoop();
			textSize(70);
			fill (bleu);
			text("Joueur 1 gagne !", 500, 800);
		} else if (i == 2) {
			noLoop();
			textSize(70);
			fill(rouge);
			text("Joueur 2 gagne !", 500, 700);
		} else if (i == 3) {
			noLoop();
			textSize(70);
			fill (255);
			text("Match nul !", 500, 800);
		}
	}

	public static void main(String[] args) {
		PApplet.main("tron.Fenetre");
	}

}
