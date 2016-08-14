package name.az170.ojrandomizer;

import java.io.File;
import java.util.List;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import com.univocity.parsers.csv.CsvWriter;
import com.univocity.parsers.csv.CsvWriterSettings;

public class CharaConfig {
    
    public static final int MAX_AMOUNT = Character.values().length;
    public static final String ENCODING = "UTF-8";
    
    private boolean[] enabledCharas = new boolean[MAX_AMOUNT];
    private double[] defaultProbabilities = new double[MAX_AMOUNT];
    private int[] chosenTimes = new int[MAX_AMOUNT];
    
    public CharaConfig() {
        init();
    }
    
    public CharaConfig(File fromFile) {
        if (fromFile.exists()) {
            loadConfig(fromFile);
        } else {
            init();
        }
    }
    
    public void init() {
        for (int i = 0; i < CharaConfig.MAX_AMOUNT; i++) {
            enabledCharas[i] = true;
            defaultProbabilities[i] = 1.0;
            chosenTimes[i] = 0;
        }
    }

    public void loadConfig(File fromFile) {
        CsvParserSettings settings = new CsvParserSettings();
        settings.getFormat().setLineSeparator("\n");
        settings.getFormat().setComment('#');
        
        CsvParser parser = new CsvParser(settings);
        List<String[]> result = parser.parseAll(fromFile, ENCODING);
        
        for (int i = 0; i < MAX_AMOUNT; i++) {
            String[] line = result.get(i);
            enabledCharas[i] = "1".equals(line[0]) ? true : false;
            defaultProbabilities[i] = Double.parseDouble(line[1]);
            chosenTimes[i] = Integer.parseInt(line[2]);
        }
    }
    
    public void saveConfig(File toFile) {
        CsvWriterSettings settings = new CsvWriterSettings();
        settings.getFormat().setLineSeparator("\n");
        settings.getFormat().setComment('#');
        CsvWriter writer = new CsvWriter(toFile, ENCODING, settings);
        
        for (int i = 0; i < MAX_AMOUNT; i++) {
            writer.commentRow(" " + Character.values()[i].getCharaName());
            writer.writeRow(new Object[] {
                    enabledCharas[i] ? "1" : "0",
                    defaultProbabilities[i],
                    chosenTimes[i]
            });
        }
        writer.close();
    }
    
    public void plusChosenTime(Character chara) {
        chosenTimes[chara.getIndex()]++;
    }
    
    public boolean isCharaEnabled(int index) {
        return enabledCharas[index];
    }
    
    public void setCharaEnabled(int index, boolean enabled) {
        enabledCharas[index] = enabled;
    }
    
    public double getProbability(int index) {
        return defaultProbabilities[index];
    }
    
    public void setProbability(int index, double probability) {
        defaultProbabilities[index] = probability;
    }
    
    public int getChosenTime(int index) {
        return chosenTimes[index];
    }
    
    public void setChosenTime(int index, int time) {
        chosenTimes[index] = time;
    }

    @Override
    protected CharaConfig clone() {
        CharaConfig config = new CharaConfig();
        for (int i = 0; i < MAX_AMOUNT; i++) {
            config.enabledCharas[i] = enabledCharas[i];
            config.defaultProbabilities[i] = defaultProbabilities[i];
            config.chosenTimes[i] = chosenTimes[i];
        }
        return config;
    }

}
