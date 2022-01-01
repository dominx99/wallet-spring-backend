package pl.borecki.wallet.category;

import pl.borecki.wallet.transaction.Transaction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Category() { /// nie wiem po co ten pusty konstruktor ale bez tego wywala błąd

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(
            mappedBy = "category",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List <Transaction> transactions = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}