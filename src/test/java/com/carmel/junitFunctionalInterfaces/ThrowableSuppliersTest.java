package com.carmel.junitFunctionalInterfaces;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ThrowableSuppliersTest {
    private static final String FILE_DOES_NOT_EXIST = "does_not_exist";

    private static List<String> readLinesFromFile(String path) throws IOException{
        return Files.readAllLines(Path.of(path));
    }

    @Test
    public void testReadFile_DONOTEXIST(){
        assertThrows(NoSuchFileException.class,
                () -> readLinesFromFile(FILE_DOES_NOT_EXIST));
    }
}
