package pl.borecki.wallet.transaction;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private TransactionRepository transactionRepository;

    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping
    private Iterable<Transaction> index() {
        Iterable<Transaction> transactions = transactionRepository.findAll();

        return transactions;
    }

    @PostMapping
    public Transaction store(@RequestBody Transaction transaction){
        return transactionRepository.save(transaction);
    }

    @GetMapping("{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable long id){
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nie ma tranzakcji z numerem ID:" +id));
        return ResponseEntity.ok(transaction);
    }
}




