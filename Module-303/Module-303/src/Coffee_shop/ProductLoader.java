package Coffee_shop;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductLoader {
    public List<Product> LoadProducts(){
       List<Product> result = new ArrayList<Product>();
        try {
       //open file to read from
       File file = new File("src/products.txt");

       //read the file to get products

            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            while((line = br.readLine())!= null){
                String[] tokens = line.split(",");
                Product p = new Product();
                p.setName(tokens[0]);
                p.setPrice(Double.parseDouble(tokens[1]));
                result.add(p);
                System.out.println(p);
            }
        } catch (Exception e) {
          e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        new ProductLoader().LoadProducts();
    }
}
