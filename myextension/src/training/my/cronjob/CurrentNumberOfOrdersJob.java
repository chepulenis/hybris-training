package training.my.cronjob;

import de.hybris.cronjobtutorial.model.CurrentNumberOfOrdersCronJobModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import training.my.service.impl.MyOrderServiceImpl;

import javax.annotation.Resource;
import java.util.logging.Logger;

public class CurrentNumberOfOrdersJob extends AbstractJobPerformable<CurrentNumberOfOrdersCronJobModel> {

    private static final Logger LOGGER = Logger.getLogger(CurrentNumberOfOrdersJob.class.getName());

    @Resource
    MyOrderServiceImpl myOrderService;

    @Override
    public PerformResult perform(CurrentNumberOfOrdersCronJobModel currentNumberOfOrdersCronJobModel) {
        LOGGER.info("Current number of orders: " + myOrderService.getTotalNumberOfOrders() + ".");
        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }
}