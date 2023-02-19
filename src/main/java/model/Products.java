package model;

public class Products {
    public static final String FILE_PATH = "D:\\code\\Intellij\\OrderManager\\src\\main\\java\\model\\products.txt";
    private String id;
    private String name;
    private String unit;
    private String origin;
    private float price;

    public String getId() {
        return id;
    }

    public void setId(String id) throws Exception {
        if(id.matches("P\\d{3}")){
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
        if(name.matches("(\\s|\\S){2,}")){
            this.name = name;
        }
        else {
            System.out.println(name);
            throw new Exception("name format");
        }
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setOrigin(String origin) throws Exception {
        if(!origin.equals("")){
            this.origin = origin;
        }
        else throw new Exception("origin null");
    }

    public void setPrice(float price) throws Exception {
        if(price <= 0) throw new Exception("price < 0");
        else this.price = price;
    }

    public Products(String id, String name, String unit, String origin, float price) throws Exception {
       setId(id);
       setName(name);
       setUnit(unit);
       setOrigin(origin);
       setPrice(price);
    }

    @Override
    public String toString() {
        return id+","
                +name+","
                +unit+","
                +origin+","
                +price;
    }
}
