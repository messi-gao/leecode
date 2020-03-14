package half;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

public class LineCounter {
    public static void main(String[] args) throws IOException {
        LongAdder result = new LongAdder();
        System.out.println(getCounter("C:\\ideaworkspace\\leecode\\src\\stack", result));
    }

    public static long getCounter(String dir, LongAdder result) throws IOException {
        Files.list(Paths.get(dir)).forEach(path -> {
            if (Files.isDirectory(path)) {
                try {
                    getCounter(path.toString(), result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    List<String> lines = Files.readAllLines(path);
                    boolean isComment = false;
                    for (String line : lines) {
                        boolean isBlank = line.trim().isEmpty();
                        boolean isComment1 = line.startsWith("//");
                        boolean isComment2 = line.startsWith("/*") && !line.startsWith("*/");
                        boolean isComment3 = line.endsWith("*/");

                        if (!isBlank && !isComment1) {
                            if (isComment2) {
                                isComment = true;
                            }
                            if (isComment3) {
                                isComment = false;
                            } else if (!isComment) {
                                result.increment();
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        return result.longValue();
    }
}
