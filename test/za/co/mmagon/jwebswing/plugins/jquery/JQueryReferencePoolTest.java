package za.co.mmagon.jwebswing.plugins.jquery;

import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;

class JQueryReferencePoolTest extends BaseTestClass
{
	@Test
	void getJavaScriptReference()
	{
		JQueryReferencePool jr = JQueryReferencePool.JQueryV2;
		System.out.println(jr.toString());
		System.out.println(jr.getJavaScriptReference().toString());
	}

}