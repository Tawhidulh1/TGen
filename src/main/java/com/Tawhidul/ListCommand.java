package com.Tawhidul;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import picocli.CommandLine.Command;

@Command(name = "list", aliases = { "l", "li" }, description = "List all templates")
public class ListCommand implements Runnable {
  @Override
  public void run() {
    Path templatePath = TGen.getTemplatesPath();
    try {
      Files.list(templatePath).forEach(path -> System.out.println(path.toFile().getName()));
    } catch (IOException e) {
      System.err.println("Failed listing templates at: " + templatePath);
    }
  }

}
