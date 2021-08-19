package demo.collection;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

class TestedClass {
	

	// 实例初始值设定项
	{final String GROUP = "home";
	 int aa = 1;

	}

	public static void main(String[] args) {
		TestedInterface.NestedClass1 tini1;
		
	}

	public void getMe() {

	}

	class Cyclic {
	}

	void foo() {
		new Cyclic(); // create a Global.Cyclic

		/*
		 * class Cyclic extends Cyclic { } // circular definition
		 */

		{
			class Local {
			}

			/*
			 * { class Local { } // compile-time error }
			 */

			/*
			 * class Local { } // compile-time error
			 */
			class AnotherLocal {
				void bar() {
					class Local {
					} // ok
				}
			}
		}
		class Local {
		} // ok, not in scope of prior Local
	}
}
