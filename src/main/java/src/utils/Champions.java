package src.Utils;

import lombok.Data;

import java.util.List;

@Data
public class Champions {
    private String version;
    private int key;
    private String id;
    private String name;
    private String title;
    private String blurb;
    private String image;
    private List<String> tags;

}
