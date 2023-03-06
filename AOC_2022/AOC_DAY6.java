import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import static java.nio.charset.StandardCharsets.UTF_8;

public class AOC_DAY6 {
    public static void main(String[] args) throws IOException {
        final File src = new File("AOC_DAY6_src.txt");
        final String fileContent = Files.readString(src.toPath(), UTF_8);

        final char[] chars = fileContent.toCharArray();

        System.out.println(puzzle1(chars));
        System.out.println(puzzle2(chars));
    }

    private static int puzzle1(char[] chars) {
        loop: for (int i = 4 - 1; i < chars.length; i++) {
            int count = 0;
            for (int x = i; x > i - 4; x--) {
                final int ch = chars[x] - 'a';
                final int count2 = 1 << ch;
                if (count == (count = count | count2)) {
                    continue loop;
                }
            }
            return i + 1;
        }
        return -1;
    }

    private static int puzzle2(char[] chars) {
        loop: for (int i = 14 - 1; i < chars.length; i++) {
            int count = 0;
            for (int x = i; x > i - 14; x--) {
                final int ch = chars[x] - 'a';
                final int count2 = 1 << ch;
                if (count == (count = count | count2)) {
                    continue loop;
                }
            }
            return i + 1;
        }
        return -1;
    }
}
