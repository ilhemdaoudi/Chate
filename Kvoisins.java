import java.util.ArrayList;
import java.util.Collections;

public class Kvoisins implements Comparable<Kvoisins> {
	// le constructeur
	public Kvoisins(float x1, float y1, String classe) {
		this.id++;
		this.x1 = x1;
		this.y1 = y1;
		this.d = 0;
		this.classe = classe;
		this.suiv = null;
	}

	// la méthode Remplir pour entrée les exemples de base
	public static ArrayList<Kvoisins> remplir(ArrayList<Kvoisins> l) {
		System.out.println("Remplir les coordonées :");
		System.out.println("entrée X :");
		int a = Clavier.lireInt();
		System.out.println("entrée Y :");
		int b = Clavier.lireInt();
		System.out.println("entrée la clasee (yes/no):");
		String c = Clavier.lireString();
		Kvoisins v = new Kvoisins(a, b, c);
		l.add(v);
		System.out.println("voulez vous entrer d'autre coordonées (oui/non) :");
		String ch = Clavier.lireString();
		if (ch.equals("oui") || ch.equals("OUI"))
			Kvoisins.remplir(l);

		return l;

	}

	// la méthode Distance pour calculer la distance Euclidienne
	public ArrayList<Kvoisins> distance(ArrayList<Kvoisins> l) {

		for (int i = 0; i < l.size(); i++) {
			float d = (float) Math.sqrt(Math.abs(l.get(i).x1 - this.x1)
					+ Math.abs(l.get(i).y1 - this.y1));
			l.get(i).d = d;
		}
		return l;
	}

	// la méthode Combiner pour comparer les resultats et choisir la classe
	@SuppressWarnings("unchecked")
	public void combiner(ArrayList<Kvoisins> l1) {

		Collections.sort(l1);
		Kvoisins min1 = l1.get(0);
		Kvoisins min2 = l1.get(1);
		Kvoisins min3 = l1.get(2);
		System.out.println("les trois plus minimums sont :");
		System.out.println(min1.x1 + ", " + min1.y1 + ", " + min1.d + ", "
				+ min1.classe);
		System.out.println(min2.x1 + ", " + min2.y1 + ", " + min2.d + ", "
				+ min2.classe);
		System.out.println(min3.x1 + ", " + min3.y1 + ", " + min3.d + ", "
				+ min3.classe);
		if (min1.classe.equals(min2.classe)) {
			this.classe = min1.classe;
			System.out.println("la classe de la nouvelle instence devient :");
			System.out.println(this.x1 + ", " + this.y1 + ", " + this.classe);
		} else if (min1.classe.equals(min3.classe)) {
			this.classe = min1.classe;
			System.out.println("la classe de la nouvelle instence devient :");
			System.out.println(this.x1 + ", " + this.y1 + ", " + this.classe);
		} else {
			if (min2.classe.equals(min3.classe)) {
				this.classe = min2.classe;
				System.out
						.println("la classe de la nouvelle instence devient :");
				System.out.println(this.x1 + ", " + this.y1 + ", "
						+ this.classe);
			}
		}
		l1.add(this);
		affichage(l1);
	}

	// la méthode Remplir pour entrée les exemples de base
	public static void affichage(ArrayList<Kvoisins> l) {

		System.out.println("ID:  X:   Y:   Distance:  Classe   ");
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i).id + "   " + l.get(i).x1 + "   "
					+ l.get(i).y1 + "   " + l.get(i).d + "       "
					+ l.get(i).classe);

		}
	}

	// La méthode CompareTo pour comparer les elements de la liste
	@Override
	public int compareTo(Kvoisins k) {
		// TODO Auto-generated method stub

		int resultat = 0;
		if (this.d > k.d)
			resultat = 1;
		if (this.d < k.d)
			resultat = -1;
		if (this.d == k.d)
			resultat = 0;

		return resultat;
	}

	// les attribus de la classe
	private int id = 0;
	private float x1, y1, d;
	private String classe;
	private Kvoisins suiv;

}
