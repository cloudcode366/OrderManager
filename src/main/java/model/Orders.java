package model;

public class Orders {
    public static final String FILE_PATH = "D:\\code\\Intellij\\OrderManager\\src\\main\\java\\model\\orders.txt";
    private String id;
    private Customers customer;
    private Products product;
    private int quantity;
    private String date;
    private boolean status;

    public String getId() {
        return id;
    }

    public void setId(String id) throws Exception {
        if(id.matches("D\\d{3}")){
            this.id = id;
        }
        else {
            throw new Exception("id format");
        }
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) throws Exception {
       final String FORMAT_DATE = "(0?[1-9]|1[0-2])/(0?[0-9]|[1-2]\\d|3[0-1])/2\\d{3}";
       if(date.matches(FORMAT_DATE)){
            this.date = date;
       }
       else {
           throw new Exception("date format");
       }
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Orders(String id, Customers customer, Products product, int quantity, String date, boolean status) throws Exception {
       setId(id);
       setCustomer(customer);
       setProduct(product);
       setQuantity(quantity);
       setDate(date);
       setStatus(status);
    }

    @Override
    public String toString() {
        return id+","+customer.getId()+","+product.getId()+","+quantity+","+date+","+status;
    }
}
