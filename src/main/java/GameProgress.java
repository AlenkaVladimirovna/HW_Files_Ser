import java.io.*;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }

    public static void saveGames(String string, GameProgress gameProgress){
        try(FileOutputStream fos = new FileOutputStream(string);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(gameProgress);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void zipFiles(String path, ArrayList<String> list){
        for(int i =0; i < list.size(); i++){
            try (ZipOutputStream zout = new ZipOutputStream(new
                    FileOutputStream(path));
                 FileInputStream fis = new FileInputStream(list.get(i))) {
                String name = "zip"+ (i+1) + ".txt";
                ZipEntry entry = new ZipEntry(name);
                zout.putNextEntry(entry);
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                zout.write(buffer);
                zout.closeEntry();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }


    }
    public static void cleanFiles(String string){
        File myFile = new File(string);
        if(myFile.delete()){
            System.out.println("file delete");
        }

    }

}