package ru.progwards.java1.lessons.files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Задача 1, класс FindDuplicates: не пройдено, оценка: 0.0
Комментарий:
ERROR: Тест "Метод findDuplicates(String startPath)" не пройден. Метод работает неправльно.
В целевом каталоге находятся файлы file1 и file2.
Идентичные им файлы находятся в подкаталогах file1: dir1 и dir2/dir3, file2: dir2.
В подкаталоге dir1 находится файл file3, идентичный которому файл находится в подкаталоге dir2/dir3.
В подкаталоге dir2 находится файл file1, который отличается от ранее упомянутого файла file1 только содержимым, но не размером и временем.
В подкаталоге dir1 находится файл file2, который отличается от ранее упомянутого файла file2 только временем.
Возвращены списки строк, содержащие:
Ожидалось:
dir2/file2, file2
dir1/file1, dir2/dir3/file1
dir1/file3, dir2/dir3/file3
* */
public class FindDuplicates {
    //    Создание Map с именами файлов по результатам сравнения файлов
    private List<Path> fileList(String start){
        List<Path> fileList = new ArrayList<>();
        Path pathFile = Paths.get(start);
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**/**");
        try {
            Files.walkFileTree(pathFile, new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
//                    if (pathMatcher.matches(pathFile.relativize(path))) {
                    if (pathMatcher.matches(path)) {
                        fileList.add(path);
                        return FileVisitResult.CONTINUE;
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileList;
    }


    // сравнение файлов по атрибутам и содержимому
    private boolean fullFiltr(Path file1, Path file2){
        try {
            if (Files.getAttribute(file1, "lastModifiedTime").equals(Files.getAttribute(file2,
                    "lastModifiedTime")) &&
                    Files.getAttribute(file1, "size").equals(Files.getAttribute(file2, "size"))) {
                if (Arrays.equals(Files.readAllBytes(file1), Files.readAllBytes(file2))) {
//                    System.out.println("Сошлись)");
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    //    обработка Map и вывод результата
    public List<List<String>> findDuplicates(String startPath){
        List<List<String>> result = new ArrayList<>();
        List<Path> tmpFileList = fileList(startPath);

        for (int i = 0; i < tmpFileList.size(); i++) {
            Path file1 = tmpFileList.get(i);
            List<String> filePathList = new ArrayList<>();
            for (int f = i+1; f < tmpFileList.size(); f++) {
                Path file2 = tmpFileList.get(f);
                if (file1.getFileName().compareTo(file2.getFileName()) == 0 && fullFiltr(file1, file2)) {
                    filePathList.add(file1.toString());
                    filePathList.add(file2.toString());
                    tmpFileList.remove(f);
                }
            }
            result.add(filePathList);
        }
        return result;
    }

}
