package com.Tawhidul;

import java.io.File;
import java.nio.file.Path;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "remove", description = "Remove an existing template")
public class RemoveCommand implements Runnable {
  @Option(names = { "-f", "--file" }, description = "template file to remove", required = true)
  File file;

  @Override
  public void run() {
    Path templatePath = TGen.getTemplatesPath();
    try {
      File toRemove = templatePath.resolve(file.getName()).toFile();
      toRemove.delete();
    } catch (Exception e) {
      System.out.println("Failed to remove template: " + file.getName());
      e.printStackTrace();
    }
  }
}
