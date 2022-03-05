import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void main(String[] args) {
        final String pathname = "Q://Games//savegames//";
        List<String> savedFiles = new ArrayList<>();
        List<GameProgress> gameProgress = Arrays.asList(
                new GameProgress(100, 1, 1, 30.4),
                new GameProgress(50, 5, 5, 20.5),
                new GameProgress(25, 7, 10, 5.1)
        );


        for (int i = 0; i < gameProgress.size(); i++) {
            String datPath = pathname + "save" + i + ".dat";
            if (saveGame(datPath, gameProgress.get(i)))
                savedFiles.add(datPath);
        }

        zipFiles(pathname + "zip.zip", savedFiles);
        deleteFiles(savedFiles);
    }

    public static Boolean saveGame(String path, GameProgress gp) {
        try (FileOutputStream stream = new FileOutputStream(path);
             ObjectOutputStream outputStream = new ObjectOutputStream(stream)) {
            outputStream.writeObject(gp);
            System.out.println("Сохранение записано в  " + path);
            return true;
        } catch (Exception ex) {
            System.out.println("Ошибка при записи сохранения " + ex.getMessage());
            return false;
        }
    }

    public static void zipFiles(String path, List<String> savedFiles) {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(path))) {
            System.out.println("Создание архива в " + path);
            for (String sflist : savedFiles) {
                try (FileInputStream fileInputStream = new FileInputStream(sflist)) {
                    ZipEntry entry = new ZipEntry(new File(sflist).getName());
                    zipOutputStream.putNextEntry(entry);
                    byte[] buffer = new byte[fileInputStream.available()];
                    fileInputStream.read(buffer);
                    zipOutputStream.write(buffer);
                    zipOutputStream.closeEntry();
                    System.out.println("Файл " + sflist + " добавлен в архив!");
                } catch (IOException ex) {
                    System.out.println("Ошибка сжатия файлов сохранения: " + ex.getMessage());
                }
            }
        } catch (Exception ex) {
            System.out.println("Ошибка сжатия файлов сохранения: " + ex.getMessage());
        }
    }

    private static void deleteFiles(List<String> savedFiles) {
        for (String sflist : savedFiles) {
            File fileToDel = new File(sflist);
            if (fileToDel.delete()) {
                System.out.println("Файл " + sflist + " удален!");
            } else {
                System.out.println("Файл " + sflist + " не был удален!");
            }
        }
    }
}