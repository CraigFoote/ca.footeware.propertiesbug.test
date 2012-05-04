/**
 * 
 */
package ca.footeware.propertiesbug.test.model;

/**
 *
 */
public class Foo {
	private String name;	
	
	/**
	 * Constructor.
	 * @param name {@link String}
	 */
	public Foo(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setLabel(String label) {
		this.name = label;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
