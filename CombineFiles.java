import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class CombineFiles {

    public static void main(String[] args) {
        // Define the paths of the three files to be combined
        Path file1 = Paths.get("/home/student/Music/PuzzleStart.java");
        Path file2 = Paths.get("/home/student/Music/Puzzle.java");
        Path file3 = Paths.get("/home/student/Music/GameHelper.java");
        
        // Define the path of the output file
        Path outputFile = Paths.get("combinedFile.txt");

        try {
            // Clear the output file if it exists or create a new one
            Files.write(outputFile, new byte[0], StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            
            // Append the contents of each file to the output file
            appendFileToOutput(file1, outputFile);
            appendFileToOutput(file2, outputFile);
            appendFileToOutput(file3, outputFile);
            
            System.out.println("Files combined successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void appendFileToOutput(Path inputFile, Path outputFile) throws IOException {
        // Read all bytes from the input file and write them to the output file
        byte[] fileContent = Files.readAllBytes(inputFile);
        Files.write(outputFile, fileContent, StandardOpenOption.APPEND);
    }
}

