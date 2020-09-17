package warsztat.warsztat.model;

public enum Funkcja {

    DYREKTOR ("dyrektor"),
    MECHANIK ("mechanik"),
    KSIĘGOWA ("ksiegowa"),
    LAKIERNIK ("lakiernik");

    private String opis;

    Funkcja(String opis) {
        this.opis = opis;
    }

    public String getOpis() {
        return opis;
    }
}
