import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) throws IOException {
        String resourcesPath = "C:/Users/1poja/IdeaProjects/Homework_8/resources";
        String [] folderLists = {"folder1","folder2", "folder3", "folder4", "folder5", "folder6","folder7", "folder8"};


        Path directoryPath = Paths.get(resourcesPath);
        try {
            Files.createDirectory(directoryPath);
            System.out.println("Директория создана");
        } catch (FileAlreadyExistsException e) {
            System.out.println("Директория уже существует");
        }

        for(int i = 0 ; i < 8; i++){
        File createFolders = new File(resourcesPath + File.separator + folderLists[i]);
            createFolders.mkdirs();
        }
        for(int i = 2 ; i < 9 ; i +=2){
            String nameFolder = "folder" + i;
            String nameFile = "File" + i + ".txt";
            String contain = "Это файл №" + i;
            String filePath = resourcesPath + File.separator + nameFolder + File.separator + nameFile;
            FileWriter writer = new FileWriter(filePath);
            writer.write(contain);
            writer.close();


        }

        try {
        for(String folderList : folderLists){
            File file =new File(resourcesPath +File.separator +folderList);
            System.out.println("Список файлов в папке: " + folderList);
            File[] files = file.listFiles();
                if(files != null){
                    for(File nameFile : files){
                        System.out.println("Имя файла  - " + nameFile.getName());
                        if(nameFile.isFile()){
                            FileReader fileReader = new FileReader(nameFile);
                            BufferedReader reader = new BufferedReader(fileReader);
                            String line;
                            while ((line = reader.readLine()) != null){
                                System.out.println(line);
                            }
                            reader.close();

                        }
                    }
                }

        }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}