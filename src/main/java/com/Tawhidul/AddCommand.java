package com.Tawhidul;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "add", aliases = { "a" }, description = "Add a new template")
public class AddCommand implements Runnable {
  @Parameters(description = "files to add as template")
  private File[] files;

  @Override
  public void run() {
    Path templatePath = TGen.getTemplatesPath();
    for (File file : files) {
      addTemplate(templatePath, file);
    }
  }

  private void addTemplate(Path path, File file) {
    try {
      Files.copy(file.toPath(), path.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);
      System.out.println("Added template: " + file.getName());
    } catch (IOException e) {
      System.err.println("Failed to add template: " + file.getName());
    }
  }

}
