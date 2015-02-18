package org.onedevelopment.webapp.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.jsp.PageContext;

import org.displaytag.decorator.DisplaytagColumnDecorator;
import org.displaytag.exception.DecoratorException;
import org.displaytag.properties.MediaTypeEnum;

public class DisplaytagColumnDecoratorDate implements DisplaytagColumnDecorator {

	@Override
	public Object decorate(Object arg0, PageContext arg1, MediaTypeEnum arg2)
			throws DecoratorException {

		try {
			Object colVal = arg0;
			if (arg0 != null) {
				SimpleDateFormat sdf = new SimpleDateFormat(
						"dd/MM/yyyy");
				Calendar calendar = (Calendar) arg0;
				colVal = sdf.format(calendar.getTime());
			}
			return colVal;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arg0;
	}

}
