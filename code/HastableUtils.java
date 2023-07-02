package code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class HastableUtils {
    private String subject;
    private HashedDictionary<String, Data> hashtable = Engine.hashtable;
    private final int FILE_COUNT = 100;

    public HastableUtils(String subject) {
        this.subject = subject;
    }

    public void store() {
        for (int i = 1; i < FILE_COUNT + 1; i++) {
            Alist<String> words = new Alist<String>();
            String allText = "";
            String fileName = String.format("%03d", i) + ".txt";
            String filePath = subject + "/" + fileName;

            try {
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                String line = reader.readLine();

                while (line != null) { // Add the current line into list until there is no new line
                    allText += " " + line;
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) { // Exception handling
            }

            String[] splitted = allText.split(Delimiter.DELIMITERS);
            words = scrapStopWords(splitted);
            
            addToHashtable(words, fileName);
        }
    }

    

    private void addToHashtable(Alist<String> words, String fileName) {
        for (int i = 1; i < words.getLength() + 1; i++) {

            String word = words.getEntry(i);

            if (!hashtable.contains(word)) {
                Data data = new Data(word);
                data.wordFound(fileName);
                hashtable.add(word, data);
            } else {
                Data data = hashtable.getValue(word);
                data.wordFound(fileName);
                hashtable.add(word, data);
            }
        }
    }

    private Alist<String> scrapStopWords(String[] text) {
        Alist<String> words = new Alist<String>();

        try {
            String stopWords = "";
            BufferedReader reader = new BufferedReader(new FileReader("stop_words_en.txt"));
            String line = reader.readLine();

            while (line != null) { // Add the current line into list until there is no new line
                stopWords += " " + line;
                line = reader.readLine();
            }
            reader.close();

            for (int i = 0; i < text.length; i++) {
                String word = text[i].toLowerCase();
                if (!stopWords.contains(word))
                    words.add(word);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

    public void display() {
        Iterator<String> keyIterator = hashtable.getKeyIterator();
        Iterator<Data> valueIterator = hashtable.getValueIterator();
        while (keyIterator.hasNext()) {
            Data value = valueIterator.next();

            Alist<FileandCount> fc = value.getFC();
            String key = keyIterator.next();

            for (int i = 1; i < fc.getLength() + 1; i++) {
                String file = fc.getEntry(i).file;
                String word = value.getWord();
                int count = fc.getEntry(i).count;
                System.out.println("Key: " + word + " File:" + file + ": " + count);
            }
        }
    }

    public int querySearch() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter 3 words to search: ");
        String query = scanner.nextLine();
        String[] words = query.split(" ");
        scanner.close();

        words[0] = "claxton";
        words[1] = "year";
        words[2] = "medal";

        FileandCount[] files = new FileandCount[FILE_COUNT + 1];

        for (int i = 1; i <= FILE_COUNT; i++) {
            files[i] = new FileandCount(String.format("%03d", i) + ".txt");
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (hashtable.contains(word)) {
                Data data = hashtable.getValue(word);
                Alist<FileandCount> fc = data.getFC();

                for (int j = 1; j <= fc.getLength(); j++) {
                    int file = Integer.parseInt(fc.getEntry(j).file, 0, 3, 10);
                    files[file].count += fc.getEntry(j).count;
                }
            } else {
                System.out.println("Word not found in the database");
                return 0;
            }
        }

        int foundFile = 0;
        int foundCount = 0;
        for (int i = 1; i <= FILE_COUNT; i++) {
            if (files[i].count > foundCount) {
                foundCount = files[i].count;
                foundFile = i;
            }
        }

        System.out.println("Most occurences found in the file: " + String.format("%03d", foundFile) + ".txt" + " with "
                + foundCount + " findings.");
        return 0;
    }

    public long searchSequence(String fileName){
        Alist<String> words = new Alist<String>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();

            while (line != null) { // Add the current line into list until there is no new line
                words.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) { // Exception handling
        }

        long avgTime = 0;
        long minTime = 5000000;
        long maxTime = 0;
        for (int i = 1; i <= words.getLength(); i++) {
            long time = System.nanoTime();
            hashtable.getValue(words.getEntry(i));
            time = System.nanoTime() - time;
            avgTime += time;

            if(time > maxTime)
                maxTime = time;
            if(time < minTime)
                minTime = time;
        }

        avgTime /= words.getLength();
        System.out.println("Collision Count:" + hashtable.getCollisionCount());
        System.out.println("maxTime: " + maxTime + "ns");
        System.out.println("minTime: " + minTime + "ns");
        System.out.println("avgTime:" + avgTime + "ns");

        return avgTime;
    }
}
