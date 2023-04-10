public class Dispatcher {
    public static void main(String[] args) {

        //Also you can specify the path to your folder with files here
        String filesPath = "files-average-letterinword-multithread-parallelstream-countsystem/files ";
        FileManager manager = new FileManager(filesPath);
        System.out.println("average length: " + manager.countAverageWordLength());

    }
}