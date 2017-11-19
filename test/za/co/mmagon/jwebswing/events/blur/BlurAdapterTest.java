package za.co.mmagon.jwebswing.events.blur;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.DivSimple;

public class BlurAdapterTest extends BaseTestClass
{
	@Test
	public void test()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		BlurAdapter aa = new BlurAdapter(test)
		{
			@Override
			public void onBlur(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		Assertions.assertEquals("<div id=\"test\" ng-blur=\"jwCntrl.perform($event,[],'za_co_mmagon_jwebswing_events_blur_BlurAdapterTest$1','za.co.mmagon.jwebswing.events.blur.BlurAdapterTest$1');\"></div>", test.toString(0));
	}

	@Test
	public void testDirective()
	{
		Div test = new DivSimple<>();
		test.getPage().getAngular().getAngularDirectives().clear();
		test.setID("test");
		BlurAdapter aa = new BlurAdapter(test)
		{
			@Override
			public void onBlur(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		System.out.println(test.getPage().getAngular().getAngularDirectives());
		Assertions.assertEquals(0, test.getPage().getAngular().getAngularDirectives().size());
	}
}
