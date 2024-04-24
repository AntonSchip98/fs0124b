package it.schipani.classes;

public class Customer {
    private static long nextId = 1;
    private Long id;
    private String name;
    private Integer tier;

    public Customer(Integer tier, String name) {
        this.tier = tier;
        this.name = name;
        this.id = nextId++;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getTier() {
        return tier;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTier(Integer tier) {
        this.tier = tier;
    }

}
