/**
 * 
 */
package ca.footeware.propertiesbug.test.adapters;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;

import ca.footeware.propertiesbug.test.model.Foo;
import ca.footeware.propertiesbug.test.views.TestView;

/**
 *
 */
public class TestViewPropertySheetPage implements IPropertySheetPage {
	private TestView view;
	private Composite container;
	private Text text;

	public TestViewPropertySheetPage(TestView view) {
		this.view = view;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.part.IPage#createControl(org.eclipse.swt.widgets.Composite
	 * )
	 */
	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(2, false));
		
		Label label = new Label(container, SWT.NONE);
		label.setText("Selected:");
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		
		text = new Text(container, SWT.BORDER | SWT.READ_ONLY);
		text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.IPage#dispose()
	 */
	@Override
	public void dispose() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.IPage#getControl()
	 */
	@Override
	public Control getControl() {
		return container;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.IPage#setActionBars(org.eclipse.ui.IActionBars)
	 */
	@Override
	public void setActionBars(IActionBars actionBars) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.IPage#setFocus()
	 */
	@Override
	public void setFocus() {
		if (text != null && !text.isDisposed()) {
			text.setFocus();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.
	 * IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (part == view) {
			if (selection.isEmpty()) {
				text.setText("");
			} else if (selection instanceof IStructuredSelection) {
				Object firstElement = ((IStructuredSelection) selection)
						.getFirstElement();
				if (firstElement instanceof Foo) {
					Foo foo = (Foo) firstElement;
					text.setText(foo.getName());
				}
			} else {
				text.setText("Error: selection=" + selection);
			}
		}
		else
		{
			text.setText("Error: part=" + part);
		}
	}
}
