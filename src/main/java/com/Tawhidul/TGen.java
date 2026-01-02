package com.Tawhidul;

import java.nio.file.Files;
import java.nio.file.Path;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "tgen", subcommands = { AddCommand.class, RemoveCommand.class, UseCommand.class,
    ListCommand.class }, version = "tgen-1.0", mixinStandardHelpOptions = true, description = "template generation and management tool")
public class TGen {

  public static void main(String[] args) {
    int exitCode = new CommandLine(new TGen()).execute(args);
    System.exit(exitCode);
  }

  public static Path getTemplatesPath() {
    String userHome = System.getProperty("user.home");
    Path path = Path.of(userHome, ".tgen", "templates");
    try {
      Files.createDirectories(path);
    } catch (Exception e) {
      System.err.println("failed creating tamplate directory: " + path);
      e.printStackTrace();
      System.exit(1);
    }
    return path;
  }
}
