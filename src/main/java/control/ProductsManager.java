package control;

import model.Products;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ProductsManager extends LinkedHashMap<String,Products> {
    public static final boolean READ_IN_FILE_PRODUCT = false;
    public static final boolean READ_IN_STACK_PRODUCT = true;
    public ArrayList<Products> readFile() throws Exception {
        File file = new File(Products.FILE_PATH);
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
        ArrayList<String> list = new ArrayList<>();
        while (dataInputStream.available() > 0){
            list.add(dataInputStream.readLine());
        }
        fileInputStream.close();
        bufferedInputStream.close();
        dataInputStream.close();
        ArrayList<Products> result = new ArrayList<>();
        Products product;
        for (String s : list) {
            String[] data = s.split(",");
            product = new Products(data[0], data[1], data[2], data[3], Float.parseFloat(data[4]));
            result.add(product);
        }
        return result;
    }
    public ProductsManager() throws Exception {
        ArrayList<Products> list = readFile();
        for(Products product: list){
            put(product.getId(),product);
        }
    }
    public String toString(Boolean check) {
        if(check) {
            StringBuilder result = new StringBuilder();
            for (String key : keySet()) {
                result.append(get(key).toString()).append("\n");
            }
            return result.toString();
        }
        else {
            ProductsManager manager=null;
            try {
                manager = new ProductsManager();
            }
            catch (Exception e){

                System.out.println("1"+e.getMessage());
            }
            StringBuilder result = new StringBuilder();
            assert manager != null;
            for (String key : manager.keySet()) {
                result.append(manager.get(key).toString()).append("\n");
            }
            return result.toString();
        }
    }
}
