package com.java8.helloidea.io.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Display a directory of only those files that are writable.
 * Created by jianwei on 16/7/17.
 */
public class DirList2 {
    public static void main(String args[]) {
        String dirname = ".";

        // Create a filter that returns true only for writable files.
        DirectoryStream.Filter<Path> how = new DirectoryStream.Filter<Path>() {
            public boolean accept(Path filename) throws IOException {
                if(Files.isWritable(filename)) return true;
                return false;
            }
        };

        // Obtain and manage a directory stream of writable files.
        try (DirectoryStream<Path> dirstrm =
                     Files.newDirectoryStream(Paths.get(dirname), how) )
        {
            System.out.println("Directory of " + dirname);

            for(Path entry : dirstrm) {
                BasicFileAttributes attribs =
                        Files.readAttributes(entry, BasicFileAttributes.class);

                if(attribs.isDirectory())
                    System.out.print("<DIR> ");
                else
                    System.out.print("      ");

                System.out.println(entry.getName(1));
            }
        } catch(InvalidPathException e) {
            System.out.println("Path Error " + e);
        } catch(NotDirectoryException e) {
            System.out.println(dirname + " is not a directory.");
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }
}
