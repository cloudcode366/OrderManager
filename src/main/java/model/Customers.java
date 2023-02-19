package model;

public class Customers {
    public static final String FILE_PATH = "D:\\code\\Intellij\\OrderManager\\src\\main\\java\\model\\customers.txt";
    private String id;
    private String name;
    private String address;
    private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) throws Exception {
        if(id.matches("C\\d{3}")){
            this.id = id;
        }
        else {
            throw new Exception("id format");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        name = name.toUpperCase();
        if(name.matches("([A-Z]|\\s){5,}")){
            this.name = name;
        }
        else {
            throw new Exception("name format");
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws Exception {
        if(phone.matches("\\d{10,12}")){
            this.phone = phone;
        }
        else {
            throw new Exception("phone format");
        }
    }

    public Customers(String id, String name, String address, String phone) throws Exception {
        setId(id);
        setName(name);
        setAddress(address);
        setPhone(phone);
    }
    public Customers(String[] data) throws Exception {
        setId(data[0]);
        setName(data[1]);
        setAddress(data[2]);
        setPhone(data[3]);
    }

    @Override
    public String toString() {
        return id+","+name+","+address + ","+phone;
    }
}
