package com.Tawhidul;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public final class Utils {

  /*
   * replace all occurrences of keyWord in the file with the file name then return
   * the File
   */
  public static File replaceKeyWordWithFileName(File original, String keyWord) {
    File ret = new File("");
    try {
      String full = Files.readString(original.toPath());
      String fileName = original.getName();
      if (fileName.lastIndexOf(".") != -1) {
        fileName = fileName.substring(0, fileName.lastIndexOf("."));
      }
      String newFull = full.replace(keyWord, fileName);
      ret = Files.writeString(original.toPath(), newFull).toFile();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return ret;
  }
}
