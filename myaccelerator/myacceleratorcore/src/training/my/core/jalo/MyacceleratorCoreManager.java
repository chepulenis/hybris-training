/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package training.my.core.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import training.my.core.constants.MyacceleratorCoreConstants;
import training.my.core.setup.CoreSystemSetup;


/**
 * Do not use, please use {@link CoreSystemSetup} instead.
 * 
 */
public class MyacceleratorCoreManager extends GeneratedMyacceleratorCoreManager
{
	public static final MyacceleratorCoreManager getInstance()
	{
		final ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (MyacceleratorCoreManager) em.getExtension(MyacceleratorCoreConstants.EXTENSIONNAME);
	}
}
