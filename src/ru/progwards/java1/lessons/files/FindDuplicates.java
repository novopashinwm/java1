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
    List<Path> temporaryList = new ArrayList<>();

    public List<List<String>> findDuplicates(String startPath) {
        /* проходим по всем каталогам и собираем ссылки на все файлы, далее помещаем в temporaryList */
        try {
            Files.walkFileTree(Paths.get(startPath), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
                    temporaryList.add(path);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException e) {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sameFile();
    }

    private List<List<String>> sameFile() {
        List<List<String>> outerList = new ArrayList<>();
        List<String> innerList;
        Object firstLastMod = null;
        Object secondLastMod = null;
        String firstContent = null;
        String secondContent = null;
        long firstSize = 0;
        long secondSize = 0;
        for (int i = 0; i < temporaryList.size(); i++) {
            /* заводим новый внутренний ArrayList */
            innerList = new ArrayList<>();
            /* получаем путь из ArrayList */
            Path firstPath = temporaryList.get(i);
            try {
                /* получаем атрибут - дату последнего изменения файла */
                firstLastMod = Files.getAttribute(firstPath, "basic:lastModifiedTime");
                /* получаем все содержимое файла */
                firstContent = Files.readString(firstPath);
                /* получаем размер файла */
                firstSize = Files.size(firstPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int j = i + 1; j < temporaryList.size(); j++) {
                Path secondPath = temporaryList.get(j);
                try {
                    secondLastMod = Files.getAttribute(secondPath, "basic:lastModifiedTime");
                    secondContent = Files.readString(secondPath);
                    secondSize = Files.size(secondPath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                assert firstLastMod != null;
                assert firstContent != null;
                /* сравниваем файлы на равенство имен, последнего изменения, содержимого и размера */
                if (firstPath.getFileName().equals(secondPath.getFileName()) && firstLastMod.equals(secondLastMod)
                        && firstContent.equals(secondContent) && firstSize == secondSize) {
                    /* чтобы избежать повторного добавления пути из внешнего цикла, проверяем его наличие в ArrayList */
                    if (!innerList.contains(firstPath.toString())) innerList.add(firstPath.toString());
                    /* добавляем путь к файлу, совпавшему с проверяемым (из первого цикла) */
                    innerList.add(secondPath.toString());
                }
            }
            /* если внутренний ArrayList не пустой, добавляем его во внешний ArrayList */
            if (!innerList.isEmpty()) outerList.add(innerList);
        }
        /* очищаем временный ArrayList */
        temporaryList.clear();
        return outerList;
    }

}
