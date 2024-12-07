package aoc;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Hello world!
 */
public class MyInit {
    String sampleName = "input";

    void inItDirectories() {

        // Define the directory and file path
        Path directoryPath = Paths.get("input");
        Path src = Paths.get("src/main/java/aoc");
        Path test = Paths.get("src/test/java/aoc");

        try {
            // Create the directories if they don't exist
            if (Files.notExists(directoryPath)) {
                Files.createDirectories(directoryPath);
            }
            LocalDateTime myDateObj = LocalDateTime.of(2024, 12, 1, 0, 0);
            for (int i = 0; i < 25; i++) {
                // Create the file if it doesn't exist
                String name = myDateObj.plus(i, ChronoUnit.DAYS).format(DateTimeFormatter.ofPattern("dd"));
                try {
                    Files.createFile(directoryPath.resolve(name + "-small.txt"));
                    Files.createFile(directoryPath.resolve(name + "-input.txt"));

                } catch (IOException e) {
                }
                String content = "package aoc;\n" + //
                        "\n" + //
                        "import java.io.IOException;\n" + //
                        "import java.nio.file.Files;\n" + //
                        "import java.nio.file.Path;\n" + //
                        "import java.nio.file.Paths;\n" + //
                        "import java.util.ArrayList;\n" + //
                        "import java.util.List;\n" + //
                        "\n" + //
                        "public class Day" + name + " {\n" + //
                        "    String sampleName = \"" + name + "-small.txt\";\n" + //
                        "    String inputName =\"" + name + "-input.txt\";\n" + //
                        "\n" + //
                        "    List<String> readInput(String path) {\n" + //
                        "\n" + //
                        "        // Define the directory and file path\n" + //
                        "        Path directoryPath = Paths.get(path);\n" + //
                        "\n" + //
                        "        try {\n" + //
                        "            List<String> data = Files.readAllLines(directoryPath);\n" + //
                        "\n" + //
                        "            return data;\n" + //
                        "        } catch (IOException e) {\n" + //
                        "            e.printStackTrace();\n" + //
                        "        }\n" + //
                        "        return new ArrayList<>();\n" + //
                        "    }\n" + //
                        "\n" + //
                        "    void partOne() {\n" + //
                        "        System.out.println(\"Day " + name +", Part 1\");\n" + //
                        "    }\n" + //
                        "\n" + //
                        "    void partTwo() {\n" + //
                        "        System.out.println(\"Day " + name +", Part 2\");\n" + //
                        "    }\n" + //
                        "}\n" + //
                        "";
                try {
                    Files.createFile(src.resolve("Day" + name + ".java"));
                    Files.write(src.resolve("Day" + name + ".java"), content.getBytes(StandardCharsets.UTF_8));
                } catch (IOException e) {
                }
                String contentTest = "package aoc;\n" + //
                "\n" + //
                "import org.junit.jupiter.api.Test;\n" + //
                "\n" + //
                "public class Day"+name+"Test {\n" + //
                "\n" + //
                "    @Test\n" + //
                "    public void shouldAnswerPartOne() {\n" + //
                "        Day"+name+" day"+name+" = new Day"+name+"();\n" + //
                "        day"+name+".partOne();\n" + //
                "    }\n" + //
                "\n" + //
                "    @Test\n" + //
                "    public void shouldAnswerPartTwo() {\n" + //
                "        Day"+name+" day"+name+" = new Day"+name+"();\n" + //
                "        day"+name+".partTwo();\n" + //
                "    }\n" + //
                "}";
                try {
                    Files.createFile(test.resolve("Day" + name + "Test.java"));
                    Files.write(test.resolve("Day" + name + "Test.java"), contentTest.getBytes(StandardCharsets.UTF_8));
                } catch (IOException e) {
                }
            }

        } catch (IOException e) {
        }
    }
}
