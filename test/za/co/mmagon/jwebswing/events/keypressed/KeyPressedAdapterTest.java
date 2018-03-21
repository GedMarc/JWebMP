package za.co.mmagon.jwebswing.events.keypressed;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.DivSimple;

public class KeyPressedAdapterTest
		extends BaseTestClass
{
	@Test
	public void test()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		KeyPressedAdapter aa = new KeyPressedAdapter(test)
		{
			@Override
			public void onKeyPressed(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		Assertions.assertEquals(
				"<div id=\"test\" ng-keypress=\"jwCntrl.perform($event,['jwCntrl.jw.localstorage'],'test','za.co.mmagon.jwebswing.events.keypressed" + "" + "" + "" + ".KeyPressedAdapterTest$1');\"></div>",
				test.toString(0));
	}

	@Test
	public void testDirective()
	{
		Div test = new DivSimple<>();
		test.setID("test");

		KeyPressedAdapter aa = new KeyPressedAdapter(test)
		{
			@Override
			public void onKeyPressed(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));

	}
}
