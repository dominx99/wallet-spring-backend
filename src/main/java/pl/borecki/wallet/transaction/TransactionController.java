package pl.borecki.wallet.transaction;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
    private TransactionRepository transactionRepository;

    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/api/transactions")
    public Iterable<Transaction> index() {
        Iterable<Transaction> transactions = transactionRepository.findAll();

        return transactions;
    }

    @PostMapping(value = "/api/transactions")
    public String store(
        @RequestParam String name,
        @RequestParam Integer value,
        @RequestParam String type
    ) {
        Transaction transaction = new Transaction();

        transaction.setName(name);
        transaction.setType(type);
        transaction.setValue(value);

        transactionRepository.save(transaction);

        return "OK";
    }
}
