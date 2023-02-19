package control;

import model.Customers;

import java.io.*;
import java.util.*;

public class CustomersManager extends LinkedHashMap<String, Customers> {
    public static final boolean READ_IN_FILE_PRODUCT = false;

    public ArrayList<Customers> readFile() throws Exception {
        File file = new File(Customers.FILE_PATH);
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
        ArrayList<Customers> result = new ArrayList<>();
        Customers customers;
        for (String s : list) {
            String[] data = s.split(",");
            customers = new Customers(data[0], data[1], data[2], data[3]);
            result.add(customers);
        }
        return result;
    }
    public CustomersManager() throws Exception {
        ArrayList<Customers> list = readFile();
        for(Customers customers: list){
            put(customers.getId(),customers);
        }
    }
    public Customers search(String id) throws Exception {
        if(keySet().contains(id))
        {
            return get(id);
        }
        else throw new Exception("id not found");
    }
    public void add(Customers customers) throws Exception {
        if(!keySet().contains(customers.getId())) {
            put(customers.getId(),customers);
        }
        else throw new Exception("id exit");
    }
    public void update(String[] data) throws Exception {
        search(data[0]);
        put(data[0],new Customers(data[0],
                data[1].equals("") ? get(data[0]).getName():data[1] ,
                data[2].equals("") ? get(data[0]).getAddress(): data[2],
                data[3].equals("") ? get(data[0]).getPhone():data[3]));
    }
    public void writeFile() throws IOException {
        File file = new File(Customers.FILE_PATH);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStream = new OutputStreamWriter(fileOutputStream);
        outputStream.write(toString(true));
        outputStream.flush();
        outputStream.close();
        fileOutputStream.close();
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
             CustomersManager manager=null;
            try {
              manager = new CustomersManager();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            StringBuilder result = new StringBuilder();
            assert manager != null;
            for (String key : manager.keySet()) {
                result.append(manager.get(key).toString()).append("\n");
            }
            return result.toString();
        }
    }
    public String idAuto(){
        ArrayList<String> list = new ArrayList<>(keySet());
        list.sort(Comparator.naturalOrder());
        int nextId;
        int presentId;
        if (!keySet().isEmpty()) {
            presentId = Integer.parseInt(list.get(list.size() - 1).substring(1));
            nextId = ++presentId;
        } else {
            nextId = 1;
        }
        StringBuilder nextIdString = new StringBuilder(Integer.toString(nextId));
        System.out.println();
        for (int i = 0; i < (3 - Integer.toString(nextId % 1000).length()); i++) {
            nextIdString.insert(0, "0");
        }
        return "C" + nextIdString;
    }
}
