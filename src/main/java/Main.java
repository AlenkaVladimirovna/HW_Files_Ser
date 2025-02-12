import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static StringBuilder builder = new StringBuilder();

    public static void newDir(String dirPath) {
        File newDir = new File(dirPath);
        if (newDir.mkdir()) {
            builder.append("Каталог ").append(dirPath).append(" создан");
        } else {
            builder.append("Каталог ").append(dirPath).append(" не создан или уже существует");
        }
    }

    public static void newFile(String dirPath) {
        File newFileName = new File(dirPath);
        try {
            if (newFileName.createNewFile()) {
                builder.append("Файл ").append(dirPath).append(" создан");
            } else {
                builder.append("Файл ").append(dirPath).append(" не создан или уже существует");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeStringBuilder() {
        try (FileWriter writer = new FileWriter("temp.txt")) {
            writer.write(builder.toString());
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        File dirl = new File("/Users/alenakruglova/Games");
        ArrayList<String> newDirPath = new ArrayList<>();
        newDirPath.add("/Users/alenakruglova/Games/src");
        newDirPath.add("/Users/alenakruglova/Games/res");
        newDirPath.add("/Users/alenakruglova/Games/savegames");
        newDirPath.add("/Users/alenakruglova/Games/temp");
        newDirPath.add("/Users/alenakruglova/Games/src/main");
        newDirPath.add("/Users/alenakruglova/Games/src/test");
        newDirPath.add("/Users/alenakruglova/Games/res/drawables");
        newDirPath.add("/Users/alenakruglova/Games/res/vectors");
        newDirPath.add("/Users/alenakruglova/Games/res/icons");
        for (String path : newDirPath) {
            newDir(path);
        }
        ArrayList<String> newFilePath = new ArrayList<>();
        newFilePath.add("/Users/alenakruglova/Games/src/main/Main.java");
        newFilePath.add("/Users/alenakruglova/Games/src/main/Utils.java");
        newFilePath.add("/Users/alenakruglova/Games/temp/temp.txt");
        for (String path : newFilePath) {
            newFile(path);
        }
        writeStringBuilder();

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
