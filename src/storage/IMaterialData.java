package storage;

import model.Material;

import java.io.IOException;
import java.util.ArrayList;

public interface IMaterialData {
    ArrayList<Material> readFile();
    void writeFile(ArrayList<Material> arrayList) throws IOException;
}
