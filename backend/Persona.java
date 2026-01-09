public class Persona {

    private String nome;
    private String cognome;
    private String indirizzo;
    private String telefono;
    private int eta;

    //constructor
    public Persona(String nome, String cognome, String indirizzo, String telefono, int eta){
        this.nome=nome;
        this.cognome=cognome;
        this.indirizzo=indirizzo;
        this.telefono=telefono;
        this.eta=eta;
    }

    //getters
    public String getNome(){
        return nome;
    }
    public String getCognome(){
        return cognome;
    }
    public String getIndirizzo(){
        return indirizzo;
    }
    public String getTelefono(){
        return telefono;
    }
    public int getEta(){
        return eta;
    }

    //setters
    public void setNome(String nome){
        this.nome=nome;
    }
    public void setCognome(String cognome){
        this.cognome=cognome;
    }
    public void setIndirizzo(String indirizzo){
        this.indirizzo=indirizzo;
    }
    public void setTelefono(String telefono){
        this.telefono=telefono;
    }
    public void setEta(int eta){
        this.eta=eta;
    }

    //conversions and checks
    public String toTextFormat() {
        return this.nome + ";" + this.cognome + ";" + this.indirizzo + ";" + this.telefono + ";" + this.eta;
    }
    public static Persona toObjectFormat(String line) {
        String[] elem = line.split(";");
        return new Persona(elem[0], elem[1], elem[2], elem[3], Integer.parseInt(elem[4]));
    }

    //TO DO: add checks
}