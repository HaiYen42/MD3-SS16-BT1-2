import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Nation> listNation = new ArrayList<>();
        //Tạo đối tượng fr thuộc lớp FileReader có constructor là fileName:
        FileReader fr = new FileReader("src/countries.csv");
        BufferedReader br= new BufferedReader(fr);
        String line;
        //Gán line bằng br (đọc dòng) nếu line khác null thì thực hieenj dòng 14,15,16
        while ((line= br.readLine()) !=null) {
            line = line.replaceAll("\"", "");
            String[] arr = line.split(","); //1,"AU","Australia" --> [1,"AU", "Australia"]
            // new Nation--> Tạo đối tượng (arr[]) thuộc class Nation
            listNation.add(new Nation(Integer.parseInt(arr[0]), arr[1], arr[2]));
        }
       //In ra từng phần tử của listNation có kiểu dữ liệu là Nation
        for (Nation na: listNation) {
            System.out.println(na);
        }

        File file = new File("obj.txt");
        if (file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(listNation); //Viết ra file

        FileInputStream fis= new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Nation> listObject = (List<Nation>) ois.readObject(); // Đọc file
        System.out.println("Dữ liệu đọc từ file obj ");
        for (Nation na: listObject) {
            System.out.println(na);
        }
    }
}