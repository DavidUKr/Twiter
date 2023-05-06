package app.Twiter.model;

import org.springframework.web.servlet.View;
import java.awt.*;
import java.util.List;
public class Content {
    private String TEXT;
    private List<Image> IMAGES;
    private List<View> VIEWS;

    public Content(String TEXT, List<Image> IMAGES, List<View> VIEWS) {
        this.TEXT = TEXT;
        this.IMAGES = IMAGES;
        this.VIEWS = VIEWS;
    }

}
