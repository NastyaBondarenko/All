package com.bondarenko.io.fileanalyzer.testfilemanager;

import com.bondarenko.io.filemanager.FileManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class FileManagerTest {
    FileManager fileManager = new FileManager();

    @Before
    public void before() throws IOException {

        new File("testDirectory").mkdir();
        new File("testDirectory/src").mkdir();
        new File("testDirectory/src/dir1").mkdir();
        new File("testDirectory/src/dir1/dir2").mkdir();
        new File("testDirectory2").mkdir();
        FileOutputStream fileOutputStream = new FileOutputStream("testDirectory/src/dir1/dir2/file1.txt");//отправка даних в файл на диске
        fileOutputStream.write("file1".getBytes());//записує єдиний байт у вихідний потік
        fileOutputStream.close();//закриває вихідний потім, записувать більш не можна
    }

    @Test
    public void testCountFiles() {
        assertEquals(1, fileManager.countFiles("testDirectory/src/dir1/dir2"));
    }

    @Test
    public void testCountDirs() {
        assertEquals(2, fileManager.countDirs("testDirectory/src"));
    }

    @Test
    public void testCopy() {
        fileManager.copy("C:\\Users\\ihor_PC\\Desktop\\testnew\\папка1", "C:\\Users\\ihor_PC\\Desktop\\testnew\\папка2");
    }

    @Test
    public void testMoveFilesOrDirs() throws IOException {
        fileManager.move("C:\\Users\\ihor_PC\\Desktop\\testnew\\moveFrom", "C:\\Users\\ihor_PC\\Desktop\\testnew\\moveTo");
    }

    @After
    public void after() {
        fileManager.clean(new File("testDirectory"));

    }
}


