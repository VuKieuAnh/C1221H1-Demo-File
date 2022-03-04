package storage;

import model.Material;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialFromFileBinary implements IMaterialData {
    @Override
    public ArrayList<Material> readFile() {
        File file = new  File("list1.dat");
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object result = ois.readObject();
            ArrayList<Material> materialList = (ArrayList<Material>) result;
            ois.close();
            fis.close();
            return materialList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();    }

    @Override
    public void writeFile(ArrayList<Material> arrayList) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos=null;
        try {
            fos = new FileOutputStream("list1.dat");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(arrayList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            oos.close();
            fos.close();
        }
    }
}
