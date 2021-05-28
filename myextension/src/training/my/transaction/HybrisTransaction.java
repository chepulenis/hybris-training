package training.my.transaction;

import de.hybris.platform.tx.Transaction;

import java.util.logging.Logger;

public class HybrisTransaction {

    private static final Logger LOGGER = Logger.getLogger(HybrisTransaction.class.getName());

    public void doHybrisTransaction(){
        Transaction transaction = Transaction.current();
        transaction.begin();
        boolean success = false;
        try
        {
            LOGGER.info("Trying to perform transaction.");
            success = true;
        }
        finally {
            if(success){
                transaction.commit();
                LOGGER.info("Transaction via Hybris API has been done.");
            }
            else{
                transaction.rollback();
                LOGGER.info("Transaction via Hybris API has been rolled back.");
            }
        }
    }
}
