package com.Tawhidul;

import java.nio.file.Files;
import java.nio.file.Path;

import picocli.CommandLine.Command;

@Command(name = "list", description = "List all templates")
public class ListCommand implements Runnable {
  @Override
  public void run() {
    Path templatePath = TGen.getTemplatesPath();
    try {
      Files.list(templatePath).forEach(path -> System.out.println(path.toFile().getName()));
    } catch (Exception e) {
      System.err.println("failed listing templates in: " + templatePath);
      e.printStackTrace();
    }
  }

}
