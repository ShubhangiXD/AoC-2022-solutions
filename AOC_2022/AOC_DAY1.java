import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class AOC_DAY1 {
    private static final List<Integer> res = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        final File source = new File("AOC_DAY1_src.txt");
        final List<String> fileContent = Files.readAllLines(source.toPath(), UTF_8);
        System.out.println(puzzle1(fileContent));
        System.out.println(puzzle2());
    }

    private static int puzzle1(List<String> lines) {
        int curr = 0;
        for (String line : lines) {
            if (line.isBlank()) {
                res.add(curr);
                curr=0;
                continue;
            }
            curr += Integer.parseInt(line.strip());
        }
        Collections.sort(res);
        return Collections.max(res);
    }

    private static int puzzle2()
    {
        final List<Integer> top3 = new ArrayList<>(res.subList(res.size() - 3, res.size()));
        return top3.stream().mapToInt(Integer::intValue).sum();
    }
}