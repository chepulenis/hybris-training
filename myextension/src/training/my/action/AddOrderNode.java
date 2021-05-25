package training.my.action;

import de.hybris.platform.processengine.action.AbstractSimpleDecisionAction;
import de.hybris.platform.processengine.model.BusinessProcessModel;

import java.time.LocalDateTime;
import java.util.logging.Logger;

public class AddOrderNode extends AbstractSimpleDecisionAction {

    private static final Logger LOGGER = Logger.getLogger(AddOrderNode.class.getName());

    @Override
    public Transition executeAction(BusinessProcessModel businessProcessModel) {
        LOGGER.info("Order has been added to the cart at " + LocalDateTime.now());
        return Transition.OK;
    }
}
