package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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

    public LocalProcessor(String name, Long period, String version, Integer price,
                          Scanner informationScanner, LinkedList<String> strings) {
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
        strings = new LinkedList<>(stringList);
        for (int i = 0; i < period; i++) {
            System.out.println(strings.get(i).hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(List<String> stringList) {

        StringBuilder sb = new StringBuilder();
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
        StringBuilder sb = new StringBuilder();
        sb.append(version);

            while (informationScanner.hasNext()) {
                sb.append(informationScanner.nextLine());
            }
        version = sb.toString();
    }
}
