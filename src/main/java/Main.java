import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        File dirl = new File("/Users/alenakruglova/Games");


        File src = new File(dirl, "src");
        if (src.mkdir())
            builder.append("Каталог src создан");

        File res = new File(dirl, "res");
        if (res.mkdir())
            builder.append("Каталог res создан");

        File savegames = new File(dirl, "savegames");
        if (savegames.mkdir())
            builder.append("Каталог savegames создан");

        File temp = new File(dirl, "temp");
        if (temp.mkdir())
            builder.append("Каталог temp создан");

        File main = new File(src, "main");
        if (main.mkdir())
            builder.append("Каталог main создан");

        File test = new File(src, "test");
        if (test.mkdir())
            builder.append("Каталог test создан");

        File myMain = new File(main, "Main.java");
        try {
            if (myMain.createNewFile())
                builder.append("Файл Main.java созан");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        File myUtils = new File(main, "Utils.java");
        try {
            if (myUtils.createNewFile())
                builder.append("Файл Utils.java создан");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        File drawables = new File(res, "drawables");
        if (drawables.mkdir())
            builder.append("Каталог drawables создан");

        File vectors = new File(res, "vectors");
        if (vectors.mkdir())
            builder.append("Каталог vectors создан");

        File icons = new File(res, "icons");
        if (icons.mkdir())
            builder.append("Каталог icons создан");

        File myTemp = new File(temp, "temp.txt");
        try {
            if (myTemp.createNewFile())
                builder.append("Файл temp.txt создан");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (FileWriter writer = new FileWriter("temp.txt")) {
            writer.write(builder.toString());
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        GameProgress game1 = new GameProgress(10, 3, 2, 1000);
        GameProgress game2 = new GameProgress(8, 4, 6, 4500);
        GameProgress game3 = new GameProgress(3, 5, 9, 8000);

        ArrayList<String> stringGame = new ArrayList<>();
        stringGame.add("/Users/alenakruglova/Games/savegames/game1.dat");
        stringGame.add("/Users/alenakruglova/Games/savegames/game2.dat");
        stringGame.add("/Users/alenakruglova/Games/savegames/game3.dat");

        GameProgress.saveGames(stringGame.get(0), game1);
        GameProgress.saveGames(stringGame.get(1), game2);
        GameProgress.saveGames(stringGame.get(2), game3);

        String stringZipPath = "/Users/alenakruglova/Games/savegames/zip.zip";

        GameProgress.zipFiles(stringZipPath, stringGame);

        GameProgress.cleanFiles(stringGame.get(0));
        GameProgress.cleanFiles(stringGame.get(1));
        GameProgress.cleanFiles(stringGame.get(2));


    }
}
