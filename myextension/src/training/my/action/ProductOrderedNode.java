package training.my.action;

import de.hybris.platform.processengine.action.AbstractSimpleDecisionAction;
import de.hybris.platform.processengine.model.BusinessProcessModel;

import java.time.LocalDateTime;
import java.util.logging.Logger;

public class ProductOrderedNode extends AbstractSimpleDecisionAction {
    private static final Logger LOGGER = Logger.getLogger(ProductOrderedNode.class.getName());

    @Override
    public Transition executeAction(BusinessProcessModel businessProcessModel) {
        LOGGER.info("Product has been ordered at " + LocalDateTime.now());
        return Transition.OK;
    }

}
