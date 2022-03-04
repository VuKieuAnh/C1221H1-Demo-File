package controller;

import model.Material;
import storage.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MaterialManager {
    public static IMaterialData materialData = new MaterialFormFileWord();
    public static ArrayList<Material> materialList= materialData.readFile();

    public static void addNewMaterial(Material newMaterial){
        materialList.add(newMaterial);
        try {
            materialData.writeFile(materialList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getMaterialByID(String materialCode){
        for (int i=0; i< materialList.size(); i++) {
            Material material = materialList.get(i);
            if (material.getId().equals(materialCode))
                return i;
        }
        return -1;
    }
    public int getMaterialByName(String name){
        for (int i=0; i< materialList.size(); i++) {
            Material material = materialList.get(i);
            if (material.getName().equals(name))
                return i;
        }
        return -1;
    }

    public static void editMaterialByIndex(int index, Material newMaterial){
        materialList.set(index, newMaterial);
    }
}
