package pl.borecki.wallet.transaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
    private TransactionRepository transactionRepository;

    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/api/transactions")
    private Iterable<Transaction> index() {
        Iterable<Transaction> transactions = transactionRepository.findAll();

        return transactions;
    }

    @PostMapping("/api/transactions")
    public Transaction store(@RequestBody Transaction transaction){
        return transactionRepository.save(transaction);
    }
}




