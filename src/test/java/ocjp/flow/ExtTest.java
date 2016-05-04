package ocjp.flow;

class ExtTest {

	public static void main(String[] args) {
		final String a = null;
		try {
			String arg = args[0];
		} catch (Exception e) {
			try {
				String arg2 = args[1];
			} catch (Exception e2) {

			} finally {
				System.out.println("block 1");
			}
		} finally {
			System.out.println("block 2");
		}
		
		String name = null; assert(name != null);
//		int i = 10; assert(i=15+i++);
		boolean flag = false; assert (flag = true);
		String s = null; assert false : s;
		
	}

}
