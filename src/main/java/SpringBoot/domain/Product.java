package SpringBoot.domain;

//CLASS POJO
public class Product {

    //attributes
    private Integer id;
    private String name;
    private Double prize;
    private Integer stock;

    //constructor
    public Product(Integer id, String name, Double prize, Integer stock) {
        this.id = id;
        this.name = name;
        this.prize = prize;
        this.stock = stock;
    }

    //getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrize() {
        return prize;
    }

    public void setPrize(Double prize) {
        this.prize = prize;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
