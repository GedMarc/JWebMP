package za.co.mmagon.jwebswing.events.selecting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.DivSimple;

public class SelectingAdapterTest
		extends BaseTestClass
{
	@Test
	public void test()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		SelectingAdapter aa = new SelectingAdapter(test)
		{
			@Override
			public void onSelecting(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		Assertions.assertEquals(
				"<div id=\"test\" ng-selecting=\"jwCntrl.perform($event,[],'test','za.co.mmagon.jwebswing.events.selecting" + "" + "" + ""
						+ ".SelectingAdapterTest$1');\"></div>",
				test.toString(0));
	}

}
