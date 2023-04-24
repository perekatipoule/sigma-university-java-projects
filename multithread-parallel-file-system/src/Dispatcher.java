public class Dispatcher {
    public static void main(String[] args) {

        String filesPath = "multithread-parallel-file-system/files";
        FileManager manager = new FileManager(filesPath);
        System.out.println("average length: " + manager.countAverageWordLength());
    }
}