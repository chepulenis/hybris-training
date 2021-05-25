/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved
 */
package my.training.widgets;

import com.hybris.cockpitng.util.DefaultWidgetController;
import my.training.services.MywidgetextensionService;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Label;


public class MywidgetextensionController extends DefaultWidgetController
{
	private static final long serialVersionUID = 1L;
	private Label label;

	@WireVariable
	private transient MywidgetextensionService mywidgetextensionService;

	@Override
	public void initialize(final Component comp)
	{
		super.initialize(comp);
		label.setValue(mywidgetextensionService.getHello() + " MywidgetextensionController");
	}
}
