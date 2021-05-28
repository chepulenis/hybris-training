package training.my.transaction;

import de.hybris.platform.core.Registry;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.util.logging.Logger;

public class SpringTransaction {

    private static final Logger LOGGER = Logger.getLogger(SpringTransaction.class.getName());

    @Resource(name = "txManager")
    PlatformTransactionManager manager;

    public void doSpringTransaction() {
        TransactionTemplate template = new TransactionTemplate(manager);
        try {
            template.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(final TransactionStatus status) {
                    LOGGER.info("Spring transaction has been done.");
                }
            });
        } catch (Exception e){
            LOGGER.info("Transaction has been rolled back with error message: " + e.getMessage());
        }
    }

}
