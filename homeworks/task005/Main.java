import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Date currentDate = new Date();

        String pathnameToGames = "Q://Games";
        String pathnameInTemp = "Q://Games//temp";
        String pathnameInMain = "Q://Games//src//main";
        File src = new File(pathnameToGames, "src");
        sb.append("Создан каталог src - " + currentDate + "\n");
        File res = new File(pathnameToGames, "res");
        sb.append("Создан каталог res - " + currentDate + "\n");
        File savegames = new File(pathnameToGames, "savegames");
        sb.append("Создан каталог savegames - " + currentDate + "\n");
        File temp = new File(pathnameToGames, "temp");
        sb.append("Создан каталог temp - " + currentDate + "\n");
        File main = new File(src, "main");
        sb.append("Создан подкаталог main в каталоге src - " + currentDate + "\n");
        File test = new File(src, "test");
        sb.append("Создан подкаталог main в каталоге src - " + currentDate + "\n");
        File drawables = new File(res, "drawables");
        sb.append("Создана директория drawables в каталоге res - " + currentDate + "\n");
        File vectors = new File(res, "vectors");
        sb.append("Создана директория vectors в каталоге res - " + currentDate + "\n");
        File icons = new File(res, "icons");
        sb.append("Создана директория icons в каталоге res - " + currentDate + "\n");
        File tempTxt = new File(pathnameInTemp, "temp.txt");
        sb.append("Создан файл temp.txt в каталоге res - " + currentDate + "\n");
        File mainJava = new File(pathnameInMain, "Main.java");
        File utilsJava = new File(pathnameInMain, "Utils.java");

        System.out.println(src.mkdir() + " - src");
        System.out.println(res.mkdir() + " - res");
        System.out.println(savegames.mkdir() + " - savegames");
        System.out.println(temp.mkdir() + " - temp");
        System.out.println(main.mkdir() + " - main");
        System.out.println(test.mkdir() + " - test");
        System.out.println(drawables.mkdir() + " - drawables");
        System.out.println(vectors.mkdir() + " - vectors");
        System.out.println(icons.mkdir() + " - icons");


        try {
            tempTxt.createNewFile();
            sb.append("Создан temp.txt в директории temp - " + currentDate + "\n");
            mainJava.createNewFile();
            sb.append("Создан Main.java в директории temp - " + currentDate + "\n");
            utilsJava.createNewFile();
            sb.append("Создан Utils.java в директории temp - " + currentDate + "\n");
            FileWriter writer = new FileWriter(tempTxt);
            writer.write(sb.toString());
            writer.close();
        } catch (IOException exception) {
            sb.append("Ошибка при создании файла" + currentDate);
        }
    }
}







