import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList<Kvoisins> l = new ArrayList<Kvoisins>();
		Kvoisins.remplir(l);
		Kvoisins.affichage(l);
		System.out.println("Enter les coordon�es de la nouvelle instence:");
		System.out.println("entr�e X :");
		int a = Clavier.lireInt();
		System.out.println("entr�e Y :");
		int b = Clavier.lireInt();
		Kvoisins v = new Kvoisins(a, b, "");
		ArrayList<Kvoisins> l1 = v.distance(l);
		v.combiner(l1);

	}
}
