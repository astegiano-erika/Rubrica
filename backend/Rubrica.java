import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Vector;

public class Rubrica {

    private final Vector<Persona> elenco;
    private final File f;

    public Rubrica(String fileName) {
        this.elenco = new Vector<>();
        this.f = new File(fileName);
    }

    public void writeAllOnFile() {
        try (PrintStream out = new PrintStream(f)) {
            for (int i = 0; i < elenco.size(); i++) {
                Persona p = elenco.get(i);
                out.println(p.toTextFormat());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error writing file: " + f.getName(), e);
        }
    }
    public void readAllFromFile() {
        elenco.clear();

        if (!f.exists()) {
            return;
        }

        try (Scanner scanner = new Scanner(f)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }
                Persona p = Persona.toObjectFormat(line);
                elenco.add(p);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error reading file: " + f.getName());
        }
    }

    public Vector<Persona> getAll() {
        return elenco;
    }
    public void addPersona(Persona p) {
        elenco.add(p);
        writeAllOnFile();
    }
    public void updatePersona(int indice, Persona modifiche) {
        elenco.set(indice, modifiche);
        writeAllOnFile();
    }
    public void deletePersona(int indice) {
        elenco.remove(indice);
        writeAllOnFile();
    }
}
