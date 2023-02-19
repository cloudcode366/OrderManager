package control;

import model.Orders;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;

public class OrdersManager extends LinkedHashMap<String, Orders> {
    public static final int FILE_STRING =0;
    public static final int FILE_STRING_FALSE = 1;
    public static final int STACK_STRING=2;
    CustomersManager cManager;

    ProductsManager pManager;
    public ArrayList<Orders> readFile() throws IOException {
        File file = new File(Orders.FILE_PATH);
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream buf = new BufferedInputStream(fileInputStream);
        DataInputStream dataInputStream = new DataInputStream(buf);
        ArrayList<Orders> result = new ArrayList<>();
        Orders orders = null;
        String data;
        while (dataInputStream.available() > 0){
            data = dataInputStream.readLine();
            String[] tmp = data.split(",");
            try {
                orders = new Orders(tmp[0], cManager.get(tmp[1]), pManager.get(tmp[2]), Integer.parseInt(tmp[3]), tmp[4], Boolean.parseBoolean(tmp[5]));
            }
            catch (Exception e){
                e.printStackTrace();
            }
            result.add(orders);
        }
        return result;
    }
    public OrdersManager(CustomersManager cManager, ProductsManager pManager){
        this.cManager = cManager;
        this.pManager = pManager;
        ArrayList<Orders> tmp = null;
        try {
            tmp = readFile();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        assert tmp != null;
        for (Orders orders: tmp) {
            put(orders.getId(),orders);
        }
    }
    public String toString(int option) {
        StringBuilder result = new StringBuilder();
        ArrayList<Orders> list = null;
        switch (option) {
            case 2->{
            for (String key : keySet()) {
                result.append(get(key).toString()).append("\n");
            }
        }
        case 0->{
            try {
                list = readFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
            assert list != null;
            list.sort(Comparator.comparing(o -> o.getCustomer().getName()));
            for (Orders orders : list) {
                result.append(orders.toString()).append("\n");
            }
        }
            case 1->{
                try {
                    list = readFile();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                assert list != null;
                list.sort(Comparator.comparing(o -> o.getCustomer().getName()));
                for(Orders orders: list){
                    if(!orders.isStatus()){
                        result.append(orders).append("\n");
                    }
                }
            }
    }
        return result.toString();
    }
    public void add(String id,String cId,String pId,int quantity,String date,boolean status) throws Exception {
        if(!keySet().contains(id)){
            if(cManager.containsKey(cId)&&pManager.containsKey(pId)){
                try {
                    put(id, new Orders(id, cManager.get(cId), pManager.get(pId), quantity, date, status));
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            else {
                if (pManager.containsKey(pId)) {
                    throw new Exception("customer not found");
                }
                else {
                    throw new Exception("product not found");
                }
            }
        }
        else {
            throw new Exception("id exit");
        }
    }
    public void add(String[] data) throws Exception {
        String id = data[0];
        String cId = data[1];
        String pId = data[2];
        int quantity;
        if(data[3].matches("[0-9]+")){
            quantity = Integer.parseInt(data[3]);
        }
        else {
            throw new Exception("quantity must be number");
        }
        String date = data[4];
        boolean status = false;
        if(data[5].toUpperCase().matches("[TF]")){
            status= data[5].equalsIgnoreCase("T");
        }
        if(!keySet().contains(id)){
            if(cManager.containsKey(cId)&&pManager.containsKey(pId)){
                try {
                    put(id, new Orders(id, cManager.get(cId), pManager.get(pId), quantity, date, status));
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            else {
                if (pManager.containsKey(pId)) {
                    throw new Exception("customer not found");
                }
                else {
                    throw new Exception("product not found");
                }
            }
        }
        else {
            throw new Exception("id exit");
        }
    }

    public void update(String[] data) throws Exception {
        String id = data[0];
        String cId = data[1];
        String pId = data[2];
        int quantity;
        if(data[3].matches("[0-9]+")){
            quantity = Integer.parseInt(data[3]);
        }
        else {
            throw new Exception("quantity must be integer");
        }
        String date = data[4];
        boolean status;
        if(data[5].toUpperCase().matches("[TF]")){
            status = data[5].equalsIgnoreCase("t");
        }
        else {
            throw new Exception("Error option");
        }
        Orders tmpOrder = get(id);
        if(containsKey(id)){
            try {
                put(id, new Orders(id,
                        cId.equals("") ? tmpOrder.getCustomer() : cManager.get(cId),
                        pId.equals("") ? tmpOrder.getProduct() : pManager.get(pId),
                        quantity<=0 ? tmpOrder.getQuantity() : quantity,
                        date.equals("") ? tmpOrder.getDate() :  date,
                        status));
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void delete(String id) throws Exception {
        if(containsKey(id)) remove(id);
        else throw new Exception("id not found");
    }
    public void writeFile() throws IOException {
        File file = new File(Orders.FILE_PATH);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStream = new OutputStreamWriter(fileOutputStream);
        outputStream.write(toString(STACK_STRING));
        outputStream.flush();
        outputStream.close();
        fileOutputStream.close();
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
        return "D" + nextIdString;
    }
}
