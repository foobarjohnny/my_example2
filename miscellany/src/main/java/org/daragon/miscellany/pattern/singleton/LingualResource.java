package org.daragon.miscellany.pattern.singleton;

import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

public class LingualResource {
    private String language = "en";
    private String region = "US";
    private String localeCode = "en_US";
    private static final String FILE_NAME = "res";
    private static HashMap instances = new HashMap(19);

    private Locale locale = null;
    private ResourceBundle resourceBundle = null;
    private LingualResource lnkLingualResource;

    private LingualResource(String lang, String region) {
        this.language = lang;
        this.region = region;
        localeCode = makeLocaleCode(lang, region);
        locale = new Locale(lang, region);
        resourceBundle = ResourceBundle.getBundle(FILE_NAME, locale);
        instances.put(localeCode, resourceBundle);
    }

    private static String makeLocaleCode(String lang, String region) {
        return lang + "_" + region;
    }

    private LingualResource() {
    }

    public synchronized static LingualResource getInstance(String lang, String region) {
        Object lr = instances.get(makeLocaleCode(lang, region));
        if (lr != null) {
            return (LingualResource) lr;
        }
        return new LingualResource(lang, region);
    }

    public String getLocaleString(String code) {
        return resourceBundle.getString(code);
    }

}
