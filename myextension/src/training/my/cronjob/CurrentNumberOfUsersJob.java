package training.my.cronjob;

import de.hybris.cronjobtutorial.model.CurrentNumberOfUsersCronJobModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import training.my.service.MyUserService;

import javax.annotation.Resource;
import java.util.logging.Logger;

public class CurrentNumberOfUsersJob extends AbstractJobPerformable<CurrentNumberOfUsersCronJobModel> {

    private static final Logger LOGGER = Logger.getLogger(CurrentNumberOfUsersCronJobModel.class.getName());

    @Resource
    MyUserService myUserService;

    @Override
    public PerformResult perform(CurrentNumberOfUsersCronJobModel currentNumberOfUsersCronJobModel) {
        LOGGER.info("Current number of users: " + myUserService.getTotalNumberOfUsers() + ".");
        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }
}