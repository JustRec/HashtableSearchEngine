package code;

public class Engine {

    public static HashedDictionary<String, Data> hashtable = new HashedDictionary<String, Data>();
    public static void main(String[] args) {
        
        fillTable();

        
        



    }

    public static void fillTable(){
        HastableUtils textOp = new HastableUtils("sport");

        //SSFLP50
        System.out.println("SSF-LP-50");
        HashedDictionary.maxLoadFactor = 0.5;
        HashedDictionary.hashing = "SSF";
        HashedDictionary.collisionHandling = "LP";
        long indexTime = System.currentTimeMillis();
        textOp.store();
        indexTime = System.currentTimeMillis() - indexTime;
        System.out.println("indexTime:" + indexTime + "ms");
        textOp.searchSequence("search.txt");
        System.out.println();

        //SSFDH50
        hashtable = new HashedDictionary<String, Data>();
        System.out.println("SSF-DH-50");
        HashedDictionary.maxLoadFactor = 0.5;
        HashedDictionary.hashing = "SSF";
        HashedDictionary.collisionHandling = "DH";
        indexTime = System.currentTimeMillis();
        textOp.store();
        indexTime = System.currentTimeMillis() - indexTime;
        System.out.println("indexTime:" + indexTime + "ms");
        textOp.searchSequence("search.txt");
        System.out.println();

        //PAFLP50
        hashtable = new HashedDictionary<String, Data>();
        System.out.println("PAF-LP-50");
        HashedDictionary.maxLoadFactor = 0.5;
        HashedDictionary.hashing = "PAF";
        HashedDictionary.collisionHandling = "LP";
        indexTime = System.currentTimeMillis();
        textOp.store();
        indexTime = System.currentTimeMillis() - indexTime;
        System.out.println("indexTime:" + indexTime + "ms");
        textOp.searchSequence("search.txt");
        System.out.println();

        //PAFDH50
        hashtable = new HashedDictionary<String, Data>();
        System.out.println("PAF-DH-50");
        HashedDictionary.maxLoadFactor = 0.5;
        HashedDictionary.hashing = "PAF";
        HashedDictionary.collisionHandling = "DH";
        indexTime = System.currentTimeMillis();
        textOp.store();
        indexTime = System.currentTimeMillis() - indexTime;
        System.out.println("indexTime:" + indexTime + "ms");
        textOp.searchSequence("search.txt");
        System.out.println();

        //SSFLP80
        hashtable = new HashedDictionary<String, Data>();
        System.out.println("SSF-LP-80");
        HashedDictionary.maxLoadFactor = 0.8;
        HashedDictionary.hashing = "SSF";
        HashedDictionary.collisionHandling = "LP";
        indexTime = System.currentTimeMillis();
        textOp.store();
        indexTime = System.currentTimeMillis() - indexTime;
        System.out.println("indexTime:" + indexTime + "ms");
        textOp.searchSequence("search.txt");
        System.out.println();

        //SSFDH80
        hashtable = new HashedDictionary<String, Data>();
        System.out.println("SSF-DH-80");
        HashedDictionary.maxLoadFactor = 0.8;
        HashedDictionary.hashing = "SSF";
        HashedDictionary.collisionHandling = "DH";
        indexTime = System.currentTimeMillis();
        textOp.store();
        indexTime = System.currentTimeMillis() - indexTime;
        System.out.println("indexTime:" + indexTime + "ms");
        textOp.searchSequence("search.txt");
        System.out.println();

        //PAFLP80
        hashtable = new HashedDictionary<String, Data>();
        System.out.println("PAF-LP-80");
        HashedDictionary.maxLoadFactor = 0.8;
        HashedDictionary.hashing = "PAF";
        HashedDictionary.collisionHandling = "LP";
        indexTime = System.currentTimeMillis();
        textOp.store();
        indexTime = System.currentTimeMillis() - indexTime;
        System.out.println("indexTime:" + indexTime + "ms");
        textOp.searchSequence("search.txt");
        System.out.println();

        //PAFDH80
        hashtable = new HashedDictionary<String, Data>();
        System.out.println("PAF-DH-80");
        HashedDictionary.maxLoadFactor = 0.8;
        HashedDictionary.hashing = "PAF";
        HashedDictionary.collisionHandling = "DH";
        indexTime = System.currentTimeMillis();
        textOp.store();
        indexTime = System.currentTimeMillis() - indexTime;
        System.out.println("indexTime:" + indexTime + "ms");
        textOp.searchSequence("search.txt");
        
        
    }

    
}