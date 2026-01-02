package com.Tawhidul;

import java.io.File;
import java.nio.file.Path;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "remove", aliases = { "rm", "r" }, description = "Remove an existing template")
public class RemoveCommand implements Runnable {

  @Parameters(description = "template file to remove")
  File[] files;

  @Override
  public void run() {
    Path templatePath = TGen.getTemplatesPath();
    for (File file : files) {
      removeTemplate(templatePath, file);
    }
  }

  private void removeTemplate(Path path, File file) {
    file = path.resolve(file.getName()).toFile();
    if (file.exists() && file.delete()) {
      System.out.println("Template removed: " + file.getName());
      return;
    }
    System.err.println("Failed to remove template: '" + file.getName() + "'");
  }
}
