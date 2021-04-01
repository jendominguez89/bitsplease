package bitsSearch;

import java.io.*;

public class PathTest {
    String path;
    public PathTest() {
        File pwd = this.getClass().getClassLoader().getResource(".").getPath();
        System.out.println(pwd);
    }
}