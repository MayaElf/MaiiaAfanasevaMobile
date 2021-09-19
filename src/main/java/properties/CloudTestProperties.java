package properties;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class CloudTestProperties {
    public static String API_KEY;
    public static final String PROJECT_NAME;
    public static final String APPIUM_HUB;
    static {
        Locale locale = new Locale("en", "US");
        ResourceBundle rb = ResourceBundle.getBundle("cloudTest", locale);
        PROJECT_NAME = rb.getString("projectName");
        APPIUM_HUB = rb.getString("appiumHub");

        try {
            API_KEY = URLEncoder.encode(API_KEY, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}


