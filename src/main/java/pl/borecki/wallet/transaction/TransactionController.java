package pl.borecki.wallet.transaction;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
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
}
