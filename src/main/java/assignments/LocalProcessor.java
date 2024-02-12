package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String name;
    private Long period = 10_000_000_000_000L;
    private String version;
    private Integer price;
    private Scanner informationScanner;
    private List<String> strings;
    private static final Logger LOGGER = Logger.getLogger(LocalProcessor.class.getName());
    private StringBuilder sb;

    public LocalProcessor(String name, Long period, String version, Integer price,
                          Scanner informationScanner, List<String> strings) {
        this.name = name;
        this.period = period;
        this.version = version;
        this.price = price;
        this.informationScanner = informationScanner;
        this.strings = strings;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        strings = new ArrayList<>(stringList);
        try {
            for (int i = 0; i < period; i++) {
                LOGGER.info(String.valueOf(strings.get(i).hashCode()));
            }
        } catch (Exception e) {
            throw new IllegalStateException(e.getCause());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(List<String> stringList) {

        sb = new StringBuilder();
        sb.append(name);

        for (String x: strings) {
            sb.append(x).append(' ');
        }

        name = sb.toString();

        return name;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        informationScanner = new Scanner(file);
        sb = new StringBuilder();
        sb.append(version);

            while (informationScanner.hasNext()) {
                sb.append(informationScanner.nextLine());
            }
        version = sb.toString();
    }
}
