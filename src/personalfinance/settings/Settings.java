package personalfinance.settings;

import org.ini4j.Ini;
import org.ini4j.IniPreferences;
import org.ini4j.Wini;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.prefs.Preferences;

public final class Settings {
    public static final String DIR_SEPARATOR = "/";
    public static final File[] FONTS_FILES = {
            new File("fonts/RobotoLight.ttf")
    };

    public static final File SAVES_DIR = new File("saves/");
    public static final String SAVE_FILE_EXT = "dmm";
    public static final String FORMAT_AMOUNT = "%.2f";
    public static final String FORMAT_RATE = "%.4f";
    public static final String FORMAT_DATE_DATE = "dd.MM.yyyy";
    public static final String FORMAT_DATE_MONTH = "MMMM yyyy";
    public static final String FORMAT_DATE_YEAR = "yyyy";
    public static final int COUNT_OVERVIEW_ROWS = 10;
    public static final String[] CURRENCIES = new String[] {
            "RUB", "USD", "EUR"
    };

    private static final File INI_FILE = new File("saves/settings.ini");
    private static File LAST_FILE = new File("saves/default.dmm");

    public static void init() {
        try {
            Ini ini = new Ini(INI_FILE);
            Preferences preferences = new IniPreferences(ini);
            String file = preferences.node("Settings").get("LAST_FILE", null);
            if (file != null)
                LAST_FILE = new File(file);
            setLocale();
        } catch (IOException e) {
            save();
        }
    }

    private static void setLocale() {
        Locale.setDefault(new Locale("ru"));
    }

    public static void save() {
        try {
            Wini ini = new Wini(INI_FILE);
            ini.put(
                    "Settings",
                    "LAST_FILE",
                    LAST_FILE.getAbsolutePath().replace("\\", "\\\\")
            );
            ini.store();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static File getSaveFile() {
        return LAST_FILE;
    }

    public static void setSaveFile(File file) {
        LAST_FILE = file;
        save();
    }
}
