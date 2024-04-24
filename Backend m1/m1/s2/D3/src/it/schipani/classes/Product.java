package it.schipani.classes;

public class Product {
    private static long nextId = 1;
    private Long id;
    private String name;
    private Category category;
    private Double price;

    public Product(String name, Category category, Double price) {
        this.id = nextId++;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\nProduct id: " + id +
                "\n\t name='" + name + '\'' +
                "\n\t category=" + category +
                "\n\t price=" + price +
                "\n";
    }
}
