package globalFunctionality.actions.junit;

import junit.framework.*;

public class Assertions {
	@SuppressWarnings("deprecation")
	public static void AssertEqualsTrue(boolean actual){
		Assert.assertEquals(true, actual);
	}
}
