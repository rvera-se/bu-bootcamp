import java.io.*; 
import java.util.ArrayList;
 
public class GradeAnalyzer {
    static int skippedLines = 0;
    public static void main(String[] args) {
        double average;
        int lowestScore = Integer.MAX_VALUE;
        int highestScore = Integer.MIN_VALUE;
        int countA=0,countB=0,countC=0,countD=0,countF=0;

        ArrayList<Integer> scores = readScores("scores.txt");
        average = calculateAverage(scores);

        for(int i=0; i<scores.size(); i++){
            if (scores.get(i) > highestScore) highestScore = scores.get(i);
            if (scores.get(i) < lowestScore) lowestScore = scores.get(i);
            if (scores.get(i) >= 90) countA++;
            else if (scores.get(i) >= 80 && scores.get(i) <= 89) countB++;
            else if (scores.get(i) >= 70 && scores.get(i) <= 79) countC++;
            else if (scores.get(i) >= 60 && scores.get(i) <= 69) countD++;
            else countF++;
        }
        int[] counts = {countA,countB,countC,countD,countF};
        writeReport(scores, average, highestScore, lowestScore, "report.txt", counts);
    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        String line = "";
        ArrayList<Integer> scoreList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            if ((line = reader.readLine()) == null){
                System.out.println("Error: The file is empty.");
                return scoreList;
            }
            
            do {
                try{
                    if(!line.isEmpty()){
                        int n = Integer.parseInt(line.trim());
                        scoreList.add(n);
                    }
                } catch (NumberFormatException e) {
                    skippedLines++;
                    System.out.println("Skipping invalid value: " + line);
                    continue;
                }
            } while ((line = reader.readLine()) != null);
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
        return scoreList;
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        if(scores.isEmpty()) return 0.0;
        double sum = 0.0;
        for(int i=0; i<scores.size(); i++){
            sum += scores.get(i);
        }
        return sum / scores.size();
    }
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile, int[] gradeCounts) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("=== Grade Analysis Report ===");
            System.out.println("=== Grade Analysis Report ===");
            writer.newLine();
            writer.write(String.format("Total scores processed: %d%n", scores.size()));
            System.out.println(String.format("Total scores processed: %d", scores.size()));
            writer.write(String.format("Invalid lines skipped: %d%n", skippedLines));
            System.out.println(String.format("Invalid lines skipped: %d%n", skippedLines));
            writer.newLine();
            writer.write(String.format("Average score: %.2f%n", avg));
            System.out.println(String.format("Average score: %.2f", avg));
            writer.write(String.format("Highest score: %d%n", high));
            System.out.println(String.format("Highest score: %d", high));
            writer.write(String.format("Lowest score: %d%n", low));
            System.out.println(String.format("Lowest score: %d%n", low));
            writer.newLine();
            writer.write("Grade Distribution:");
            System.out.println("Grade Distribution:\n");
            writer.newLine();
            writer.write(String.format("A (90-100): %d%n", gradeCounts[0]));
            System.out.println(String.format("A (90-100): %d", gradeCounts[0]));
            writer.write(String.format("B (80-89): %d%n", gradeCounts[1]));
            System.out.println(String.format("B (80-89): %d", gradeCounts[1]));
            writer.write(String.format("C (70-79): %d%n", gradeCounts[2]));
            System.out.println(String.format("C (70-79): %d", gradeCounts[2]));
            writer.write(String.format("D (60-69): %d%n", gradeCounts[3]));
            System.out.println(String.format("D (60-69): %d", gradeCounts[3]));
            writer.write(String.format("F (0-59): %d", gradeCounts[4]));
            System.out.println(String.format("F (0-59): %d", gradeCounts[4]));
        } catch (IOException e) {
            System.out.println("Could not write file: " + e.getMessage());
        }
    }
} 