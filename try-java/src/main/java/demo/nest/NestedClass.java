package demo.nest;

class NestedClass {
	

	// 实例初始值设定项
	{final String GROUP = "home";
	 int aa = 1;

	}

	public static void main(String[] args) {
		NestedInterface.NestedClass1 tini1;
		
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
