package code;

public class Data {
    private String word;
    public Alist<FileandCount> fc;

    public Data(String word) {
        this.word = word;
        
        fc = new Alist<FileandCount>();
    }

    public void wordFound(String givenFile) {

        int index = indexInList(givenFile);

        if (index != -1) {
            int count = fc.getEntry(index).count;
            FileandCount entry = new FileandCount(givenFile, count + 1);
            fc.replace(index, entry);
        } else {
            FileandCount entry = new FileandCount(givenFile);
            fc.add(entry);
        }
    }

    public int indexInList(String anEntry) {
        boolean found = false;
        int index = 1;
        if (fc.getLength() == 0)
            return -1;
        while (!found && (index <= fc.getLength())) {
            if (anEntry.equals(fc.getEntry(index).file)) {
                found = true;
                break;
            }
            index++;
        } // end while
        if(!found)
            return -1;
        return index;
    }

    public String getWord() {
        return this.word;
    }

    public Alist<FileandCount> getFC() {
        return this.fc;
    }
}
