package personnages;

public class Romain {
    private String nom;
    private int force;

    public Romain(String nom, int force) {
        this.nom = nom;
        this.force = force;
        assert isInvariantVerified() : "La force d'un Romain doit être positive";
    }

    private boolean isInvariantVerified() {
        return force >= 0;
    }

    public String getNom() {
        return nom;
    }

    public void parler(String texte) {
        System.out.println(prendreParole() + "« " + texte + " »");
    }

    private String prendreParole() {
        return "Le romain " + nom + " : ";
    }

    public void recevoirCoup(int forceCoup) {
        // Précondition : la force du coup reçu est positive
        assert forceCoup >= 0 : "La force du coup reçu doit être positive";
        int forceInitiale = force;

        force -= forceCoup;
        if (force < 1) {
            force = 0;
            parler("J'abandonne !");
        } else {
            parler("Aïe");
        }

        // Postcondition : la force a diminué
        assert force < forceInitiale : "La force d'un Romain doit avoir diminué";
        // Invariant
        assert isInvariantVerified() : "La force d'un Romain doit être positive";
    }

    public static void main(String[] args) {
        // Test de l'invariant demandé en 2.a
        Romain minus = new Romain("Minus", 6);
    }
}