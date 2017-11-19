package za.co.mmagon.jwebswing.events.beforestop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.DivSimple;

class BeforeStopAdapterTest extends BaseTestClass
{
	@Test
	void test()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		BeforeStopAdapter aa = new BeforeStopAdapter(test)
		{
			@Override
			public void onBeforeStop(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		Assertions.assertEquals("<div id=\"test\" ng-before-stop=\"jwCntrl.perform($event,[],'za_co_mmagon_jwebswing_events_beforestop_BeforeStopAdapterTest$1','za.co.mmagon.jwebswing.events.beforestop.BeforeStopAdapterTest$1');\"></div>", test.toString(0));
	}

	@Test
	void testDirective()
	{
		Div test = new DivSimple<>();
		test.getPage().getAngular().getAngularDirectives().clear();
		test.setID("test");
		BeforeStopAdapter aa = new BeforeStopAdapter(test)
		{
			@Override
			public void onBeforeStop(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		System.out.println(test.getPage().getAngular().getAngularDirectives());
		Assertions.assertEquals(1, test.getPage().getAngular().getAngularDirectives().size());
	}
}
