package com.bondarenko.io.filemanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileManager {

    // public static int countFiles(String path) - принимает путь к папке,
    // возвращает количество файлов в папке и всех подпапках по пути
    public int countFiles(String path) {
        File file = new File(path);
        int countFiles = 0;
        try {
            for (File element : file.listFiles()) {
                if (element.isFile()) {
                    countFiles++;
                } else {
                    int count = countFiles(element.toString());// приймає path елемента, рекурсія, -рахує к-сть файлів
                    if (count != 0) {
                        countFiles = countFiles + count;
                    }
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("File is not found");
        }
        return countFiles;
    }

    //public static int countDirs(String path) - принимает путь к папке,
    // возвращает количество папок в папке и всех подпапках по пути
    public int countDirs(String path) {
        int countDirs = 0;
        File folder = new File(path);
        for (File item : folder.listFiles()) {
            if (item.isDirectory()) {
                countDirs++;
                int count = countDirs(item.toString());
                if (count != 0) {
                    countDirs = countDirs + count;
                }
            }
        }
        return countDirs;
    }

    //public static void copy(String from, String to) - метод по копированию папок и файлов.
    public void copy(String from, String to) {
        File pathFrom = new File(from);
        File pathTo = new File(to, pathFrom.getName());//вертає назву файла, папки з вказаним шляхом
        try {
            if (pathFrom.isDirectory()) {
                pathTo.mkdirs();
                File[] files = pathFrom.listFiles();
                for (File file : files) {
                    copy(file.getAbsolutePath(), pathTo.getAbsolutePath());
                }
            } else if (pathFrom.isFile()) {
                copyFile(pathFrom, pathTo);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("File or directory is not found");
        }
    }

    void copyFile(File pathFrom, File pathTo) throws IOException {
        int length = (int) pathFrom.length();//к-сть байтів
        byte[] buffer = new byte[length];
        if (length != 0) {
            FileInputStream fileInputStream = new FileInputStream(pathFrom);
            FileOutputStream fileOutputStream = new FileOutputStream(pathTo);
            try {
                fileInputStream.read(buffer);// чтение байтов из файла
                fileOutputStream.write(buffer);//запись байтов в файл.
            } catch (IOException exception) {
                throw new IllegalArgumentException();
            } finally {
                fileInputStream.close();
                fileOutputStream.close();
            }
        }
    }

    public void clean(File file) {
        File[] list = file.listFiles();
        checkNotNull(list);
        for (File files : list) {
            if (files.isDirectory()) {
                File newDir = new File(file + File.separator + files.getName());
                clean(newDir);
            }
            files.delete();
        }
        file.delete();
    }

    private static void checkNotNull(File[] file) {
        if (file == null) {
            throw new NullPointerException("Don't have permission to use file or not exist file");
        }
    }


    //метод по перемещению папок и файлов.
    // Параметр from - путь к файлу или папке, параметр to - путь к папке куда будет производиться перемищение.
    public void move(String from, String to) throws IOException {
        File pathFrom = new File(from);
        File pathTo = new File(to, pathFrom.getName());
        pathFrom.renameTo(pathTo);

        /*Method move #2 (Tolik):
       new File(from).renameTo(new File(to));*/
    }
}









